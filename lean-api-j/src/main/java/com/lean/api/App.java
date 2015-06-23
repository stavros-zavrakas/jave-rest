package com.lean.api;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

public class App {

   public static void main(String[] args) throws Exception {
      ServletHolder sh = new ServletHolder(ServletContainer.class);
      sh.setInitParameter("jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
      sh.setInitParameter("jersey.config.server.provider.packages", "resources");
      sh.setInitParameter("jersey.api.json.POJOMappingFeature", "true");

      Server server = new Server(8080);
      ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
      context.addServlet(sh, "/*");

      try {
         server.start();
         server.join();
      } catch (Exception e) {
         e.printStackTrace();
      }
      // ResourceConfig config = new ResourceConfig();
      // config.register(JacksonFeature.class);
      //
      // ServletContextHandler context = new ServletContextHandler(
      // ServletContextHandler.SESSIONS);
      //
      // context.setContextPath("/");
      //
      // Server jettyServer = new Server(8080);
      // jettyServer.setHandler(context);
      //
      // ServletHolder jerseyServlet = context.addServlet(
      // org.glassfish.jersey.servlet.ServletContainer.class, "/*");
      //
      // jerseyServlet.setInitParameter("jersey.config.server.provider.packages",
      // "resources");
      //
      // try {
      // jettyServer.start();
      // jettyServer.join();
      // } catch (Exception e) {
      // e.printStackTrace();
      // }
   }
}
