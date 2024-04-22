package io.github.wkktoria;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.component.LifeCycle;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        var logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello World!");

        var server = new Server(8080);

        var resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("src/main/webapp");

        var handler = new ServletHandler();
        handler.addServletWithMapping(HelloServlet.class, "/api/hello/*");

        HandlerList handlerList = new HandlerList(resourceHandler, handler);
        server.setHandler(handlerList);

        server.addEventListener(new LifeCycle.Listener() {
            @Override
            public void lifeCycleStopped(LifeCycle event) {
                HibernateUtil.close();
            }
        });
        server.start();
        server.join();
    }
}