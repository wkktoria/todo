package io.github.wkktoria;

import java.util.Optional;

class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Language FALLBACK_LANGUAGE = new Language(1L, "Hello", "en");

    private final LanguageRepository repository;

    HelloService() {
        this(new LanguageRepository());
    }

    HelloService(LanguageRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name) {
        return prepareGreeting(name, FALLBACK_LANGUAGE.getId());
    }

    String prepareGreeting(String name, Long languageId) {
        var welcomePrefix = repository.findById(languageId).orElse(FALLBACK_LANGUAGE).getWelcomePrefix();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomePrefix + " " + nameToWelcome + "!";
    }
}
