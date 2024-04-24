package io.github.wkktoria.todo.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
class HelloServlet {
    private final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
    private final HelloService service;

    HelloServlet(HelloService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<String> getGreeting() {
        logger.info("GOT request");
        return ResponseEntity.ok(service.prepareGreeting(null, null));
    }

    @GetMapping(params = {"language", "name"})
    ResponseEntity<String> getGreeting(@RequestParam("language") Long languageId, @RequestParam String name) {
        logger.info("GOT request with params");
        return ResponseEntity.ok(service.prepareGreeting(name, languageId));
    }
}