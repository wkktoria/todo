package io.github.wkktoria;

class Language {
    private final Long id;
    private String greetingPrefix;
    private String code;

    public Language(Long id, String greetingPrefix, String code) {
        this.id = id;
        this.greetingPrefix = greetingPrefix;
        this.code = code;
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
