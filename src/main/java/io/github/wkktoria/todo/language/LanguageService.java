package io.github.wkktoria.todo.language;

import java.util.List;

class LanguageService {
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
