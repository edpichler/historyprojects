package com.dudhoo.nemesis.swing.pessoa;

import com.dudhoo.evilframework.components.BotaoProcurar16;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.PessoaFisica;
import com.dudhoo.nemesis.hibernate.PessoaFisicaHome;
import com.dudhoo.nemesis.hibernate.enums.EstadoCivilConstants;

import com.dudhoo.nemesis.swing.StartFrame;

import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;

import java.awt.Dimension;
import java.awt.Rectangle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class JPanelPessoaFisica extends JPanel{
    private PessoaFisica pessoaFisica = null;
    private Long idConjuge;

    private JLabel jLabelNome = new JLabel();
    private JTextField jTextFieldNome = new JTextField();
    private JLabel jLabelSobrenome = new JLabel();
    private JLabel jLabelRg = new JLabel();
    private JLabel jLabelTelRes = new JLabel();
    private JLabel jLabelConjuge = new JLabel();
    private JLabel jLabelEstadoCivil = new JLabel();
    private JLabel jLabelProfissao = new JLabel();
    private JPanel jPanelSexo = new JPanel();
    private JRadioButton jRadioButtonMasc = new JRadioButton();
    private JRadioButton jRadioButtonFem = new JRadioButton();
    private JTextField jTextFieldSobrenome = new JTextField();
    private JTextField jTextFieldConjuge = new JTextField();
    private JComboBox jComboBoxEstCivil = new JComboBox();
    private JTextField jTextFieldProfissao = new JTextField();
    private JTextField jTextFieldTelResidencial = new JTextField();
    private JTextField jTextFieldRg = new JTextField();
    private BotaoProcurar16 botaoProcurar161 = new BotaoProcurar16();
    private JTextField jTextFieldCpf = new JTextField();
    private JLabel jLabelCpf = new JLabel();

    public JPanelPessoaFisica(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setLayout(null);
	this.setSize(new Dimension(385, 301));
	jLabelNome.setText("Nome:");
	jLabelNome.setBounds(new Rectangle(15, 5, 90, 20));
	jTextFieldNome.setBounds(new Rectangle(130, 5, 210, 20));
	jLabelSobrenome.setText("Sobrenome:");
	jLabelSobrenome.setBounds(new Rectangle(15, 25, 90, 20));
	jLabelRg.setText("Rg:");
	jLabelRg.setBounds(new Rectangle(15, 140, 90, 20));
	jLabelTelRes.setText("Tel. Residencial:");
	jLabelTelRes.setBounds(new Rectangle(15, 170, 90, 20));
	jLabelConjuge.setText("Conjuge:");
	jLabelConjuge.setBounds(new Rectangle(15, 200, 90, 20));
	jLabelEstadoCivil.setText("Estado Civil:");
	jLabelEstadoCivil.setBounds(new Rectangle(15, 230, 90, 20));
	jLabelProfissao.setText("Profissão:");
	jLabelProfissao.setBounds(new Rectangle(15, 260, 90, 20));
	jPanelSexo.setBounds(new Rectangle(130, 55, 210, 55));
	jPanelSexo.setBorder(BorderFactory.createTitledBorder("Sexo"));
	jRadioButtonMasc.setText("Masculino");
	jRadioButtonMasc.setSelected(true);
	jRadioButtonFem.setText("Feminino");
	jTextFieldSobrenome.setBounds(new Rectangle(130, 30, 210, 20));
	jTextFieldConjuge.setBounds(new Rectangle(135, 200, 180, 20));
	jTextFieldConjuge.setEditable(false);
	jComboBoxEstCivil.setBounds(new Rectangle(135, 230, 210, 20));
	jComboBoxEstCivil.setEditable(true);
	jTextFieldProfissao.setBounds(new Rectangle(135, 260, 210, 20));
	jTextFieldTelResidencial.setBounds(new Rectangle(135, 170, 210, 20));
	jTextFieldRg.setBounds(new Rectangle(135, 140, 210, 20));
	botaoProcurar161.setBounds(new Rectangle(315, 200, 30, 20));
	botaoProcurar161.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoProcurar161_actionPerformed(e);
		    }
		});
	jTextFieldCpf.setBounds(new Rectangle(135, 115, 210, 20));
	jLabelCpf.setText("CPF:");
	jLabelCpf.setBounds(new Rectangle(15, 115, 25, 20));
	jPanelSexo.add(jRadioButtonMasc, null);
	jPanelSexo.add(jRadioButtonFem, null);
	this.add(jLabelCpf, null);
	this.add(jTextFieldCpf, null);
	this.add(botaoProcurar161, null);
	this.add(jTextFieldRg, null);
	this.add(jTextFieldTelResidencial, null);
	this.add(jTextFieldProfissao, null);
	this.add(jComboBoxEstCivil, null);
	this.add(jTextFieldConjuge, null);
	this.add(jTextFieldSobrenome, null);
	this.add(jPanelSexo, null);
	this.add(jLabelProfissao, null);
	this.add(jLabelEstadoCivil, null);
	this.add(jLabelConjuge, null);
	this.add(jLabelTelRes, null);
	this.add(jLabelRg, null);
	this.add(jLabelSobrenome, null);
	this.add(jTextFieldNome, null);
	this.add(jLabelNome, null);
	adicionaEstadosCivis();
	initButtonGroup();
    }

    private void initButtonGroup(){
	ButtonGroup group = new ButtonGroup();
	group.add(jRadioButtonFem);
	group.add(jRadioButtonMasc);
    }

    public PessoaFisica getPessoaFisica() throws ValidationException{
	if(this.pessoaFisica == null){
	    this.pessoaFisica = new PessoaFisica();
	}
	populatePessoaFisica(this.pessoaFisica);

	return this.pessoaFisica;
    }

    void setPessoaFisica(PessoaFisica _pessoaFisica) throws Exception{
	this.pessoaFisica = _pessoaFisica;
	if(this.pessoaFisica != null){
	    this.jTextFieldCpf.setText(pessoaFisica.getCpf());
	    EstadoCivilConstants ecc =  EstadoCivilConstants.valueOf( pessoaFisica.getEstadoCivil() );
	    this.jComboBoxEstCivil.setSelectedItem(ecc);
	    this.jTextFieldNome.setText( pessoaFisica.getNome());
	    this.jTextFieldProfissao.setText(pessoaFisica.getProfissao());
	    this.jTextFieldRg.setText(pessoaFisica.getRg());
	    this.jTextFieldSobrenome.setText(pessoaFisica.getSobrenome());
	    this.jTextFieldTelResidencial.setText(pessoaFisica.getTelefoneResidencial());
	    this.jRadioButtonMasc.setSelected(this.pessoaFisica.isSexo());  
	    if(pessoaFisica.getConjugeId() != null){
		setarConjugeNameNosFields(pessoaFisica.getConjugeId());
	    }
	}
    }

    /**s
     * Preenche a pessoa fisica com os dados do panelMovimentacaoEstoque
     */
    private void populatePessoaFisica(PessoaFisica pf) throws ValidationException{

	pf.setConjugeId(idConjuge); //TODO AO PROCURAR CONJUGE SETA NO ATRIBUTO DO FORM

	String cpf = this.jTextFieldCpf.getText().trim();
	if(cpf.length() < 1){
	    throw new ValidationException("Digite seu CPF.");
	}
	pf.setCpf(cpf);

	EstadoCivilConstants estado =
	    (EstadoCivilConstants)jComboBoxEstCivil.getSelectedItem();
	if(estado == null){
	    throw new ValidationException("Selecione o estado civil.");
	}
	pf.setEstadoCivil(estado.getValue());

	String nome = this.jTextFieldNome.getText().trim();
	if(nome.length() < 1){
	    throw new ValidationException("Insira o nome corretamente.");
	}
	pf.setNome(nome);

	pf.setProfissao(this.jTextFieldProfissao.getText().trim());
	//TODO MUDAR PRA UMA TABELA DE PROFISSOES, preencher tabela com os dados do bd do gmail que eu tenho guardadeo

	String rg = this.jTextFieldRg.getText().trim();
	if(rg.length() < 1){ //TODO VALIDAR RG 8 CARACTERES EM AMBIENTE CORPORATIVO
	    throw new ValidationException("Insira o RG corretamente.");
	}
	pf.setRg(rg);

	boolean masc = this.jRadioButtonMasc.isSelected();
	pf.setSexo(masc);

	String undernome = this.jTextFieldSobrenome.getText().trim();
	if(undernome.length() < 1){
	    throw new ValidationException("Insira o sobrenome corretamente.");
	}
	pf.setSobrenome(undernome);
	pf.setTelefoneResidencial(this.jTextFieldTelResidencial.getText());
    }
    //TODO FUTURAMENTE ESTUDAR O APACHE COMONS PARA VER O PACOTE DE AUXILIO À VALIDAÇÃO POR XML, PRA FICAR FLEXÍVEL AS VALIDAÇÕES

    /**
     * Adiciona estados civis no combo
     * */
    private void adicionaEstadosCivis(){
	javax.swing.DefaultComboBoxModel model;
	model = new javax.swing.DefaultComboBoxModel(EstadoCivilConstants.values());
	this.jComboBoxEstCivil.setModel(model);
    }

    private void setarConjugeNameNosFields(long id) throws Exception{
	PessoaFisicaHome ph = new PessoaFisicaHome();
	try{
	    PessoaFisica pf = ph.findById(id);
	    if(pf == null){
		new EvilInformation(this).showMessage("Não foi encontrado o " +
		"conjuge selecionado, talvez alguem tenha removido " +
		"em outro computador da rede segundos " +
		"após você selecioná-lo. Verifique se ele ainda existe e tente novamente.");
	    }else{
		this.jTextFieldConjuge.setText(pf.getNome() + " " + pf.getSobrenome());		
	    }
	}catch(Exception e){
	    throw e;
	}finally  {
	    ph.closeSession();
	    ph = null;
	}
    }

    private void botaoProcurar161_actionPerformed(ActionEvent e){
	try  {
	    JDialogFindPessoaFisica dialog =
	        new JDialogFindPessoaFisica(StartFrame.getCurrentInstance(), true);
	    dialog.pack();
	    dialog.setLocationRelativeTo(null);
	    dialog.setVisible(true);
	    
	    if(dialog.getOpcao() == OpcaoEscolhida.SELECT){
	        Long id = dialog.getIdSelected();
	        if(id != null){
	            this.idConjuge = id;
		    setarConjugeNameNosFields(id);
	        }
	    }
	} catch (Exception ex)  {
	    new EvilError(null, false, ex);
	}
    }
}