package io.github.wkktoria;

class Language {
    private final Long id;
    private String welcomePrefix;
    private String code;

    public Language(Long id, String welcomePrefix, String code) {
        this.id = id;
        this.welcomePrefix = welcomePrefix;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getWelcomePrefix() {
        return welcomePrefix;
    }

    public void setWelcomePrefix(String welcomePrefix) {
        this.welcomePrefix = welcomePrefix;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
