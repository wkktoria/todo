package io.github.wkktoria;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "Hello", urlPatterns = {"/api/hello/*"})
public class HelloServlet extends HttpServlet {
    private static final String NAME_PARAM = "name";

    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Got request with params: {}", req.getParameterMap());

        String name = Optional.ofNullable(req.getParameter(NAME_PARAM)).orElse("world");

        resp.getWriter().write("Hello " + name + "!");
    }
}
