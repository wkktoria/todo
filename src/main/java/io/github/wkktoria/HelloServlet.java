package io.github.wkktoria;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "Hello", urlPatterns = {"/api/hello/*"})
public class HelloServlet extends HttpServlet {
    private static final String NAME_PARAM = "name";
    
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private final HelloService service;

    /**
     * Servlet container needs it.
     */
    @SuppressWarnings("unused")
    public HelloServlet() {
        this(new HelloService());
    }

    HelloServlet(HelloService service) {
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Got request with params: {}", req.getParameterMap());
        resp.getWriter().write(service.prepareGreeting(req.getParameter(NAME_PARAM)));
    }
}
