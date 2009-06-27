package com.pichler.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import com.pichler.hibernate.Usuario;

@WebService(serviceName = "WebServiceMaligno", name = "WebServiceMaligno", targetNamespace = "com.pichler.webservices")
public class WebServiceMaligno {
	protected final Logger _LOG = Logger.getLogger(this.getClass());

	//@WebMethod()
	public boolean login(Usuario usr) {
		// verifica se o usuario existe na base
		_LOG.info("Usuário fazendo login...");
		return true;
	}

	@WebMethod()
	public void logoff() {
		_LOG.info("Logoff...");
	}

	public void inserirUsuario(Usuario usr) {
		// se for root e estiver logado deixa
	}

	public void atualizarUsuario(Usuario usr) {
		// se for root e estiver logado deixa
	}

	public void deletarUsuario(Usuario usr) {
		// se for root e estiver logado deixa
	}

	public List<Usuario> getUsuarios() {
		return null;
	}
}
