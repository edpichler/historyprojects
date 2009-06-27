/*
 * JPanelEstado.java
 *
 * Created on 14 de Fevereiro de 2006, 21:33
 */

package com.dudhoo.nemesis.swing.cidadesRegioes;

import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.Estado;

/**
 *
 * @author  duduzera
 */
public class JPanelEstado extends javax.swing.JPanel {
    private Estado es;
    /** Creates new form JPanelEstado */
    public JPanelEstado() {
        jbInit();
    }

    public Estado getEstado() throws ValidationException{
        if(es == null){
            es = new Estado();
        }
        String sigla = this.jTextFieldSiglaEstado.getText().trim().toUpperCase();
        String nome = this.jTextFieldNomeEstado.getText().trim();
        if(nome.length() < 1){
            throw new ValidationException("Informe o nome do estado corretamente.");
        }else if(sigla.length() < 1){
            throw new ValidationException("Informe a sigla do estado corretamente.");
        }
        es.setNome(nome);
        es.setSigla(sigla);        
        return es;
    }

    public void setEstado(Estado es) {
        this.es = es;
        this.jTextFieldNomeEstado.setText(es.getNome());
        this.jTextFieldSiglaEstado.setText(es.getSigla());
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:jbInit
    private void jbInit() {
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeEstado = new javax.swing.JTextField();
        jTextFieldSiglaEstado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setBorder(new javax.swing.border.TitledBorder("Estado"));
        jLabel1.setText("Nome:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 20));

        add(jTextFieldNomeEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, -1));

        add(jTextFieldSiglaEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 200, -1));

        jLabel2.setText("Sigla:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 50, -1));

    }
    // </editor-fold>//GEN-END:jbInit
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldNomeEstado;
    private javax.swing.JTextField jTextFieldSiglaEstado;
    // End of variables declaration//GEN-END:variables
    
}