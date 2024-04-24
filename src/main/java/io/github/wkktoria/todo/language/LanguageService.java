package io.github.wkktoria.todo.language;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class LanguageService {
    private final LanguageRepository repository;

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