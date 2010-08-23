package com.dudhoo.nemesis.swing.movimentoEstoque;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.component.BotaoFindPessoa;
import com.dudhoo.nemesis.component.BotaoFindProduto;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.ContaPagar;
import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.hibernate.MovimentoEstoque;
import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.hibernate.abstracts.ContaFinanceira;
import com.dudhoo.nemesis.swing.JPanelObservacoes;

import com.toedter.calendar.JDateChooser;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PanelMovimentacaoEstoque extends JPanel{

    private TIPO tipo;

    public enum TIPO{
	SAIDA,
	ENTRADA,
	;
    }


    private MovimentoEstoque movimentoEstoque;

    private JPanelObservacoes jPanelObservacoes1 = new JPanelObservacoes();
    private BotaoFindPessoa botaoFindPessoa1 = new BotaoFindPessoa();
    private JTextField jTextFieldPrecoUnit = new JTextField();
    private JCheckBox jCheckBoxPago = new JCheckBox();
    private BotaoFindProduto botaoFindProduto = new BotaoFindProduto();
    private JTextField jTextFieldQuantidade = new JTextField();
    private JLabel jLabel1 = new JLabel();
    private JLabel jLabel2 = new JLabel();
    private JLabel jLabel3 = new JLabel();
    private JLabel jLabel4 = new JLabel();
    private JDateChooser jDateChooser1 = new JDateChooser();
    private JLabel jLabelData = new JLabel();

    public PanelMovimentacaoEstoque(PanelMovimentacaoEstoque.TIPO tipo){
	try{
	    this.tipo = tipo;
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    public MovimentoEstoque getMovimentoEstoque() throws ValidationException{
	if(movimentoEstoque == null){
	    movimentoEstoque = new MovimentoEstoque();
	    if(tipo == tipo.ENTRADA){
		movimentoEstoque.setConta(new ContaPagar());	
	    }else{
		movimentoEstoque.setConta(new ContaReceber());		
	    }
	    
	}
	Pessoa pes = botaoFindPessoa1.getPessoa();
	Produto prod = botaoFindProduto.getProduto();

	long precoUnitario = Long.parseLong(this.jTextFieldPrecoUnit.getText());
	long quan = Long.parseLong(this.jTextFieldQuantidade.getText());
	//validations exception here
	if(pes == null){
	    throw new ValidationException("Selecione uma pessoa");
	} else if(prod == null){
	    throw new ValidationException("Selecione um produto");
	} else if(quan < 0){
	    throw new ValidationException("Quantidade não pode ser menor que zero");
	}
	movimentoEstoque.setObservacao(this.jPanelObservacoes1.getObs());
	movimentoEstoque.setPessoa(pes);
	movimentoEstoque.setProduto(prod);
	movimentoEstoque.setQuantidade(quan);
	movimentoEstoque.setUsuario(Application.getUsuarioLogado());
	movimentoEstoque.setPrecoUnitario(precoUnitario);

	ContaFinanceira conta = movimentoEstoque.getConta();
	conta.setDataPagamento(jDateChooser1.getDate());
	conta.setPessoa(pes);
	conta.setUsuario(Application.getUsuarioLogado());
	conta.setContaPaga(jCheckBoxPago.isSelected());
	conta.setValor(precoUnitario * quan);
	return movimentoEstoque;
    }

    public void setMovimentoEstoque(MovimentoEstoque movimentoEstoque){
	this.movimentoEstoque = movimentoEstoque;
	if(movimentoEstoque == null){
	    botaoFindPessoa1.setPessoa(null);
	    botaoFindProduto.setProduto(null);
	    jTextFieldPrecoUnit.setText(null);
	    jTextFieldQuantidade.setText(null);
	    jPanelObservacoes1.setObs(null);
	} else {
	    botaoFindPessoa1.setPessoa(movimentoEstoque.getPessoa());
	    botaoFindProduto.setProduto(movimentoEstoque.getProduto());
	    jTextFieldPrecoUnit.setText(String.valueOf(movimentoEstoque.getPrecoUnitario()));
	    jTextFieldQuantidade.setText(String.valueOf(movimentoEstoque.getQuantidade()));
	    jPanelObservacoes1.setObs(movimentoEstoque.getObservacao());
	    jDateChooser1.setDate(movimentoEstoque.getConta().getDataPagamento());
	    jCheckBoxPago.setSelected(movimentoEstoque.getConta().isContaPaga());
	}
    }

    private void jbInit() throws Exception{
	this.setLayout(null);
	this.setSize(new Dimension(394, 292));
	jPanelObservacoes1.setBounds(new Rectangle(30, 175, 355, 100));
	botaoFindPessoa1.setBounds(new Rectangle(85, 10, 255, 25));
	jTextFieldPrecoUnit.setBounds(new Rectangle(275, 70, 65, 20));
	jCheckBoxPago.setText("Compra foi paga");
	jCheckBoxPago.setBounds(new Rectangle(85, 100, 125, 20));
	jCheckBoxPago.setToolTipText("Se o produto for pago à vista, será gerado no contas automaticamente");
	botaoFindProduto.setBounds(new Rectangle(85, 40, 255, 25));
	jTextFieldQuantidade.setBounds(new Rectangle(85, 70, 80, 20));
	jLabel1.setText("Fornecedor:");
	jLabel1.setBounds(new Rectangle(5, 10, 70, 25));
	jLabel2.setText("Produto:");
	jLabel2.setBounds(new Rectangle(5, 40, 70, 25));
	jLabel3.setText("Quantidade");
	jLabel3.setBounds(new Rectangle(10, 70, 75, 20));
	jLabel4.setText("Preço Uni.");
	jLabel4.setBounds(new Rectangle(180, 70, 85, 20));
	jDateChooser1.setBounds(new Rectangle(190, 130, 150, 20));
	jLabelData.setText("Data Pagamento:");
	jLabelData.setBounds(new Rectangle(85, 130, 130, 20));
	this.add(jLabelData, null);
	this.add(jDateChooser1, null);
	this.add(jLabel4, null);
	this.add(jLabel3, null);
	this.add(jLabel2, null);
	this.add(jLabel1, null);
	this.add(jCheckBoxPago, null);
	this.add(jPanelObservacoes1, null);
	this.add(botaoFindPessoa1, null);
	this.add(jTextFieldPrecoUnit, null);
	this.add(botaoFindProduto, null);
	this.add(jTextFieldQuantidade, null);
    }

    public void setTipo(PanelMovimentacaoEstoque.TIPO tipo){
	this.tipo = tipo;
    }

    public PanelMovimentacaoEstoque.TIPO getTipo(){
	return tipo;
    }
}
