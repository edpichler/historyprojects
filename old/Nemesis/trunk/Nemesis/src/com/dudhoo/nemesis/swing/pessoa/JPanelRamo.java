/*
 * JPanelRamo.java
 *
 * Created on 15 de Fevereiro de 2006, 22:23
 */

package com.dudhoo.nemesis.swing.pessoa;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import com.dudhoo.nemesis.swing.ramos.JDialogFindRamo;
import com.dudhoo.nemesis.hibernate.Ramo;
import com.dudhoo.nemesis.hibernate.RamoHome;

/**
 *
 * @author  duduzera
 */
public class JPanelRamo extends javax.swing.JPanel {
    private Ramo ramo = null;
    /** Creates new form JPanelRamo */
    public JPanelRamo() {
        try {
            jbInit();
        } catch (Exception e) {
            // TODO
            e.printStackTrace();
        }
    }
    
    public Ramo getRamo() throws ValidationException{
        if(ramo == null){
            throw new ValidationException("Ramo não pode ser nulo");
        }
        return ramo;
    }
    
    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
        refreshRamo();
    }
    private void refreshRamo(){
        if(ramo == null){
            limpa();
        }else{
            this.jTextAreaDescricao.setText(ramo.getDescricao());
            this.jTextFieldNome.setText(ramo.getNome());
        }
    }
    //TODO CRIAR UM MÉTODO LIMPA QUE VARRE TODOS OS COMPONENTES DO FORM E TIRE OS TEXTOS DO MESMO
    private void limpa(){
        this.jTextAreaDescricao.setText(null);
        this.jTextFieldNome.setText(null);
    }
    
    private void jbInit() throws Exception{
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        botaoProcurar = new com.dudhoo.evilframework.components.BotaoProcurar16();
        botaoLimpar161 = new com.dudhoo.evilframework.components.BotaoLimpar16();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setBorder(new javax.swing.border.TitledBorder("Ramo de atua\u00e7\u00e3o"));
        setName("Ramo");
        jLabel1.setText("Nome:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 20));

        jTextFieldNome.setEditable(false);
        add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 270, -1));

        jLabel2.setText("Descri\u00e7\u00e3o:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 20));

        jTextAreaDescricao.setEditable(false);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 50, 290, 60));

        botaoProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProcurarActionPerformed(evt);
            }
        });

        add(botaoProcurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, 30, 20));

        botaoLimpar161.setToolTipText("Limpar");
        botaoLimpar161.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimpar161ActionPerformed(evt);
            }
        });

        add(botaoLimpar161, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 20, 20));

    }
    

    private void botaoLimpar161ActionPerformed(java.awt.event.ActionEvent evt) {
        this.setRamo(null);
    }
    
    private void botaoProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProcurarActionPerformed
        findRamo();
    }
    
    private void findRamo(){
        JDialogFindRamo ramf = new JDialogFindRamo(StartFrame.getCurrentInstance(), true);        
        ramf.setVisible(true);
        if(ramf.getOpcao() == OpcaoEscolhida.SELECT){
            RamoHome h = new RamoHome();
            try{
                Ramo temp = h.findById(ramf.getIdRamo());
                this.setRamo(temp);
            }catch(Exception xxx){
                new com.dudhoo.evilframework.swing.EvilError(StartFrame.getCurrentInstance(), false, xxx).setVisible(true);
            }
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.dudhoo.evilframework.components.BotaoLimpar16 botaoLimpar161;
    private com.dudhoo.evilframework.components.BotaoProcurar16 botaoProcurar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JTextField jTextFieldNome;
    // End of variables declaration//GEN-END:variables
    
}
