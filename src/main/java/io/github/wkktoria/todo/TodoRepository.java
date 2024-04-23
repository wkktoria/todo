package io.github.wkktoria.todo;

import io.github.wkktoria.HibernateUtil;

import java.util.List;

class TodoRepository {
    List<Todo> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createNativeQuery("select * from todos", Todo.class).list();

        transaction.commit();
        session.close();

        return result;
    }
}
