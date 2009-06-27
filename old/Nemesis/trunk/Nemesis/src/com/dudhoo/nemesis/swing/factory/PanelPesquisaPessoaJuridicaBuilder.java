package com.dudhoo.nemesis.swing.factory;

import com.dudhoo.nemesis.swing.StartFrame;
import com.dudhoo.nemesis.swing.generic.PanelPesquisaGeneric;
import com.dudhoo.nemesis.swing.pessoa.listener.EditarPessoaJuridicaAdapter;
import com.dudhoo.nemesis.swing.pessoa.listener.ExcluirPessoaJuridicaAdapter;
import com.dudhoo.nemesis.swing.pessoa.listener.InserirPessoaJuridicaAdapter;

public class PanelPesquisaPessoaJuridicaBuilder{
    public PanelPesquisaPessoaJuridicaBuilder(){
    }
    
    public PanelPesquisaGeneric getPanelPesquisarPessoaJuridica() throws Exception{
	PanelPesquisaGeneric panel = null;
	panel = new PanelPesquisaGeneric();	
	panel.setInserirListener(new InserirPessoaJuridicaAdapter());

	panel.setEditarListener(new EditarPessoaJuridicaAdapter(panel));

	panel.setExcluirListener(new ExcluirPessoaJuridicaAdapter(panel));
	panel.setName("Pessoas Jurídicas");
	StartFrame.getCurrentInstance().addJPanel(panel);
	panel.setSqlQueryToFilteredRowSet("select \n" + 
	"  pessoa_juridica.id  as Código,  \n" + 
	"  pessoa.nome as Nome,\n" + 
	"  pessoa_juridica.RAZAO_SOCIAL as \"Razão Social\",\n" + 
	"  pessoa_juridica.CNPJ as \"CNPJ\",\n" + 
	"  cidade.NOME as Cidade,\n" + 
	"  pessoa_juridica.NOME_COMPLETO_CONTATO as \"Contato empresarial\",\n" + 
	"  pessoa_juridica.INSCRICAO_ESTADUAL as \"Inscrição Estadual\",  \n" + 
	"  pessoa.email as \"Email\",\n" + 
	"  OBSERVACAO.obs  as Observações\n" + 
	"  from ((((pessoa_juridica inner join pessoa on pessoa.id = pessoa_juridica.pessoa_id)   \n" + 
	"    inner join endereco on endereco.id = pessoa.ENDERECO_ID) \n" + 
	"    inner join cidade on cidade.ID = endereco.CIDADE_ID)\n" + 
	"    left join Observacao on OBSERVACAO.ID = pessoa.OBSERVACAO_ID)", 1);
	return panel;
    }
}
