package io.github.wkktoria.todo.todo;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IncrementGenerator;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", type = IncrementGenerator.class)
    private Long id;
    private String text;
    @Column(name = "isdone")
    private Boolean isDone;

    public Todo(Long id, String text, Boolean isDone) {
        this.id = id;
        this.text = text;
        this.isDone = isDone;
    }

    /**
     * Hibernate (JPA) needs it.
     */
    public Todo() {
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }
}