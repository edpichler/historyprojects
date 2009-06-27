package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.event.EditarPressListener;
import com.dudhoo.nemesis.event.ExcluirPressListener;
import com.dudhoo.nemesis.event.InserirPressListener;
import com.dudhoo.nemesis.swing.produto.event.InsertProdutoPressListener;
import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.produto.JDialogProduto;
import com.dudhoo.nemesis.swing.produto.event.EditarProdutoPressListener;
import com.dudhoo.nemesis.swing.produto.event.ExcluirProdutoPressListener;

public class PanelPesquisaProdutoBuilder{
    public PanelPesquisaGeneric getJPanelPesquisaProduto(boolean criaBotaoFechar, 
							 boolean isSelectable){
	final PanelPesquisaGeneric panel = 
	    new PanelPesquisaGeneric(criaBotaoFechar, isSelectable);	
	panel.setName("Produtos");
	StartFrame.getCurrentInstance().addJPanel(panel);
	panel.setSqlQueryToFilteredRowSet("select    \n" + 
	"	  produto.id as Código,  \n" + 
	"	  produto.NOME as Produto,    \n" + 
	"          concat('R$ ', TO_CHAR(produto.PRECO_VENDA, '999,999.99'))as Preço_de_Venda,    \n" + 
	"	  CATEGORIA_PRODUTO.NOME as Categoria,  \n" + 
	"	  produto.FABRICANTE as Fabricante    \n" + 
	"	  from (produto   \n" + 
	"	    left join CATEGORIA_PRODUTO on PRODUTO.CATEGORIA_PRODUTO_ID = CATEGORIA_PRODUTO.id)  \n" + 
	"	  order by CATEGORIA_PRODUTO.NOME, Produto.nome", 1);
	panel.setInserirListener(new InsertProdutoPressListener(panel));
	panel.setEditarListener(new EditarProdutoPressListener(panel));
	panel.setExcluirListener(new ExcluirProdutoPressListener(panel));
	return panel;
    }
}
