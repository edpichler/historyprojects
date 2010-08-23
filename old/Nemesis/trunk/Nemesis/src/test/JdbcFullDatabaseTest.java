package test;

import com.dudhoo.nemesis.Application;
import com.dudhoo.nemesis.hibernate.Cidade;
import com.dudhoo.nemesis.hibernate.CidadeHome;

import com.dudhoo.nemesis.hibernate.Endereco;
import com.dudhoo.nemesis.hibernate.Estado;

import com.dudhoo.nemesis.hibernate.Observacao;
import com.dudhoo.nemesis.hibernate.Pais;

import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.hibernate.Ramo;
import com.dudhoo.nemesis.hibernate.Usuario;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class JdbcFullDatabaseTest extends TestCase {
    public JdbcFullDatabaseTest(String sTestName) {
        super(sTestName);
    }

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testFull() {
        Session sess = new CidadeHome().currentSession();
        Usuario us = Application.getUsuarioLogado();
        Transaction t = sess.beginTransaction();
        Date data = Calendar.getInstance().getTime();

        for (int i = 0; i < 100; i++) {
            Pais pais = new Pais();
            pais.setNome("pais" + i);
            pais.setSigla("O" + i);
            pais.setUsuario(us);
            
            sess.persist(pais);
            
            Estado es = new Estado();
            es.setNome("estado" + i);
            es.setSigla("" + i);
            es.setPais(pais);
            es.setUsuario(us);            
            
            sess.persist(es);
            
            Cidade cidade = new Cidade();
            cidade.setNome("nome" + i);
            cidade.setCep("" + i);
            cidade.setEstado(es);
            cidade.setUsuario(us);
            sess.persist(cidade);
            
            Endereco end = new Endereco();
            end.setAndar("" + i);
            end.setBairro("" + i);
            end.setCep("" + i);
            end.setCidade(cidade);
            end.setComplemento("complemento");
            end.setNumero("" + i);
            Observacao obs = new Observacao();
            obs.setObs("ataaaaaaaaaaaaaaa");
            end.setObservacao(obs);
            end.setProximidade("proximidade" + i);
            end.setRua("rua" + i);
            end.setUsuario(us);
            sess.persist(end);
            
            Pessoa pes = new Pessoa();
            pes.setCelular("sce" + i);
            pes.setDataNascimento(Calendar.getInstance().getTime());
            pes.setDataVerificaoCredito(data);
            pes.setEmail("email");
            pes.setEndereco(end);
            pes.setFax("fax");
            pes.setInstalacaoOuCasaPropria(true);
            pes.setLimiteCredito(BigDecimal.valueOf(1.0));
            pes.setQuantidadeVeiculos(1);
            Ramo ramo  = new Ramo();
            ramo.setDescricao("ramo " + i);
            ramo.setNome("Ramonome " + i);
            ramo.setUsuario(us);
            pes.setRamo(ramo);
            pes.setTaxaJurosDiaria(BigDecimal.valueOf(0));
            pes.setTelefoneComercial("telcom"+ i);
            pes.setUsuario(us);
            sess.persist(ramo);
            sess.persist(pes);
            
            PessoaJuridica pj = new PessoaJuridica();
            pj.setCnpj("cnpj " + i);
            pj.setNome("Fant " + i);
            pj.setInscricaoEstadual("insc es" + i);
            pj.setNome("nome" +i);
            pj.setNomeCompletoContato("contato" + i);
            pj.setPessoa(pes);
            pj.setRazaoSocial("Razao " + i);
            sess.persist(pj);
            
            Produto prod = new Produto();
            prod.setNome("Prod_Nome" + i);
            prod.setUsuario(us);
            sess.persist(prod);
        }
        t.commit();
        sess.close();

    }
}
