package com.dudhoo.nemesis.webservices;

import com.dudhoo.nemesis.hibernate.ContaReceber;
import com.dudhoo.nemesis.hibernate.MovimentoEstoque;
import com.dudhoo.nemesis.hibernate.MovimentoEstoqueHome;
import com.dudhoo.nemesis.hibernate.Observacao;
import com.dudhoo.nemesis.hibernate.Pessoa;
import com.dudhoo.nemesis.hibernate.PessoaFisica;
import com.dudhoo.nemesis.hibernate.PessoaFisicaHome;
import com.dudhoo.nemesis.hibernate.PessoaJuridica;
import com.dudhoo.nemesis.hibernate.PessoaJuridicaHome;
import com.dudhoo.nemesis.hibernate.Produto;
import com.dudhoo.nemesis.hibernate.ProdutoHome;
import com.dudhoo.nemesis.hibernate.Usuario;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;

public class NWebService{
    public NWebService() {
    }
    
    /**
     * @webmethod
     * */
    public Date getTimestamp(){
        return Calendar.getInstance().getTime();
    }
    /**
     * @webmethod
     * */
    public void newClientePf(PessoaFisica pf){
        new PessoaFisicaHome().persist(pf);
        
    }
    /**
     * @webmethod
     * */
    public void newClientePj(PessoaJuridica pj){
        new PessoaJuridicaHome().persist(pj);
    }
    
    public void newOrder(Produto prod, long valorUnitario, Pessoa cliente, long quantidade, Observacao obs){
        MovimentoEstoque movimento = new MovimentoEstoque();
        ContaReceber rec = new ContaReceber();
        rec.setContaPaga(false);
        rec.setPessoa(cliente);
        rec.setValor(quantidade * valorUnitario);
        movimento.setQuantidade(quantidade);
        movimento.setProduto(prod);
        movimento.setPessoa(cliente);
        movimento.setConta(rec);
        movimento.setPrecoUnitario(valorUnitario);        
        MovimentoEstoqueHome home = new MovimentoEstoqueHome();        
        home.saveOrUpdate(movimento);
    }
    

    public List getAllProdutos() {
        ProdutoHome ph = new ProdutoHome();
        List list = ph.findAll();        
        return list;
    }
}
/* Através de dispositivos moveis:
 * - Cadastrar clientes, ok
 * - Efetuar vendas, 
 * - Consultar preços, 
 * - Analisar histórico do cliente,  
 * */