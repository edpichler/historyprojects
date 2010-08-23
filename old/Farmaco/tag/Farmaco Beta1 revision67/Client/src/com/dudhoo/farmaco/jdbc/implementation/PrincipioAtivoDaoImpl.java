package com.dudhoo.farmaco.jdbc.implementation;

import com.dudhoo.evilframework.util.EvilTextFormatter;
import com.dudhoo.farmaco.app.Application;
import com.dudhoo.farmaco.dto.ApresentacaoFarmaceutica;
import com.dudhoo.farmaco.dto.ContraIndicacao;
import com.dudhoo.farmaco.dto.CuidadosEspeciais;
import com.dudhoo.farmaco.dto.Indicacao;
import com.dudhoo.farmaco.dto.Interacao;
import com.dudhoo.farmaco.dto.Precaucao;
import com.dudhoo.farmaco.dto.PrincipioAtivo;

import com.dudhoo.farmaco.dto.ReacaoAdversa;
import com.dudhoo.farmaco.jdbc.JdbcHelper;

import com.dudhoo.farmaco.jdbc.ResourceManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Iterator;
import java.util.Set;

import javax.sql.rowset.FilteredRowSet;

public class PrincipioAtivoDaoImpl extends AbstractDaoImpl implements PrincipioAtivoDao{

    private static final String NOME_TABELA = "PRINCIPIO_ATIVO";
    private static final String SQL_INSERT = 
	"INSERT INTO " + NOME_TABELA + "(DESCRICAO, NOME, USUARIO_ID) VALUES (?,?,?)";
    private static final String SQL_UPDATE = 
	"UPDATE " + NOME_TABELA + " SET DESCRICAO = ?, NOME = ? , USUARIO_ID = ? WHERE ID = ?";
    private static final String SQL_SELECT = 
	"SELECT ID, ULT_MOD, USUARIO_ID, DESCRICAO, NOME FROM " + NOME_TABELA;
    private static final String SQL_DELETE = 
	"DELETE FROM " + NOME_TABELA + " WHERE ID = ?";

    public PrincipioAtivoDaoImpl(){
    }

    public void insertOrUpdateCascade(Connection con, 
				      PrincipioAtivo principio) throws SQLException{
	boolean isConSuplied = (con != null);
	if(!isConSuplied){
	    con = ResourceManager.getConnection();
	}
	try{
	    JdbcHelper hell = new JdbcHelper();
	    con.setAutoCommit(false);
	    principio.setNome(principio.getNome().trim().toUpperCase());

	    if(principio.getId() == 0){
		ResultSet keys = null;
		keys = 
	     hell.executeAndReturnGeneredKeys(con, SQL_INSERT, new Object[]{ principio.getDescricao(), 
								      principio.getNome(), usuarioId });
		keys.next();
		principio.setId(keys.getInt(1));
		ResourceManager.close(keys.getStatement());
	    } else {
		hell.execute(con, SQL_UPDATE, 
	       new Object[]{ principio.getDescricao(), principio.getNome(), usuarioId, 
		      principio.getId() });
	    }

	    //contra indicacao	    
	    ContraIndicacao contra = principio.getContraIndicacao();
	    if(contra != null){
		ContraIndicacaoDao impl = new ContraIndicacaoDaoImpl();
		impl.insertOrUpdateCascade(con, contra, principio.getId());
	    }

	    //cuidados especiais
	    CuidadosEspeciais es = principio.getCuidadosEspec();
	    if(es != null){
		CuidadosEspeciaisDao impl = new CuidadosEspeciaisDaoImpl();
		impl.insertOrUpdateCascade(con, es, principio.getId());
	    }

	    //indicacao
	    Indicacao in = principio.getIndicacao();
	    if(in != null){
		IndicacaoDao impl = new IndicacaoDaoImpl();
		impl.insertOrUpdateCascade(con, in, principio.getId());
	    }

	    //Interacao
	    Interacao inte = principio.getInteracao();
	    if(inte != null){
		InteracaoDao impl = new InteracaoDaoImpl();
		impl.insertOrUpdateCascade(con, inte, principio.getId());
	    }

	    //Precaucao
	    Precaucao prec = principio.getPrecaucao();
	    if(prec != null){
		PrecaucaoDao impl = new PrecaucaoDaoImpl();
		impl.insertOrUpdateCascade(con, prec, principio.getId());
	    }

	    //ReacaoAdversa
	    ReacaoAdversa reac = principio.getReacaoAdversa();
	    if(reac != null){
		ReacaoAdversaDao impl = new ReacaoAdversaDaoImpl();
		impl.insertOrUpdateCascade(con, reac, principio.getId());
	    }

	    //ReacaoAdversa
	    Set<ApresentacaoFarmaceutica> apresList = 
		principio.getApresentacaoFarmaceutica();
	    if(apresList != null){
		ApresentacaoFarmaceuticaDao impl = new ApresentacaoFarmaceuticaDaoImpl();
		impl.insertOrUpdateCascade(con, apresList, principio.getId());
	    }
	    if(!isConSuplied){
		con.commit();
	    }
	} catch(SQLException ex){
	    if(!isConSuplied){
		con.rollback();
	    }
	    throw ex;
	} finally{
	    if(!isConSuplied){
		ResourceManager.close(con);
	    }
	}

    }

    public PrincipioAtivo findFullById(Connection con, 
				       int id) throws SQLException{
	boolean connectionSuplied = (con != null);
	if(!connectionSuplied){
	    con = ResourceManager.getConnection();
	}


	try{
	    JdbcHelper hell = new JdbcHelper();
	    con.setAutoCommit(false);
	    FilteredRowSet fl = 
		hell.executeSql(con, SQL_SELECT + " WHERE ID = ?", new Object[]{ id }, null);

	    if(fl.next()){
		PrincipioAtivo principio = new PrincipioAtivo();
		fetchToObject(principio, fl);

		ContraIndicacaoDao impl = new ContraIndicacaoDaoImpl();
		ContraIndicacao contra = impl.find(con, principio);
		if(contra != null){
		    principio.setContraIndicacao(contra);
		}


		CuidadosEspeciaisDao cuidadao = new CuidadosEspeciaisDaoImpl();
		CuidadosEspeciais es = cuidadao.find(con, principio);
		if(es != null){
		    principio.setCuidadosEspec(es);
		}

		//indicacao
		IndicacaoDao dao = new IndicacaoDaoImpl();
		Indicacao in = dao.find(con, principio);
		if(in != null){
		    principio.setIndicacao(in);
		}

		//Interacao
		InteracaoDao intDao = new InteracaoDaoImpl();
		Interacao inte = intDao.find(con, principio);
		if(inte != null){
		    principio.setInteracao(inte);
		}

		//Precaucao
		PrecaucaoDao daoImpl = new PrecaucaoDaoImpl();
		Precaucao prec = daoImpl.find(con, principio);
		if(prec != null){
		    principio.setPrecaucao(prec);
		}

		//ReacaoAdversa
		ReacaoAdversaDao recImpl = new ReacaoAdversaDaoImpl();
		ReacaoAdversa reac = recImpl.find(con, principio);
		if(reac != null){
		    principio.setReacaoAdversa(reac);
		    ;
		}

		//ReacaoAdversa	        
		ApresentacaoFarmaceuticaDao appImpl = new ApresentacaoFarmaceuticaDaoImpl();
		Set<ApresentacaoFarmaceutica> apresList = appImpl.find(con, principio);
		if(apresList != null){
		    principio.setApresentacaoFarmaceutica(apresList);
		}
		if(!connectionSuplied){
		    con.commit();
		}
		return principio;
	    } else {
		return null;
	    }
	} catch(SQLException ex){
	    if(!connectionSuplied){
		con.rollback();
	    }
	    throw ex;
	} finally{
	    if(!connectionSuplied){
		ResourceManager.close(con);
	    }
	}
    }

    private void fetchToObject(PrincipioAtivo pa, 
			       FilteredRowSet filte) throws SQLException{
	pa.setId(filte.getInt(1));
	pa.setUlt_mod(filte.getDate(2));
	pa.setDescricao(filte.getString(4));
	pa.setNome(filte.getString(5));
    }

    public void deleteCascading(Connection con, 
				PrincipioAtivo principioAtivo) throws SQLException{
	boolean isConSuplied = (con != null);
	if(!isConSuplied){
	    con = ResourceManager.getConnection();
	}
	int id = principioAtivo.getId();
	try{
	    JdbcHelper hell = new JdbcHelper();
	    con.setAutoCommit(false);

	    if(principioAtivo.getContraIndicacao() != null){
		new ContraIndicacaoDaoImpl()
		    .delete(con, principioAtivo.getContraIndicacao().getId());
	    }

	    if(principioAtivo.getCuidadosEspec() != null){
		new CuidadosEspeciaisDaoImpl()
		    .delete(con, principioAtivo.getCuidadosEspec().getId());
	    }

	    if(principioAtivo.getIndicacao() != null){
		new IndicacaoDaoImpl().delete(con, principioAtivo.getIndicacao().getId());
	    }
	    if(principioAtivo.getInteracao() != null){
		new InteracaoDaoImpl().delete(con, principioAtivo.getInteracao().getId());
	    }

	    if(principioAtivo.getReacaoAdversa() != null){
		new ReacaoAdversaDaoImpl()
		    .delete(con, principioAtivo.getReacaoAdversa().getId());
	    }
	    if(principioAtivo.getPrecaucao() != null){
		new PrecaucaoDaoImpl().delete(con, principioAtivo.getPrecaucao().getId());
	    }

	    if(principioAtivo.getApresentacaoFarmaceutica() != null){
		Set set = principioAtivo.getApresentacaoFarmaceutica();
		int ids[] = new int[set.size()];
		Iterator<ApresentacaoFarmaceutica> iterator = set.iterator();
		int i = 0;
		while(iterator.hasNext()){
		    ids[i++] = iterator.next().getId();
		}
		new ApresentacaoFarmaceuticaDaoImpl().delete(con, ids);
	    }

	    hell.execute(con, SQL_DELETE, new Object[]{ id });
	    if(!isConSuplied){
		con.commit();
	    }

	} catch(SQLException ex){
	    if(!isConSuplied){
		con.rollback();
	    }
	    throw ex;
	} finally{
	    if(!isConSuplied){
		ResourceManager.close(con);
	    }
	}
    }

}
