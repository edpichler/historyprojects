package com.pichler.felixwar;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.pichler.felixwar.FrameworkService;

public class StartupListener implements ServletContextListener {


	private FrameworkService service;

	public void contextInitialized(ServletContextEvent event) {
		this.service = new FrameworkService(event.getServletContext());
		this.service.start();
	}

	public void contextDestroyed(ServletContextEvent event) {
		this.service.stop();
	}
}
