package com.dudhoo.nemesis.swing.usuario;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.event.SavePressListener;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.GrupoUsuario;
import com.dudhoo.nemesis.hibernate.Usuario;
import com.dudhoo.nemesis.hibernate.UsuarioHome;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSaveCancel;

import java.awt.Dimension;
import java.awt.Frame;

public class JDialogUsuario extends JDialogGenericSaveCancel{
    JPanelUsuario panelUs = null;
    private GrupoUsuario grupo = null;
    public JDialogUsuario(Frame parent, boolean modal, GrupoUsuario _grupo){
	super(parent, modal, "Usuário do sistema");
	grupo = _grupo;
	jbInit();
	setListener();		
	centralize();
    }  

    public void setUsuario(Usuario user){
	panelUs.setUser(user);
    }
    public Usuario getUsuario() throws ValidationException{
	return panelUs.getUser();
    }
    private void jbInit(){
	if(panelUs == null){
	    panelUs = new JPanelUsuario();
	    this.addPanelAtCenter(panelUs);
	    this.setSize(new Dimension(380, 390));
	}
    }

    private void setListener(){
	this.setSavePressListener(new SavePressListener(){
		    public void doAfterClick(){
		        try{
		            if(getOpcao().equals(OpcaoEscolhida.SAVE)){		                
		                if(grupo != null){
		                    UsuarioHome home = new UsuarioHome();
		                    panelUs.getUser().setGrupoUsuarioId(grupo.getId());
		                    home.saveOrUpdate(panelUs.getUser());
		                    home.closeSession();
				    messageAfterTheSaveWithSucess(panelUs);
				    close();
		                } else {
		                    throw new ValidationException("O grupo não pode ser null.");
		                }
		            }
		        } catch(Exception e){
		            new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);
		        }
		    }
		});
    }
}
