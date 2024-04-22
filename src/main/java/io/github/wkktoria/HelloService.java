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
        return prepareGreeting(name, null);
    }

    String prepareGreeting(String name, String language) {
        var languageId = Optional.ofNullable(language).map(Long::valueOf).orElse(FALLBACK_LANGUAGE.getId());
        var greetingPrefix = repository.findById(languageId).orElse(FALLBACK_LANGUAGE).getGreetingPrefix();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return greetingPrefix + " " + nameToWelcome + "!";
    }
}
