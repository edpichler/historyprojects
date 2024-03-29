package com.dudhoo.nemesis.hibernate;

import java.math.BigDecimal;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * Pessoa generated by hbm2java
 */

public class Pessoa  implements java.io.Serializable {

    // Fields

    private long id;
    private Endereco endereco;
    private Observacao observacao;
    private Ramo ramo;
    private Usuario usuario;
    private String telefoneComercial;
    private String fax;
    private byte status;
    private String site;
    private String celular;
    private String email;
    private Date dataNascimento;
    private Date dataVerificaoCredito;

    private BigDecimal limiteCredito;
    private boolean instalacaoOuCasaPropria;
    private Integer quantidadeVeiculos;
    private BigDecimal taxaJurosDiaria;
    private Date ultMod;

    private Set <PessoaJuridica> pessoaJuridicas = new HashSet();
    private Set <PessoaFisica> pessoaFisicas   = new HashSet();
    private Set <Produto> produtosQueFornece = new HashSet();
    private Set <ContaReceber> contasReceber = new HashSet();
    private Set <ContaPagar> contasPagar = new HashSet();
    // Constructors

    /** default constructor */
    public Pessoa() {
    }

    /** minimal constructor */
    public Pessoa(long id, Endereco endereco, Ramo ramo, Usuario usuario, byte status, Date dataNascimento, BigDecimal limiteCredito, boolean instalacaoOuCasaPropria, Integer quantidadeVeiculos, BigDecimal taxaJurosDiaria, Date ultMod) {
        this.id = id;
        this.endereco = endereco;
        this.ramo = ramo;
        this.usuario = usuario;
        this.status = status;
        this.dataNascimento = dataNascimento;

        this.limiteCredito = limiteCredito;
        this.instalacaoOuCasaPropria = instalacaoOuCasaPropria;
        this.quantidadeVeiculos = quantidadeVeiculos;
        this.taxaJurosDiaria = taxaJurosDiaria;
        this.ultMod = ultMod;
    }

    /** full constructor */
    public Pessoa(long id, Endereco endereco, Observacao observacao, Ramo ramo, Usuario usuario, String telefoneComercial, String fax, byte status, String site, String celular, String email, Date dataNascimento, Date dataVerificaoCredito, BigDecimal limiteCredito, boolean instalacaoOuCasaPropria, Integer quantidadeVeiculos, BigDecimal taxaJurosDiaria, Date ultMod, Set<PessoaJuridica> pessoaJuridicas) {
        this.id = id;
        this.endereco = endereco;
        this.observacao = observacao;
        this.ramo = ramo;
        this.usuario = usuario;
        this.telefoneComercial = telefoneComercial;
        this.fax = fax;
        this.status = status;
        this.site = site;
        this.celular = celular;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.dataVerificaoCredito = dataVerificaoCredito;
        this.limiteCredito = limiteCredito;
        this.instalacaoOuCasaPropria = instalacaoOuCasaPropria;
        this.quantidadeVeiculos = quantidadeVeiculos;
        this.taxaJurosDiaria = taxaJurosDiaria;
        this.ultMod = ultMod;
        this.pessoaJuridicas = pessoaJuridicas;
    }



    // Property accessors

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Observacao getObservacao() {
        return this.observacao;
    }

    public void setObservacao(Observacao observacao) {
        this.observacao = observacao;
    }

    public Ramo getRamo() {
        return this.ramo;
    }

    public void setRamo(Ramo ramo) {
        this.ramo = ramo;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTelefoneComercial() {
        return this.telefoneComercial;
    }

    public void setTelefoneComercial(String telefoneComercial) {
        this.telefoneComercial = telefoneComercial;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public byte getStatus() {
        return this.status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getSite() {
        return this.site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getCelular() {
        return this.celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataVerificaoCredito() {
        return this.dataVerificaoCredito;
    }

    public void setDataVerificaoCredito(Date dataVerificaoCredito) {
        this.dataVerificaoCredito = dataVerificaoCredito;
    }

    public BigDecimal getLimiteCredito() {
        return this.limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public boolean isInstalacaoOuCasaPropria() {
        return this.instalacaoOuCasaPropria;
    }

    public void setInstalacaoOuCasaPropria(boolean instalacaoOuCasaPropria) {
        this.instalacaoOuCasaPropria = instalacaoOuCasaPropria;
    }

    public Integer getQuantidadeVeiculos() {
        return this.quantidadeVeiculos;
    }

    public void setQuantidadeVeiculos(Integer quantidadeVeiculos) {
        this.quantidadeVeiculos = quantidadeVeiculos;
    }

    public BigDecimal getTaxaJurosDiaria() {
        return this.taxaJurosDiaria;
    }

    public void setTaxaJurosDiaria(BigDecimal taxaJurosDiaria) {
        this.taxaJurosDiaria = taxaJurosDiaria;
    }

    public Date getUltMod() {
        return this.ultMod;
    }

    public void setUltMod(Date ultMod) {
        this.ultMod = ultMod;
    }

    public Set <PessoaJuridica> getPessoaJuridicas() {
        return this.pessoaJuridicas;
    }

    public void setPessoaJuridicas(Set <PessoaJuridica> pessoaJuridicas) {
        this.pessoaJuridicas = pessoaJuridicas;
    }

    /**
     * @return Retorna os produtos que a pessoa vende, ou � fornecedora.
     * */
    public Set <Produto> getProdutosQueFornece(){
	return produtosQueFornece;
    }

    /**
     * Seta os produtos que a pessoa fornece ou vende
     * */
    public void setProdutosQueFornece(Set <Produto> produtosQueFornece){
	this.produtosQueFornece = produtosQueFornece;
    }

    public String toString(){
	return getEmail();
    }

    public void setContasReceber(Set<ContaReceber> contasReceber){
	this.contasReceber = contasReceber;
    }

    public Set<ContaReceber> getContasReceber(){
	return contasReceber;
    }

    public void setContasPagar(Set<ContaPagar> contasPagar){
	this.contasPagar = contasPagar;
    }

    public Set<ContaPagar> getContasPagar(){
	return contasPagar;
    }

    public void setPessoaFisicas(Set<PessoaFisica> pessoaFisicas) {
        this.pessoaFisicas = pessoaFisicas;
    }

    public Set<PessoaFisica> getPessoaFisicas() {
        return pessoaFisicas;
    }
}
