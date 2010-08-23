package com.dudhoo.farmaco.swing;

import com.dudhoo.evilframework.components.BotaoCancelar20;
import com.dudhoo.evilframework.components.BotaoSalvar20;
import com.dudhoo.farmaco.dto.PrincipioAtivo;
import com.dudhoo.farmaco.swing.component.JPanelApreFarmaceutica;
import com.dudhoo.farmaco.swing.component.JPanelContraIndicacao;
import com.dudhoo.farmaco.swing.component.JPanelCuidadosEspeciais;
import com.dudhoo.farmaco.swing.component.JPanelDescricao;
import com.dudhoo.farmaco.swing.component.JPanelIndicacao;
import com.dudhoo.farmaco.swing.component.JPanelInteracao;
import com.dudhoo.farmaco.swing.component.JPanelPrecaucao;
import com.dudhoo.farmaco.swing.component.JPanelReacaoAdversa;
import com.dudhoo.farmaco.swing.event.SalvarListener;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class PanelAdminPrincipioAtivo extends JPanel{
    private JLabel jLabel1 = new JLabel();
    private JTextField jTextFieldNome = new JTextField();
    private JTabbedPane jTabbedPane1 = new JTabbedPane();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JScrollPane jScrollPane3 = new JScrollPane();
    private JScrollPane jScrollPane4 = new JScrollPane();
    private JScrollPane jScrollPane5 = new JScrollPane();
    private JScrollPane jScrollPane6 = new JScrollPane();
    private BotaoSalvar20 botaoSalvar201 = new BotaoSalvar20();
    private BotaoCancelar20 botaoCancelar201 = new BotaoCancelar20();
    private JPanelDescricao jPanelDescricaoPrincipioAtivo = new JPanelDescricao();
    private JPanelIndicacao jPanelIndic = new JPanelIndicacao();
    private JPanelContraIndicacao jPanelContraIndica = new JPanelContraIndicacao();
    private JPanelPrecaucao jPanePrecau = new JPanelPrecaucao();
    private JPanelInteracao jPanelInterac = new JPanelInteracao();
    private JPanelCuidadosEspeciais jPanelCuidEsp = new JPanelCuidadosEspeciais();
    private JPanelApreFarmaceutica jPanelAppFarmac = new JPanelApreFarmaceutica();
    private GridBagLayout gridBagLayout1 = new GridBagLayout();
    private PrincipioAtivo principio  = null;
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JPanelReacaoAdversa jPanelReacoesAdv = new JPanelReacaoAdversa();

    public PanelAdminPrincipioAtivo(String panelName){
	this.setName(panelName);
	try{
	    jbInit();	    
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(770, 560));
	this.setLayout(gridBagLayout1);
	jLabel1.setText("Princípio Ativo");
	botaoSalvar201.addActionListener(new SalvarListener(this));
	botaoCancelar201.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoCancelar201_actionPerformed(e);
		    }
		});
	jScrollPane2.getViewport().add(jPanelIndic, null);
	jTabbedPane1.addTab("Indicação", jScrollPane2);
	jScrollPane3.getViewport().add(jPanelContraIndica, null);
	jTabbedPane1.addTab("Contra-indicação", jScrollPane3);
	jScrollPane4.getViewport().add(jPanePrecau, null);
	jTabbedPane1.addTab("Precaução", jScrollPane4);
	jScrollPane5.getViewport().add(jPanelInterac, null);
	jTabbedPane1.addTab("Interação", jScrollPane5);
	jScrollPane6.getViewport().add(jPanelCuidEsp, null);
	jTabbedPane1.addTab("Cuidados especiais", jScrollPane6);
	jScrollPane1.getViewport().add(jPanelReacoesAdv, null);
	jTabbedPane1.addTab("Reações adversas", jScrollPane1);
	jTabbedPane1.addTab("Apres. Farmac. e Posologias", jPanelAppFarmac);

	this.add(jPanelDescricaoPrincipioAtivo,
	  new GridBagConstraints(0, 1, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER,
			  GridBagConstraints.BOTH, new Insets(10, 10, 0, 25), 694, 44));
	this.add(botaoCancelar201,
	  new GridBagConstraints(1, 3, 1, 1, 1.1, 0.0, GridBagConstraints.EAST,
			  GridBagConstraints.NONE, new Insets(10, 0, 10, 0), 16, -3));
	this.add(botaoSalvar201,
	  new GridBagConstraints(2, 3, 1, 1, 0.01, 0.0, GridBagConstraints.EAST,
			  GridBagConstraints.NONE, new Insets(10, 10, 10, 25), 28, -3));
	this.add(jTabbedPane1,
	  new GridBagConstraints(0, 2, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER,
			  GridBagConstraints.BOTH, new Insets(0, 10, 0, 25), 572, 153));
	this.add(jTextFieldNome,
	  new GridBagConstraints(1, 0, 2, 1, 1.0, 0.0, GridBagConstraints.WEST,
			  GridBagConstraints.HORIZONTAL, new Insets(10, 10, 0, 25), 608, -1));
	this.add(jLabel1,
	  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
			  GridBagConstraints.NONE, new Insets(10, 10, 0, 0), 42, 5));
    }

    private void botaoCancelar201_actionPerformed(ActionEvent e){
	close();
    }

    public void close(){
	Object o = this;
	this.getParent().remove( (Component) o);
	o = null;
    }

    public PrincipioAtivo getPrincipioAtivo(){
	if(this.principio == null){
	    principio = new PrincipioAtivo();
	}
	principio.setDescricao(this.jPanelDescricaoPrincipioAtivo.getDescricao());
	principio.setNome(this.jTextFieldNome.getText());
	principio.setIndicacao(this.jPanelIndic.getIndicacao());
	principio.setContraIndicacao(this.jPanelContraIndica.getContraIndicacao());
	principio.setPrecaucao(this.jPanePrecau.getPrecaucao());
	principio.setInteracao(this.jPanelInterac.getInteracao());
	principio.setCuidadosEspec(this.jPanelCuidEsp.getCuidadosEspeciais());
	principio.setReacaoAdversa(this.jPanelReacoesAdv.getReacaoAdversa());
	principio.setApresentacaoFarmaceutica(this.jPanelAppFarmac.getApresentacaoFarmaceutica() );
	return principio;
    }

    public void setSetPrincipioAtivo(PrincipioAtivo princ){
	this.principio = princ;
	if(princ == null){
	    this.jPanelDescricaoPrincipioAtivo.setDescricao(null);
	    this.jTextFieldNome.setText(null);
	    this.jPanelIndic.setIndicacao(null);
	    this.jPanelContraIndica.setContraIndicacao(null);
	    this.jPanePrecau.setPrecaucao(null);
	    this.jPanelInterac.setInteracao(null);
	    this.jPanelCuidEsp.setCuidadosEspeciais(null);
	    this.jPanelReacoesAdv.setReacaoAdversa(null);
	    this.jPanelAppFarmac.setApresentacaoFarmaceutica(null);
	}else{
	    this.jPanelDescricaoPrincipioAtivo.setDescricao(princ.getDescricao());
	    this.jTextFieldNome.setText(princ.getNome());
	    this.jPanelIndic.setIndicacao(princ.getIndicacao());
	    this.jPanelContraIndica.setContraIndicacao(princ.getContraIndicacao());
	    this.jPanePrecau.setPrecaucao(princ.getPrecaucao());
	    this.jPanelInterac.setInteracao(princ.getInteracao());
	    this.jPanelCuidEsp.setCuidadosEspeciais(princ.getCuidadosEspec());
	    this.jPanelReacoesAdv.setReacaoAdversa(princ.getReacaoAdversa());
	    this.jPanelAppFarmac.setApresentacaoFarmaceutica(princ.getApresentacaoFarmaceutica());	    
	}	
    }
}
