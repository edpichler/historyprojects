package com.dudhoo.farmaco.install;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.farmaco.app.Application;

import com.dudhoo.farmaco.jdbc.ResourceManager;

import com.dudhoo.farmaco.swing.StartFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitializer{
    public DatabaseInitializer(){

    }

    public void create(){
	Connection con = null;
	try{
	    con = ResourceManager.getConnection();
	    Statement st = con.createStatement();
	    con.setAutoCommit(false);

	    //cria tabelas
	    st.addBatch("CREATE TABLE USUARIO (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY  ," +
		 "		NOME_COMPLETO       	VARCHAR(50) NOT NULL,\n" +
		 "	        USR 			VARCHAR(50) NOT NULL,\n" +
		 "	    	PASSWORD 		VARCHAR(50) NOT NULL,\n" + "	        PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE PRINCIPIO_ATIVO (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 7890, INCREMENT BY 1)," +
		 "           ULT_MOD		        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID			INT NOT NULL,\n" +
		 "           DESCRICAO          	VARCHAR(30000), \n" +
		 "           NOME		        VARCHAR(30000) NOT NULL, \n" +
		 "           PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE CONTRA_INDICACAO (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
		 "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID              INT NOT NULL,\n" +
		 "           PRINCIPIO_ATIVO_ID      INT NOT NULL,\n" +
		 "           DESCRICAO               VARCHAR(30000), \n" +
		 "           PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE INDICACAO (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
		 "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID              INT NOT NULL,\n" +
		 "           PRINCIPIO_ATIVO_ID      INT NOT NULL,\n" +
		 "           DESCRICAO               VARCHAR(30000), \n" +
		 "           PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE INTERACAO (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
		 "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID              INT NOT NULL,\n" +
		 "           PRINCIPIO_ATIVO_ID      INT NOT NULL,\n" +
		 "           DESCRICAO               VARCHAR(30000), \n" +
		 "           PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE PRECAUCAO (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
		 "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID              INT NOT NULL,\n" +
		 "           PRINCIPIO_ATIVO_ID      INT NOT NULL,\n" +
		 "           DESCRICAO               VARCHAR(30000), \n" +
		 "           PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE REACAO_ADVERSA (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
		 "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID              INT NOT NULL,\n" +
		 "           PRINCIPIO_ATIVO_ID      INT NOT NULL,\n" +
		 "           DESCRICAO               VARCHAR(30000), \n" +
		 "           PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE CUIDADOS_ESPECIAIS (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
		 "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID              INT NOT NULL,\n" +
		 "           PRINCIPIO_ATIVO_ID      INT NOT NULL,\n" +
		 "           DESCRICAO               VARCHAR(30000), \n" +
		 "           PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE APRESENTACAO_FARMACEUTICA (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
		 "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID              INT NOT NULL,\n" +
		 "           PRINCIPIO_ATIVO_ID      INT NOT NULL,\n" +
		 "           DESCRICAO               VARCHAR(30000), \n" +
		 "           PRIMARY KEY (ID))");

	    st.addBatch("CREATE TABLE POSOLOGIA (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY," +
		 "           ULT_MOD                 	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +
		 "           USUARIO_ID              	INT NOT NULL,\n" +
		 "           APRESENTACAO_FARMACEUTICA_ID    INT NOT NULL,\n" +
		 "           DESCRICAO               	VARCHAR(30000), \n" +
		 "           PRIMARY KEY (ID))");

	    //INSERIR DADOS INICIAIS
	     //usuari de exemplo
	     st.addBatch("INSERT INTO USUARIO (NOME_COMPLETO, USR, PASSWORD) VALUES('Administrador', 'admin', '')");

	    //INSERIR FOREIGN KEYS
	    st.addBatch("ALTER TABLE PRINCIPIO_ATIVO ADD CONSTRAINT FK_PRI_USUA\n" +
		 "	          	FOREIGN KEY (USUARIO_ID)\n" +
		 "	                REFERENCES USUARIO (ID)");

	    st.addBatch("ALTER TABLE CONTRA_INDICACAO ADD CONSTRAINT FK_CTR_USUA\n" +
		 "                  FOREIGN KEY (USUARIO_ID)\n" +
		 "                  REFERENCES USUARIO (ID)");

	    st.addBatch("ALTER TABLE CONTRA_INDICACAO ADD CONSTRAINT FK_CONTRA_INDICACAO\n" +
	         "                  FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	         "                  REFERENCES PRINCIPIO_ATIVO (ID)");

	    st.addBatch("ALTER TABLE INDICACAO  ADD CONSTRAINT FK_IND_USUA\n" +
		 "                  FOREIGN KEY (USUARIO_ID)\n" +
		 "                  REFERENCES USUARIO (ID)");

	    st.addBatch("ALTER TABLE INDICACAO ADD CONSTRAINT FK_INDICACAO\n" +
	         "                  FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	         "                  REFERENCES PRINCIPIO_ATIVO (ID)");


	    st.addBatch("ALTER TABLE INTERACAO  ADD CONSTRAINT FK_INT_USUA\n" +
		 "                  FOREIGN KEY (USUARIO_ID)\n" +
		 "                  REFERENCES USUARIO (ID)");

	    st.addBatch("ALTER TABLE INTERACAO ADD CONSTRAINT FK_INTERACAO\n" +
	         "                  FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	         "                  REFERENCES PRINCIPIO_ATIVO (ID)");

	    st.addBatch("ALTER TABLE PRECAUCAO  ADD CONSTRAINT FK_PREC_USUA\n" +
		 "                  FOREIGN KEY (USUARIO_ID)\n" +
		 "                  REFERENCES USUARIO (ID)");

	    st.addBatch("ALTER TABLE PRECAUCAO ADD CONSTRAINT FK_PRECAUCAO\n" +
	         "                  FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	         "                  REFERENCES PRINCIPIO_ATIVO (ID)");

	    st.addBatch("ALTER TABLE REACAO_ADVERSA  ADD CONSTRAINT FK_READV_USUA\n" +
		 "                  FOREIGN KEY (USUARIO_ID)\n" +
		 "                  REFERENCES USUARIO (ID)");
		 
	    st.addBatch("ALTER TABLE REACAO_ADVERSA ADD CONSTRAINT FK_REACAO_ADVERSA\n" +
	         "                  FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	         "                  REFERENCES PRINCIPIO_ATIVO (ID)");
	 

	    st.addBatch("ALTER TABLE CUIDADOS_ESPECIAIS  ADD CONSTRAINT FK_CUIDESP_USUA\n" +
		 "                  FOREIGN KEY (USUARIO_ID)\n" +
		 "                  REFERENCES USUARIO (ID)");
	    
	    st.addBatch("ALTER TABLE CUIDADOS_ESPECIAIS ADD CONSTRAINT FK_CUIDADOS_ESPECIAIS\n" +
	         "                  FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	         "                  REFERENCES PRINCIPIO_ATIVO (ID)");
	    
	    st.addBatch("ALTER TABLE APRESENTACAO_FARMACEUTICA  ADD CONSTRAINT FK_APRFARM_USUA\n" +
		 "                  FOREIGN KEY (USUARIO_ID)\n" +
		 "                  REFERENCES USUARIO (ID)");

	    st.addBatch("ALTER TABLE APRESENTACAO_FARMACEUTICA ADD CONSTRAINT FK_APRESENTACAO_FARMACEUTICA\n" +
	         "                  FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	         "                  REFERENCES PRINCIPIO_ATIVO (ID)");
		 
	    st.addBatch("ALTER TABLE POSOLOGIA  ADD CONSTRAINT FK_POSOL_USUA\n" +
		 "                  FOREIGN KEY (USUARIO_ID)\n" +
		 "                  REFERENCES USUARIO (ID)");
		 
	    st.addBatch("ALTER TABLE POSOLOGIA ADD CONSTRAINT FK_APRESENTACAO_FARMACEUTICA_POSOLOGIA\n" +
	         "                  FOREIGN KEY (APRESENTACAO_FARMACEUTICA_ID)\n" +
	         "                  REFERENCES APRESENTACAO_FARMACEUTICA (ID)");
		 
	    //uniques
		 
	    st.addBatch("ALTER TABLE PRINCIPIO_ATIVO ADD CONSTRAINT UNIQUE_PRIN\n" +
	         "                      UNIQUE (NOME)");

	    st.addBatch("ALTER TABLE CONTRA_INDICACAO ADD CONSTRAINT UNIQUE_CTRIN\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE INDICACAO ADD CONSTRAINT UNIQUE_INDC\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE INTERACAO ADD CONSTRAINT UNIQUE_INTER\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE PRECAUCAO ADD CONSTRAINT UNIQUE_PRECAU\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE REACAO_ADVERSA ADD CONSTRAINT UNIQUE_REACADV\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE CUIDADOS_ESPECIAIS ADD CONSTRAINT UNIQUE_CUIDES\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE POSOLOGIA ADD CONSTRAINT UNIQUE_POSOL\n" +
	         "                      UNIQUE (APRESENTACAO_FARMACEUTICA_ID)");

		 
	    st.executeBatch();
	    con.commit();
	} catch(Exception e){
	    try{
		con.rollback();
		new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);;
	    } catch(SQLException f){
		new EvilError(StartFrame.getCurrentInstance(), true, f).setVisible(true);
	    }
	    new EvilError(StartFrame.getCurrentInstance(), true, e).setVisible(true);
	} finally{
	    ResourceManager.close(con);
	}
    }

    public boolean alreadyExists() throws SQLException{
	Connection con = ResourceManager.getConnection();
	Statement st = con.createStatement();	
	try{
	    st.execute("select count(*) from usuario");
	    return true;
	}catch(SQLException ee){
	    return false;
	}finally{
	    ResourceManager.close(st);
	    ResourceManager.close(con);
	}
	
    }
}
