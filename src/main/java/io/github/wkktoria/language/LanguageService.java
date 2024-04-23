package io.github.wkktoria.language;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class LanguageService {
    private final Logger logger = LoggerFactory.getLogger(LanguageService.class);

    private final LanguageRepository repository;

    LanguageService() {
        this(new LanguageRepository());
    }

    LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    List<LanguageDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(LanguageDTO::new)
                .toList();

    }
}
