/*
 * JDialogFindCidade.java
 *
 * Created on 20 de Fevereiro de 2006, 21:48
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.cidadesRegioes;

import com.dudhoo.nemesis.event.SelectPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaCidadeBuilder;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSelectCancel;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Frame;

/**
 *
 * @author duduzera
 */
public class JDialogFindCidade extends JDialogGenericSelectCancel{
    private PanelPesquisaGeneric panel;
    private Long idCidade;
    /**
     * Creates a new instance of JDialogFindCidade
     */
    public JDialogFindCidade(Frame frame, boolean modal) {
        super(frame, modal);
        initDudu();
        this.setTitle("Procurar Cidade");
        pack();
        this.setLocationRelativeTo(null);
    }
    
    /** Creates a new instance of JDialogFindRamo */    
    
    private void initDudu(){
        panel = new PanelPesquisaCidadeBuilder().getPanelPesquisarCidade(false,false);
        
        this.setSelectPressListener(new SelectPressListener(){
            public void doAfterClick(){
                try{
                    if(panel.isAlgumaLinhaSelecionada()){
                        setIdCidade( Long.parseLong(panel.getIdCampoSelecionado().toString()) );
                        setOpcao( OpcaoEscolhida.SELECT );
                        close();
                    }
                }catch(Exception xxx){
                    new com.dudhoo.evilframework.swing.EvilError(StartFrame.getCurrentInstance(), false, xxx).setVisible(true);
                }
            }
        });
        this.addPanelAtCenter(panel);
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }
}
