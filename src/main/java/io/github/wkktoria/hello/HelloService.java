package io.github.wkktoria.hello;

import io.github.wkktoria.language.Language;
import io.github.wkktoria.language.LanguageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Language FALLBACK_LANGUAGE = new Language(1L, "Hello", "en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private final LanguageRepository repository;

    HelloService() {
        this(new LanguageRepository());
    }

    HelloService(LanguageRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name, String language) {
        Long languageId;
        try {
            languageId = Optional.ofNullable(language).map(Long::valueOf).orElse(FALLBACK_LANGUAGE.getId());
        } catch (NumberFormatException e) {
            logger.warn("Non-numeric language id used: {}", language);
            languageId = FALLBACK_LANGUAGE.getId();
        }
        var greetingPrefix = repository.findById(languageId).orElse(FALLBACK_LANGUAGE).getGreetingPrefix();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return greetingPrefix + " " + nameToWelcome + "!";
    }
}
