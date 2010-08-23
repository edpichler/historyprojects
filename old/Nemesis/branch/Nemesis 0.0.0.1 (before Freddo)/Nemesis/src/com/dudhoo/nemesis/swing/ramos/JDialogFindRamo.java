package com.dudhoo.nemesis.swing.ramos;

import com.dudhoo.nemesis.event.SelectPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.enumerations.OpcaoEscolhida;
import com.dudhoo.nemesis.swing.factory.PanelPesquisaRamosBuilder;
import com.dudhoo.nemesis.swing.generic.JDialogGenericSelectCancel;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

import java.awt.Frame;


/**
 *
 * @author duduzera
 */
public class JDialogFindRamo extends JDialogGenericSelectCancel {
    PanelPesquisaGeneric panel;
    private Long idRamo;
    /** Creates a new instance of JDialogFindRamo */
    public JDialogFindRamo(Frame frame, boolean modal){
        super(frame, modal);
        initDudu();        
    }
    private void initDudu(){
        panel = new PanelPesquisaRamosBuilder().getJPanelpesquisaRamos(false, false);
        this.setSelectPressListener(new SelectPressListener(){
            public void doAfterClick(){
                try{
                    if(panel.isAlgumaLinhaSelecionada()){
                        idRamo = Long.parseLong(panel.getIdCampoSelecionado().toString());
                        setOpcao(OpcaoEscolhida.SELECT);
                        close();
                    }
                }catch(Exception xxx){
                    new com.dudhoo.evilframework.swing.EvilError(StartFrame.getCurrentInstance(), false, xxx).setVisible(true);
                }
            }
        });
        this.addPanelAtCenter(panel);
    }
    
    public Long getIdRamo() {
        return idRamo;
    }
}
