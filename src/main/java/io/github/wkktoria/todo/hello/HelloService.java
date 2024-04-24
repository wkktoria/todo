package io.github.wkktoria.todo.hello;

import io.github.wkktoria.todo.language.Language;
import io.github.wkktoria.todo.language.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Language FALLBACK_LANGUAGE = new Language(1L, "Hello", "en");

    private final LanguageRepository repository;

    HelloService(LanguageRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name, Long language) {
        Long languageId = Optional.ofNullable(language).orElse(FALLBACK_LANGUAGE.getId());
        var greetingPrefix = repository.findById(languageId).orElse(FALLBACK_LANGUAGE).getGreetingPrefix();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return greetingPrefix + " " + nameToWelcome + "!";
    }
}