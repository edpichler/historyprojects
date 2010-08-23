package com.dudhoo.nemesis.swing.usuario;

import com.dudhoo.evilframework.components.BotaoDelete16;
import com.dudhoo.evilframework.components.BotaoEditar16;
import com.dudhoo.evilframework.components.BotaoNovo16;
import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.evilframework.swing.EvilInformation;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.GrupoUsuario;
import com.dudhoo.nemesis.hibernate.GrupoUsuarioHome;
import com.dudhoo.nemesis.hibernate.Usuario;
import com.dudhoo.nemesis.hibernate.UsuarioHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.usuario.event.NewUserActionAdapter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class JPanelAdminUsuarios extends JPanel{

    private BorderLayout borderLayout1 = new BorderLayout();
    private JSplitPane jSplitPane1 = new JSplitPane();
    private JPanel panelRight = new JPanel();
    private JPanel panelLeft = new JPanel();
    private JToolBar jToolBarGrupos = new JToolBar();
    private JToolBar jToolBarUsuarios = new JToolBar();
    private BotaoNovo16 botaoNovoUsuario = new BotaoNovo16();
    private BotaoNovo16 botaoNovoGrupo = new BotaoNovo16();
    private BotaoEditar16 botaoEditarGrupo = new BotaoEditar16();
    private BotaoEditar16 botaoEditarUsuario = new BotaoEditar16();
    private BotaoDelete16 botaoDeleteUsuario = new BotaoDelete16();
    private BotaoDelete16 botaoDeleteGrupo = new BotaoDelete16();
    private JScrollPane jScrollPane1 = new JScrollPane();
    private JScrollPane jScrollPane2 = new JScrollPane();
    private JList jListUsuarios = new JList();
    private JList jListGrupos = new JList();

    private List<GrupoUsuario> gruposList = null;

    public JPanelAdminUsuarios(){
	try{
	    jbInit();
	} catch(Exception e){
	    e.printStackTrace();
	}
    }

    private void jbInit() throws Exception{
	this.setSize(new Dimension(546, 461));
	this.setLayout(borderLayout1);
	jSplitPane1.setDividerLocation(this.getWidth() / 2);
	jSplitPane1.add(panelLeft, JSplitPane.LEFT);
	jSplitPane1.add(panelRight, JSplitPane.RIGHT);
	this.add(jSplitPane1, BorderLayout.CENTER);

	jToolBarGrupos.setLayout(new FlowLayout(FlowLayout.LEFT));
	jToolBarUsuarios.setLayout(new FlowLayout(FlowLayout.LEFT));
	botaoDeleteUsuario.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
			botaoDeleteUsuario_actionPerformed(e);
		    }
		});
	jListUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jListGrupos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	jListGrupos.addListSelectionListener(new ListSelectionListener(){
		    public void valueChanged(ListSelectionEvent e){
			setouGrupo(e);
		    }
		});
	panelLeft.setLayout(new BorderLayout());
	panelLeft.setBorder(BorderFactory.createTitledBorder("Grupos"));
	panelRight.setLayout(new BorderLayout());

	panelRight.setBorder(BorderFactory.createTitledBorder("Usuários"));
	panelLeft.add(jToolBarGrupos, BorderLayout.NORTH);
	jScrollPane2.getViewport().add(jListGrupos, null);
	panelLeft.add(jScrollPane2, BorderLayout.CENTER);
	panelRight.add(jToolBarUsuarios, BorderLayout.NORTH);

	jScrollPane1.getViewport().add(jListUsuarios, null);
	panelRight.add(jScrollPane1, BorderLayout.CENTER);
	jToolBarUsuarios.add(botaoNovoUsuario, null);
	jToolBarUsuarios.add(botaoEditarUsuario, null);
	jToolBarUsuarios.add(botaoDeleteUsuario, null);

	jToolBarGrupos.add(botaoNovoGrupo, null);
	jToolBarGrupos.add(botaoEditarGrupo, null);
	jToolBarGrupos.add(botaoDeleteGrupo, null);
	setarListeners();
	preencherDados();
    }

    private void setarListeners() throws ValidationException{
	this.botaoNovoUsuario.addActionListener( new NewUserActionAdapter( this));	
    }

    public GrupoUsuario getGrupoUsuario() throws NullPointerException{
	return (GrupoUsuario) this.jListGrupos.getSelectedValue();
    }

    public void preencherDados(){
	preencherGruposNaLista();
	refreshGruposNoList();
    }


    private void preencherGruposNaLista(){
	GrupoUsuarioHome gh = new GrupoUsuarioHome();
	gruposList = gh.findAll();
	for(int i = 0; i < gruposList.size(); i++){
	    gruposList.get(i).getUsuarios()
		.toString(); //apenas para poder fechar a sessão do hibernate
	}
	gh.closeSession();
	if(this.jListGrupos.getModel().getSize() > 0){
	    this.jListGrupos.setSelectedIndex(0);
	}
    }

    private void refreshGruposNoList(){
	if(gruposList == null){
	    this.jListGrupos.removeAll();
	} else {
	    DefaultListModel model = new DefaultListModel();
	    for(int i = 0; i < gruposList.size(); i++){
		GrupoUsuario gru = gruposList.get(i);
		model.addElement(gru);
	    }
	    this.jListGrupos.setModel(model);
	}
    }

    private void setouGrupo(ListSelectionEvent e){
	int index = ((JList)e.getSource()).getSelectedIndex();
	if(index != -1){
	    GrupoUsuario grupo =
		(GrupoUsuario)this.jListGrupos.getModel().getElementAt(index);
	    preencherGruposNaListaUsuarios(grupo.getUsuarios());

	}
    }

    private void preencherGruposNaListaUsuarios(Set<Usuario> usuarioSet){
	DefaultListModel model = new DefaultListModel();
	for(Iterator iterator = usuarioSet.iterator(); iterator.hasNext(); ){
	    Usuario usuario1 = (Usuario)iterator.next();
	    model.addElement(usuario1);
	}
	this.jListUsuarios.setModel(model);
    }

    private void botaoDeleteUsuario_actionPerformed(ActionEvent e){
    	try  {
	    Usuario user = (Usuario) this.jListUsuarios.getSelectedValue();
	    if(user != null){
	        UsuarioHome hom  = new UsuarioHome();
	        hom.delete(user);
		hom.closeSession();
		preencherDados();
		new EvilInformation(this).showMessage("Removido com sucesso!");
	    }
	} catch (Exception ex)  {
	    new EvilError(StartFrame.getCurrentInstance(), true, ex).setVisible(true);
	}
    }
}
