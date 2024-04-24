package io.github.wkktoria.todo.language;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "Language", urlPatterns = {"/api/languages/*"})
public class LanguageServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(LanguageServlet.class);
    private final LanguageService service;
    private final ObjectMapper mapper;

    /**
     * Servlet container needs it.
     */
    @SuppressWarnings("unused")
    public LanguageServlet() {
        this(new LanguageService(), new ObjectMapper());
    }

    LanguageServlet(LanguageService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("GOT request with params: {}", req.getParameterMap());
        resp.setContentType("application/json;charset=UTF-8");
        mapper.writeValue(resp.getOutputStream(), service.findAll());
    }
}
