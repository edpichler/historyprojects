package com.dudhoo.farmaco.swing.component;

import com.dudhoo.evilframework.components.BotaoDelete16;
import com.dudhoo.evilframework.components.BotaoNovo16;
import com.dudhoo.evilframework.swing.dialog.BotaoConstants;
import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;

import com.dudhoo.farmaco.swing.dialog.JDialogEditApresFarmaceutica;
import com.dudhoo.farmaco.swing.event.BotaoLimparAppFarmacAdapter;
import com.dudhoo.farmaco.swing.event.ListaRemediosKeyListener;
import com.dudhoo.farmaco.swing.event.ListaRemediosValueChangeListener;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;


public class JPanelListApresFarmaceutica extends JPanel{

    private JToolBar jToolBar1 = new JToolBar();
    private BorderLayout borderLayout1 = new BorderLayout();
    private BotaoNovo16 botaoNovo161 = new BotaoNovo16();
    private BotaoDelete16 botaoDelete161 = new BotaoDelete16();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JList jListApps = new JList();
    private JPanelPosologia panelPosologia;

    private ArrayList<ApresentacaoFarmaceutica> appresenta = new ArrayList();

    public JPanelListApresFarmaceutica(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{

	this.setLayout(borderLayout1);
	this.setBorder(BorderFactory.createTitledBorder("Apresentações Farmacêuticas"));
	botaoNovo161.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoNovo161_actionPerformed(e);
		    }
		});
	botaoDelete161.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoDelete161_actionPerformed(e);
		    }
		});
	jToolBar1.add(botaoNovo161, null);
	jToolBar1.add(botaoDelete161, null);
	this.add(jToolBar1, BorderLayout.NORTH);
	jScrollPane1.getViewport().add(jListApps, null);
	this.add(jScrollPane1, BorderLayout.CENTER);
    }

    public void setAppresenta(ArrayList<ApresentacaoFarmaceutica> appresenta){
	this.appresenta = appresenta;
	DefaultListModel model = new DefaultListModel();
	if(appresenta != null){
	    for(int i = 0; i < appresenta.size(); i++){
		model.addElement(appresenta.get(i));
	    }
	}
	jListApps.setModel(model);
    }

    public ArrayList<ApresentacaoFarmaceutica> getAppresenta(){
	return appresenta;
    }

    private void botaoNovo161_actionPerformed(ActionEvent e){
	JDialogEditApresFarmaceutica dialog = new JDialogEditApresFarmaceutica(true);
	dialog.setAlwaysOnTop(true);
	dialog.setVisible(true);
	if(dialog.getBotaoClicado() == BotaoConstants.SAVE){
	    ApresentacaoFarmaceutica a = dialog.getApresentacaoFarmaceutica();
	    if(this.appresenta == null){
		this.appresenta = new ArrayList();
	    }
	    this.appresenta.add(a);
	    this.setAppresenta(this.appresenta);
	}
    }

    private void botaoDelete161_actionPerformed(ActionEvent e){
	if(jListApps.getSelectedIndex() != -1){
	    this.appresenta.remove(this.jListApps.getSelectedValue());
	    this.setAppresenta(this.appresenta);
	}
    }


    public JList getJListApps(){
	return jListApps;
    }

    public void setPanelPosologia(JPanelPosologia panelPosologia){
	this.panelPosologia = panelPosologia;
	if(panelPosologia != null){
	    addValueChangeListener();
	}
    }

    public JPanelPosologia getPanelPosologia(){
	return panelPosologia;
    }

    private void addValueChangeListener(){
	this.jListApps.addListSelectionListener(new ListaRemediosValueChangeListener(this.jListApps, 
									      this.panelPosologia));
	this.panelPosologia.getTextPane()
	    .addKeyListener(new ListaRemediosKeyListener(this.jListApps, 
						  this.panelPosologia));
	this.panelPosologia.getBotaoLimpar()
	    .addActionListener(new BotaoLimparAppFarmacAdapter(this.jListApps, 
							this.panelPosologia));
    }
}
