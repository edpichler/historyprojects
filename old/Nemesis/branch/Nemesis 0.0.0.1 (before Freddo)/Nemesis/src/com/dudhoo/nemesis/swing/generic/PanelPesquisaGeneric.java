/*
 * PanelPesquisaGeneric.java
 *
 * Created on 26 de Janeiro de 2006, 20:44
 */

package com.dudhoo.nemesis.swing.generic;


import com.dudhoo.evilframework.components.BotaoFechar24;
import com.dudhoo.evilframework.components.BotaoSelecionar20;
import com.dudhoo.evilframework.components.EvilTable;
import com.dudhoo.evilframework.event.RefreshListener;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.event.SelectPressListener;
import com.dudhoo.nemesis.exception.QueryNotSetedException;
import com.dudhoo.nemesis.hibernate.PessoaHome;
import com.sun.rowset.FilteredRowSetImpl;
import java.awt.BorderLayout;
import java.awt.Component;
import java.sql.PreparedStatement;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author  duduzera
 */
public class PanelPesquisaGeneric extends javax.swing.JPanel {
    private EditarPressListener editarListener;
    private ExcluirPressListener excluirListener;
    private InserirPressListener inserirListener;
    private JTabbedPane tabbedPane;
    private BotaoFechar24 botaoFechar;
    private BotaoSelecionar20 botaoSelect ;
    private SelectPressListener selectPressListener;
    private EvilTable evil = null;
    /**
     * A posição ou o indice que representa a chave primária. 
     * Esse valor é passado para as alterações e exclusões
     */
    private Integer indexPrimaryKey = null;
    /**
     * A query que foi setada é guardada para o refresh
     */
    private String query;
    /**
     * Creates new form PanelPesquisaGeneric
     */    
    public PanelPesquisaGeneric() {
        this(true, false);
    }
    /**
     * @param criaBotaoFechar se for true cria o botao fechar no panelMovimentacaoEstoque sul
     */
    public PanelPesquisaGeneric(boolean criaBotaoFechar, boolean isSelectable) {
        jbInit();
        initPanelCenter();
        if(criaBotaoFechar){
            criaBotaoFechar();
        }
        if(isSelectable){
            criaBotaoSelecionar();
        }
        if(this.jPanelSouth.getComponentCount() < 1){
            this.remove(this.jPanelSouth);
            this.jPanelSouth = null;
        }
    }
    
    
    /**
     * Cria o botao selecionar  no panelMovimentacaoEstoque sul
     */
    protected void criaBotaoSelecionar(){
        botaoSelect = new BotaoSelecionar20();
        botaoSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                if(getSelectPressListener() != null){
                    getSelectPressListener().doAfterClick();
                }
            }
        });
        adicionaAoPanelSul(botaoSelect);
    }
    
    /**
     * Cria o bota fechar que existe no panelMovimentacaoEstoque sul
     */
    protected void criaBotaoFechar(){
        botaoFechar = new com.dudhoo.evilframework.components.BotaoFechar24();
        botaoFechar.setMnemonic('e');
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharPanel();
            }
        });
        adicionaAoPanelSul(botaoFechar);
    }
    /**
     * Adiciona ao panelMovimentacaoEstoque sul o componente
     */
    public void adicionaAoPanelSul(Component c){
        jPanelSouth.add(c);
    }
    
    /**
     * Cria abas com os novos jPanels adicionados
     */
    public void addJPanel(JPanel panel){
        if(this.tabbedPane == null){
            this.tabbedPane = new JTabbedPane();
            this.jPanelCenter.setName(
                    panel.getName() == null || panel.getName().length() == 0 ?
                        "Dados":
                        "Dados de " + panel.getName());
            this.tabbedPane.add(this.jPanelCenter);
            this.add(tabbedPane, java.awt.BorderLayout.CENTER);
        }
        this.tabbedPane.add(panel);
        tabbedPane.setSelectedComponent(panel);
    }
    
    public boolean isAlgumaLinhaSelecionada(){
        return evil.isAlgumaLinhaSelecionada();
    }
    
    private void initPanelCenter(){
        if(evil == null){
            evil = new EvilTable();
            evil.addRefreshListener(new RefreshListener(){
                public void doWhenRefreshIsCalled(){
                    setSqlQueryToFilteredRowSet( query, indexPrimaryKey);                    
                }
            });
        }
        this.jPanelCenter.add(evil, BorderLayout.CENTER);
    }
    
    public Object getIdCampoSelecionado() throws NullPointerException{
        try{
            return evil.getIdCampoSelecionado();
        }catch(NullPointerException xxx){
            throw xxx;
        }
    }
    
    public void setSqlQueryToFilteredRowSet(String sql, Integer _indexPrimaryKey){
        try{
            PessoaHome home  = new PessoaHome();
            PreparedStatement pre = home.currentSession().connection().prepareStatement(sql);
            FilteredRowSetImpl filt = new FilteredRowSetImpl();
            filt.populate(pre.executeQuery());
            evil.setFilteredRowSet(filt, _indexPrimaryKey);
            this.query = sql;
            this.indexPrimaryKey = _indexPrimaryKey;
        }catch(Exception e){
            new EvilError(null, false, e).setVisible(true);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:jbInit
    private void jbInit() {
        jPanelSouth = new javax.swing.JPanel();
        jPanelCenter = new javax.swing.JPanel();
        jToolBar = new javax.swing.JToolBar();
        jButtonInserir = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanelSouth.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jPanelSouth.setBorder(new javax.swing.border.EtchedBorder());
        add(jPanelSouth, java.awt.BorderLayout.SOUTH);

        jPanelCenter.setLayout(new java.awt.BorderLayout());

        jPanelCenter.setBorder(new javax.swing.border.EtchedBorder());
        jToolBar.setMargin(new java.awt.Insets(1, 1, 1, 1));
        jButtonInserir.setMnemonic('n');
        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jToolBar.add(jButtonInserir);

        jButtonEditar.setMnemonic('d');
        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jToolBar.add(jButtonEditar);

        jButtonExcluir.setMnemonic('x');
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jToolBar.add(jButtonExcluir);

        jPanelCenter.add(jToolBar, java.awt.BorderLayout.NORTH);

        add(jPanelCenter, java.awt.BorderLayout.CENTER);

    }
    // </editor-fold>//GEN-END:jbInit
    
    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if(this.excluirListener != null){
            excluirListener.doAfterClick();
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed
    
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        if(this.editarListener != null){
            editarListener.doAfterClick();
        }
    }//GEN-LAST:event_jButtonEditarActionPerformed
    
    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        if(this.inserirListener != null){
            inserirListener.doAfterClick();
        }
    }//GEN-LAST:event_jButtonInserirActionPerformed
    
    private void fecharPanel(){
        if( this.getParent() != null){
            this.getParent().remove(this);
        }	
    }
    
    public void refreshTable() throws QueryNotSetedException{
        if(this.query == null){
            throw new QueryNotSetedException();            
        }
        setSqlQueryToFilteredRowSet(this.query, indexPrimaryKey);
    }
    
    public EditarPressListener getEditarListener() {
        return editarListener;
    }
    
    public void setEditarListener(EditarPressListener editarListener) {
        this.editarListener = editarListener;
    }
    
    public ExcluirPressListener getExcluirListener() {
        return excluirListener;
    }
    
    public void setExcluirListener(ExcluirPressListener excluirListener) {
        this.excluirListener = excluirListener;
    }
    
    public InserirPressListener getInserirListener() {
        return inserirListener;
    }
    
    public void setInserirListener(InserirPressListener inserirListener) {
        this.inserirListener = inserirListener;
    }

    public SelectPressListener getSelectPressListener() {
        return selectPressListener;
    }

    public void setSelectPressListener(SelectPressListener selectPressListener) {
        this.selectPressListener = selectPressListener;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JPanel jPanelCenter;
    private javax.swing.JPanel jPanelSouth;
    private javax.swing.JToolBar jToolBar;
    // End of variables declaration//GEN-END:variables
    
}
