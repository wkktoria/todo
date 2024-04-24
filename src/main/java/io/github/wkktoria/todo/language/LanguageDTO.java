package io.github.wkktoria.todo.language;

class LanguageDTO {
    private Long id;
    private String code;

    public LanguageDTO(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public LanguageDTO(Language language) {
        this.id = language.getId();
        this.code = language.getCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}