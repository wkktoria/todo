package io.github.wkktoria.todo.language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class LanguageServlet {
    private final Logger logger = LoggerFactory.getLogger(LanguageServlet.class);
    private final LanguageService service;

    LanguageServlet(LanguageService service) {
        this.service = service;
    }

    @GetMapping("/languages")
    ResponseEntity<List<LanguageDTO>> findAllLanguages() {
        logger.info("GOT request");
        return ResponseEntity.ok(service.findAll());
    }
}