/*
 * JPanelPessoa.java
 *
 * Created on 15 de Fevereiro de 2006, 23:07
 */

package com.dudhoo.nemesis.swing.pessoa;

import com.dudhoo.evilframework.util.MaskUtil;
import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.swing.JPanelObservacoes;
import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.swing.enumerations.PessoaStatus;
import java.math.BigDecimal;
import javax.swing.JFormattedTextField;
import javax.swing.SpinnerNumberModel;


/**
 *
 * @author  duduzera
 */
public class JPanelPessoa extends javax.swing.JPanel {
    private Pessoa pessoa ;
    private JPanelObservacoes obs;
    /** Creates new form JPanelPessoa */
    public JPanelPessoa() {
        jbInit();
        //TODO adicionar observação com codigo
        initSpinnerVeiculos();
        initObser();
    }
    private void initObser(){
        obs = new JPanelObservacoes();
        this.jTabbedPane.add("Observções", obs);
    }
    private void initSpinnerVeiculos(){
        SpinnerNumberModel model = new SpinnerNumberModel();
        model.setMaximum(new Integer(99999));
        model.setMinimum(new Integer(0));
        this.jSpinnerVeiculos.setModel(model);
    }
    
    public Pessoa getPessoa() throws ValidationException, Exception{
        if(this.pessoa == null){
            this.pessoa = new Pessoa();
        }
        if(jDateChooserDataNasc.getDate() == null){
            throw new ValidationException("Data de nascimento não pode ser nula.");
        }else{
            if(jDateChooserDataNasc.getDate().after(java.util.Calendar.getInstance().getTime())) {
                throw new ValidationException("Data de nascimento tem que ser inferior ao dia atual.");
            }    
        }
        
        if( jTextFieldLimiteCredito.getText().length() < 1){
            throw new ValidationException("Você precisa especificar o limite de crédito da pessoa.");
        }        //TODO TROCAR O JTEXT DA TAXA DE JUROS E DO LIMITE DE CREDITO POR UM JFORMATTEDTEXTFIELD
        if(jTextFieldTaxaJurosDiaria.getText().length() < 1){
            throw new ValidationException("Você precisa especificar a taxa de juros diária aplicada à pessoa.");
        }
        
        
        //TODO encontrar uma maneira de forçar o usuario especificar a quantidade de carros, o componente deixa já o padrão
        pessoa.setCelular(this.jTextFieldCelular.getText().trim());
        pessoa.setDataNascimento(jDateChooserDataNasc.getDate());
        pessoa.setDataVerificaoCredito( jDateChooserDataVerCredito.getDate() );
        pessoa.setEmail(this.jTextFieldEmail.getText());
        pessoa.setFax(this.jTextFieldFax.getText().trim());
        pessoa.setInstalacaoOuCasaPropria(this.jCheckBoxCasaPropria.isSelected());
        pessoa.setLimiteCredito(new BigDecimal(this.jTextFieldLimiteCredito.getText() ));
        pessoa.setObservacao(this.obs.getObs());
        pessoa.setQuantidadeVeiculos(Integer.parseInt(this.jSpinnerVeiculos.getValue().toString()));
        pessoa.setSite(this.jTextFieldWebsite.getText().trim());
        pessoa.setStatus((this.jCheckBoxBloqueadoVendas.isSelected() ?
            PessoaStatus.BLOQUEADO.getValue() : PessoaStatus.ATIVO.getValue()));
        if( this.jTextFieldTaxaJurosDiaria.getText().length() > 0){
            pessoa.setTaxaJurosDiaria(new BigDecimal(this.jTextFieldTaxaJurosDiaria.getText()));
        }else{
            pessoa.setTaxaJurosDiaria(new BigDecimal(0));
        }
        pessoa.setTelefoneComercial(this.jTextFieldTelComercial.getText().trim());
        pessoa.setUltMod(java.util.Calendar.getInstance().getTime()) ;
        pessoa.setUsuario(Application.getUsuarioLogado());
        return pessoa;
    }
    
    public void setPessoa(Pessoa _p){
        this.pessoa = _p;
        if(pessoa != null){
            this.jTextFieldCelular.setText(pessoa.getCelular() );
            this.jTextFieldEmail.setText(pessoa.getEmail());
            jTextFieldFax.setText(pessoa.getFax());
            jTextFieldLimiteCredito.setText(pessoa.getLimiteCredito().toString() );
            jTextFieldTaxaJurosDiaria.setText(pessoa.getTaxaJurosDiaria().toString());
            jTextFieldTelComercial.setText(pessoa.getTelefoneComercial() );
            jTextFieldWebsite.setText(pessoa.getSite());
            if(pessoa.getStatus() == PessoaStatus.BLOQUEADO.getValue()){
                jCheckBoxBloqueadoVendas.setSelected(true);
            } else{
                jCheckBoxBloqueadoVendas.setSelected(false);
            }
            jCheckBoxCasaPropria.setSelected(pessoa.isInstalacaoOuCasaPropria());
            jDateChooserDataVerCredito.setDate( pessoa.getDataVerificaoCredito() );
            jDateChooserDataNasc.setDate(pessoa.getDataNascimento());
            jSpinnerVeiculos.setValue(pessoa.getQuantidadeVeiculos());
            this.obs.setObs(pessoa.getObservacao());
        }else{            
            this.jTextFieldCelular.setText(null);
            this.jTextFieldEmail.setText(null);
            jTextFieldFax.setText(null);
            jTextFieldLimiteCredito.setText(null );
            jTextFieldTaxaJurosDiaria.setText(null);
            jTextFieldTelComercial.setText(null);
            jTextFieldWebsite.setText(null);
            jCheckBoxBloqueadoVendas.setSelected(false);            
            jCheckBoxCasaPropria.setSelected(false);
            jSpinnerVeiculos.setValue(null);
            this.obs.setObs(null);
        }
        
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:jbInit
    private void jbInit() {
        jLabelDataNascimento = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldTelComercial = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldFax = new javax.swing.JTextField();
        jTextFieldCelular = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldWebsite = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jTextFieldTaxaJurosDiaria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldLimiteCredito = new javax.swing.JTextField();
        jCheckBoxBloqueadoVendas = new javax.swing.JCheckBox();
        jDateChooserDataVerCredito = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jCheckBoxCasaPropria = new javax.swing.JCheckBox();
        jSpinnerVeiculos = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jDateChooserDataNasc = new com.toedter.calendar.JDateChooser();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setBorder(new javax.swing.border.TitledBorder("Informa\u00e7\u00f5es da Pessoa:"));
        jLabelDataNascimento.setText("Data Nasc:");
        add(jLabelDataNascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.TitledBorder("Info. Contato"));
        jPanel1.add(jTextFieldTelComercial, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 230, -1));

        jLabel1.setText("Tel. Comercial:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jLabel2.setText("Fax:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        jPanel1.add(jTextFieldFax, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 230, -1));

        jPanel1.add(jTextFieldCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 230, -1));

        jLabel3.setText("Celular:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jPanel1.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 230, -1));

        jLabel4.setText("Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jPanel1.add(jTextFieldWebsite, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 230, -1));

        jLabel5.setText("Website:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 360, 180));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldTaxaJurosDiaria.setText("0");
        jPanel2.add(jTextFieldTaxaJurosDiaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 200, -1));

        jLabel6.setText("Taxa Juros Di\u00e1ria:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jLabel7.setText("Data Ver. Cr\u00e9dito");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jLabel9.setText("Limite Cr\u00e9dito:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        jTextFieldLimiteCredito.setText("0");
        jPanel2.add(jTextFieldLimiteCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 200, -1));

        jCheckBoxBloqueadoVendas.setFont(new java.awt.Font("Tahoma", 1, 11));
        jCheckBoxBloqueadoVendas.setText("Bloqueado para vendas.");
        jCheckBoxBloqueadoVendas.setToolTipText("Marque a op\u00e7\u00e3o se for verdadeiro");
        jPanel2.add(jCheckBoxBloqueadoVendas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        jPanel2.add(jDateChooserDataVerCredito, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 190, 20));

        jTabbedPane.addTab("Cr\u00e9dito", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCheckBoxCasaPropria.setText("Possue casa ou instala\u00e7\u00f5es pr\u00f3prias.");
        jCheckBoxCasaPropria.setToolTipText("Marque a op\u00e7\u00e3o se for verdadeiro");
        jPanel3.add(jCheckBoxCasaPropria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel3.add(jSpinnerVeiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 70, -1));

        jLabel8.setText("Quantidade de ve\u00edculos");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, 20));

        jTabbedPane.addTab("Extras", jPanel3);

        add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 370, 150));

        add(jDateChooserDataNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 220, 20));

    }
    // </editor-fold>//GEN-END:jbInit
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxBloqueadoVendas;
    private javax.swing.JCheckBox jCheckBoxCasaPropria;
    private com.toedter.calendar.JDateChooser jDateChooserDataNasc;
    private com.toedter.calendar.JDateChooser jDateChooserDataVerCredito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinnerVeiculos;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextFieldCelular;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFax;
    private javax.swing.JTextField jTextFieldLimiteCredito;
    private javax.swing.JTextField jTextFieldTaxaJurosDiaria;
    private javax.swing.JTextField jTextFieldTelComercial;
    private javax.swing.JTextField jTextFieldWebsite;
    // End of variables declaration//GEN-END:variables
    
}
