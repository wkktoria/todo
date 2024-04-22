package io.github.wkktoria;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        var logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello World!");

        var server = new Server(8080);

        var handler = new ServletHandler();
        server.setHandler(handler);

        handler.addServletWithMapping(HelloServlet.class, "/api/hello/*");

        server.start();
        server.join();
    }
}