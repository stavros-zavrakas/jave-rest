package com.lean.api;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {
	public static void main(String[] args) throws Exception {
		ServletHolder sh = new ServletHolder(ServletContainer.class);

		sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass",
		    "com.sun.jersey.api.core.PackagesResourceConfig");
		sh.setInitParameter("com.sun.jersey.config.property.packages", "resources");
		sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

		Server jettyServer = new Server(9999);
		ServletContextHandler context = new ServletContextHandler(
		    ServletContextHandler.SESSIONS);

		context.setContextPath("/");
//		context.addServlet(sh, "/*");

		try {
			jettyServer.start();
			jettyServer.join();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// ServletContextHandler context = new ServletContextHandler(
		// ServletContextHandler.SESSIONS);
		// context.setContextPath("/");
		//
		// Server jettyServer = new Server(8080);
		// jettyServer.setHandler(context);
		//
		// ServletHolder jerseyServlet = context.addServlet(
		// org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		//
		// jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
		// users.class.getCanonicalName());
		//
		// jerseyServlet.setInitParameter("jersey.config.server.provider.classnames",
		// banks.class.getCanonicalName());
		//
		// try {
		// jettyServer.start();
		// jettyServer.join();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}
}
