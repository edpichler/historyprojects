package com.dudhoo.farmaco.swing;

import com.dudhoo.evilframework.components.BotaoNovo16;

import com.dudhoo.evilframework.components.BotaoProcurar16;

import com.dudhoo.farmaco.hibernate.PrincipioAtivo;
import com.dudhoo.farmaco.hibernate.PrincipioAtivoHome;

import com.dudhoo.farmaco.swing.pAtivo.JPanelPrincipioAtivoViewer;

import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Insets;

import java.awt.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelPesquisa extends JPanel {
    private static PanelPesquisa instance;

    private JTextField jTextFieldPesquisa = new JTextField();
    private BorderLayout borderLayout1 = new BorderLayout();
    private JPanel top = new JPanel();
    private JLabel jlabel = new JLabel();
    private BotaoProcurar16 botaoProcurar161 = new BotaoProcurar16();
    private FlowLayout flowLayout1 = new FlowLayout();
    private BorderLayout borderLayout2 = new BorderLayout();
    private JPanel panel = new JPanel();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JList jList1 = new JList();
    private JPanelPrincipioAtivoViewer view = new JPanelPrincipioAtivoViewer();
    private JSplitPane jSplitPane = new JSplitPane();

    private PanelPesquisa() {
    //-poder mudar de ertical e horizontal
    //-aparecer os seleciomados
        try {
            jbInit();
            setName("Pesquisa");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(548, 382));
        this.setLayout(borderLayout1);
        jTextFieldPesquisa.setColumns(30);
        jTextFieldPesquisa.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        enterPressed(e);
                    }
                });
        top.setLayout(borderLayout2);
        panel.add(jTextFieldPesquisa, BorderLayout.NORTH);
        panel.add(botaoProcurar161, BorderLayout.NORTH);
        JPanel pLabel = new JPanel();
        pLabel.add(jlabel);

        top.add(pLabel, BorderLayout.NORTH);
        top.add(panel, BorderLayout.SOUTH);
        this.add(top, BorderLayout.NORTH);
        jSplitPane.add(view, JSplitPane.BOTTOM);
        jScrollPane1.getViewport().add(jList1, null);
        jSplitPane.add(jScrollPane1, JSplitPane.TOP);
        this.add(jSplitPane, BorderLayout.CENTER);
        jlabel.setText("Digite o principio ativo e clique em pesquisar:");
        jlabel.setFont(new Font("Trebuchet MS", 2, 15));
        panel.setLayout(flowLayout1);
        jScrollPane1.setBorder(BorderFactory.createTitledBorder("Resultados"));
        view.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        botaoProcurar161.setText("Pesquisar");
        botaoProcurar161.setMnemonic('P');
        botaoProcurar161.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        botaoProcurar161_actionPerformed(e);
                    }
                });
        addEventListener();

        this.jList1.addMouseListener(new PopUpMouseList(jList1));
        this.view.addMouseListener(new PopUpMouseList(view));


    }

    private void botaoProcurar161_actionPerformed(ActionEvent e) {
        pesquisar();
    }

    private void enterPressed(ActionEvent e) {
        pesquisar();
    }

    public void pesquisar(){
        String key = this.jTextFieldPesquisa.getText().trim();
        PrincipioAtivoHome home = new PrincipioAtivoHome();
        List <PrincipioAtivo> lista =  home.findByKey(key);
        atualizarLista(lista);
    }

    private void atualizarLista(List<PrincipioAtivo> lista) {
        DefaultListModel model = new DefaultListModel();
        for (int i = 0; i < lista.size(); i++) {
            model.addElement(lista.get(i));
        }
        jList1.setModel(model);
    }

    public Object getSelectedPrincipioAtivo(){
        return this.jList1.getSelectedValue();
    }

    public static PanelPesquisa getInstance() {
        if(instance == null){
            instance = new PanelPesquisa();
        }
        return instance;
    }

    private void addEventListener() {
        this.jList1.addListSelectionListener(new ListSelectionListener(){
                    public void valueChanged(ListSelectionEvent evt) {
                        Object o = jList1.getSelectedValue();
                        if( o != null){
                            view.setPrincipio((PrincipioAtivo )o);
                        }
                    }
                });
    }

    public void setJSplitPane(JSplitPane jSplitPane) {
        this.jSplitPane = jSplitPane;
    }

    public JSplitPane getJSplitPane() {
        return jSplitPane;
    }

    public void clearAll() {
        if( view != null){
            view.setPrincipio(null);
        }
        Object o = this.jList1.getModel();
        if(o != null && o instanceof DefaultListModel){
            ((DefaultListModel)o).clear();
        }
        o = null;

    }
}
