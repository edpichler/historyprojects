package com.pichler.felixwar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

public final class ProvisionActivator implements BundleActivator {
	private final ServletContext servletContext;

	public ProvisionActivator(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void start(BundleContext context) throws Exception {
//		System.getProperties().put("manager.root", "/system/console"); 
//		System.getProperties().put("org.osgi.service.http.port", "8080");

		String fileInstallFolder = getFileInstallFolder();
		System.getProperties().put("felix.fileinstall.dir", fileInstallFolder); //fileInstall http://felix.apache.org/site/apache-felix-file-install.html

		servletContext.setAttribute(BundleContext.class.getName(), context);

		ArrayList<Bundle> installed = new ArrayList<Bundle>();
		for (URL url : findBundles()) {
			this.servletContext.log("Installing bundle [" + url + "]");
			Bundle bundle = context.installBundle(url.toExternalForm());
			installed.add(bundle);
		}
		for (Bundle bundle : installed) {
			bundle.start();
	
		}	
	}

	private String getFileInstallFolder() throws MalformedURLException {
		ArrayList<URL> list = new ArrayList<URL>();
		String pasta = "/WEB-INF/bundles/fileInstall/";
		return this.servletContext.getRealPath(pasta);		
	}

	public void stop(BundleContext context) throws Exception {
		
	}

	private List<URL> findBundles() throws Exception {
		ArrayList<URL> list = new ArrayList<URL>();
		String pasta = "/WEB-INF/bundles/";

		for (Object o : this.servletContext.getResourcePaths(pasta)) {
			if (o != null) {
				String name = (String) o;
				if (name.endsWith(".jar")) {
					URL url = this.servletContext.getResource(name);
					if (url != null) {
						list.add(url);
						System.out.println("Adding " + url);
					}
				}
			}
		}

		return list;
	}
}
