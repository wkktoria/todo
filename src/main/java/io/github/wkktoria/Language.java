package io.github.wkktoria;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IncrementGenerator;

@Entity
@Table(name = "languages")
class Language {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", type = IncrementGenerator.class)
    private Long id;
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
