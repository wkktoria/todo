package io.github.wkktoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class LanguageRepository {
    private final List<Language> languages;

    LanguageRepository() {
        languages = new ArrayList<>(
                Arrays.asList(new Language(1L, "Hello", "en"),
                        new Language(2L, "Witaj", "pl"))
        );
    }

    Optional<Language> findById(Long id) {
        return languages.stream()
                .filter(language -> language.getId().equals(id))
                .findFirst();
    }
}
