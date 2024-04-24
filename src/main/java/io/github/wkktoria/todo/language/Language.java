package io.github.wkktoria.todo.language;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IncrementGenerator;

@Entity
@Table(name = "languages")
public class Language {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", type = IncrementGenerator.class)
    private Long id;
    @Column(name = "greetingprefix")
    private String greetingPrefix;
    private String code;

    public Language(Long id, String greetingPrefix, String code) {
        this.id = id;
        this.greetingPrefix = greetingPrefix;
        this.code = code;
    }

    /**
     * Hibernate (JPA) needs it.
     */
    public Language() {

    }

    public Long getId() {
        return id;
    }

    public String getGreetingPrefix() {
        return greetingPrefix;
    }

    public void setGreetingPrefix(String greetingPrefix) {
        this.greetingPrefix = greetingPrefix;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}