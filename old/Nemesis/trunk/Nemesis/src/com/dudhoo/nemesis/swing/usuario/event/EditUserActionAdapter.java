package com.dudhoo.nemesis.swing.usuario.event;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.nemesis.exception.ValidationException;
import com.dudhoo.nemesis.hibernate.GrupoUsuario;
import com.dudhoo.nemesis.hibernate.Usuario;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.usuario.JDialogUsuario;
import com.dudhoo.nemesis.swing.usuario.JPanelAdminUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUserActionAdapter implements ActionListener{
    private JPanelAdminUsuarios panel;
    
    public EditUserActionAdapter(JPanelAdminUsuarios _panel) {
        this.panel = _panel;
    }
    
    public void actionPerformed(ActionEvent e){
        try{
            Usuario usu = panel.getUsuario();
            GrupoUsuario grup = panel.getGrupoUsuario();
            if(usu == null){
                throw new ValidationException("Selecione um usuário na lista.");
            }else if(grup == null){
                throw new ValidationException("Selecione um grupo na lista.");
            }            
            JDialogUsuario dial = new JDialogUsuario(StartFrame.getCurrentInstance(), true, grup);
            dial.setUsuario(usu);
            dial.setVisible(true);
        } catch (Exception ex)  {
            new EvilError(null, false, ex).setVisible(true);
        }
        
    }
}
