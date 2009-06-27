/*
 * CidadeFactory.java
 *
 * Created on 20 de Fevereiro de 2006, 22:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.cidadesRegioes.JPanelCadCidadeRegioes;
import com.dudhoo.nemesis.swing.generic.JPanelGenericFechar;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;

/**
 *
 * @author duduzera
 */
public class PanelPesquisaCidadeBuilder {
    
    /** Creates a new instance of CidadeFactory */
    public PanelPesquisaCidadeBuilder() {
    }
    
    public  PanelPesquisaGeneric getPanelPesquisarCidade(boolean criaBotaoFechar, boolean isSelectable){
        final PanelPesquisaGeneric panel = new PanelPesquisaGeneric(criaBotaoFechar, isSelectable);
        //panel.setInserirListener();
        panel.setName("Cidades e regiões");
        StartFrame.getCurrentInstance().addJPanel(panel);
        panel.setSqlQueryToFilteredRowSet("select cidade.id as Código, cidade.nome as Cidade, estado.nome as Estado, pais.nome as País \n" + 
        "  from (( cidade INNER join estado on cidade.estado_id = estado.id)\n" + 
        "      INNER join pais on pais.id = estado.pais_id)\n" + 
        "      order by pais.nome, estado.nome, pais.nome ", 1);
        panel.setInserirListener(new InserirPressListener(){
            public void doAfterClick(){
                click(panel);
            }
        });
        panel.setEditarListener(new EditarPressListener(){
            public void doAfterClick(){
                click(panel);
            }
        });
        panel.setExcluirListener(new ExcluirPressListener(){
            public void doAfterClick(){
                click(panel);
            }
        });
        return panel;
    }
    private void click(PanelPesquisaGeneric panel){
        JPanelCadCidadeRegioes cidr = new JPanelCadCidadeRegioes();
        JPanelGenericFechar genf =  new JPanelGenericFechar();
        String title = "Gerenciamento de cidades/regiões";
        genf.setName(title);
        genf.setGreatTitle(title);
        genf.setJPanelInside(cidr);
        panel.addJPanel(genf);
    }
}
