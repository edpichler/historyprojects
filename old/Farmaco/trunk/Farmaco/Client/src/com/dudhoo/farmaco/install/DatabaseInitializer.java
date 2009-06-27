package com.dudhoo.farmaco.install;

import com.dudhoo.evilframework.swing.EvilError;
import com.dudhoo.farmaco.hibernate.PrincipioAtivoHome;
import com.dudhoo.farmaco.hibernate.root.HibernateRoot;
import com.dudhoo.farmaco.swing.StartFrame;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


public class DatabaseInitializer{
    
    private static Logger log = Logger.getLogger(DatabaseInitializer.class);
    
    public DatabaseInitializer(){
    }

    public void create(){
	Connection con = null;
	try{
	    con = new HibernateRoot().currentSession().connection();
	    Statement st = con.createStatement();
	    con.setAutoCommit(false);

	    //cria tabelas
	    
	    st.addBatch("CREATE TABLE PRINCIPIO_ATIVO (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 7890, INCREMENT BY 1)," +
		"           ULT_MOD		    TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +	
		"           NOME          	    VARCHAR(300) NOT NULL, \n" +
                "           DESCRICAO               VARCHAR(30000) NOT NULL, \n" +
                "           INTERACOES              VARCHAR(30000), \n" +	    
                "           INDICACOES              VARCHAR(30000), \n" +
                "           CONTRA_INDICACOES       VARCHAR(30000), \n" +
                "           PRECAUSOES              VARCHAR(30000), \n" +                
                "           CUIDADOS_ESPECIAIS      VARCHAR(30000), \n" +
                "           REACOES_ADVERSAS        VARCHAR(30000), \n" +
                "           PRIMARY KEY (ID))");
	    
            st.addBatch("ALTER TABLE PRINCIPIO_ATIVO ADD CONSTRAINT UNIQUE_NOME\n" +
	         "                      UNIQUE (NOME)");
                 
                 
	    st.addBatch("CREATE TABLE APRESENTACAO_FARMACEUTICA (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 7890, INCREMENT BY 1)," +
	        "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +  
	        "           NOME                    VARCHAR(300) NOT NULL, \n" +
                "           POSOLOGIA               VARCHAR(30000), \n" +
                "           PRINCIPIO_ATIVO_ID      INT NOT NULL, \n" +
	        "           PRIMARY KEY (ID))");

	    st.addBatch("ALTER TABLE APRESENTACAO_FARMACEUTICA ADD CONSTRAINT FK_PRI_ATIVO\n" +
	                     "                      FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	                     "                      REFERENCES PRINCIPIO_ATIVO(ID)");
	    
	    st.addBatch("ALTER TABLE APRESENTACAO_FARMACEUTICA ADD CONSTRAINT UNIQUE_app_NOME\n" +
	         "                      UNIQUE (NOME)");
                 
	    st.addBatch("CREATE TABLE NOME_COMERCIAL(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 7890, INCREMENT BY 1)," +
	        "           ULT_MOD                 TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,\n" +  
	        "           NOME                    VARCHAR(300) NOT NULL, \n" +
	  //      "           LABORATORIO             VARCHAR(30000), \n" +
	        "           PRINCIPIO_ATIVO_ID      INT NOT NULL, \n" +
	        "           PRIMARY KEY (ID))");

	    st.addBatch("ALTER TABLE NOME_COMERCIAL ADD CONSTRAINT FK_PRI_ATIVO2\n" +
	                     "                      FOREIGN KEY (PRINCIPIO_ATIVO_ID)\n" +
	                     "                      REFERENCES PRINCIPIO_ATIVO(ID)");
	    
	    st.addBatch("ALTER TABLE NOME_COMERCIAL ADD CONSTRAINT UNIQUE_NOME_COMERC\n" +
	         "                      UNIQUE (NOME)");
            
            //INSERIR DADOS INICIAIS

	    //INSERIR FOREIGN KEYS
/*	    st.addBatch("ALTER TABLE PRINCIPIO_ATIVO ADD CONSTRAINT FK_PRI_USUA\n" +
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

	    

	    st.addBatch("ALTER TABLE INDICACAO ADD CONSTRAINT UNIQUE_INDC\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    

	    st.addBatch("ALTER TABLE PRECAUCAO ADD CONSTRAINT UNIQUE_PRECAU\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE REACAO_ADVERSA ADD CONSTRAINT UNIQUE_REACADV\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE CUIDADOS_ESPECIAIS ADD CONSTRAINT UNIQUE_CUIDES\n" +
	         "                      UNIQUE (PRINCIPIO_ATIVO_ID)");

	    st.addBatch("ALTER TABLE POSOLOGIA ADD CONSTRAINT UNIQUE_POSOL\n" +
	         "                      UNIQUE (APRESENTACAO_FARMACEUTICA_ID)");

*/		 
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
            try{
                con.close();
            }catch(SQLException exc){
                log.error(exc);
            }
	}
    }

    public boolean alreadyExists() throws  SQLException {
	Connection con = new HibernateRoot().currentSession().connection();
	Statement st = con.createStatement();	
	try{
	    st.execute("select * from PRINCIPIO_ATIVO WHERE (1=2)");
            return true;
	}catch(SQLException ee){
	    return false;
	}finally{
            st.close();
	    con.close();           
            st = null;
            con = null;
	}
    }
}
