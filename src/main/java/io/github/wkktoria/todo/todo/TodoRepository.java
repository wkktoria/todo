package io.github.wkktoria.todo.todo;

import io.github.wkktoria.todo.HibernateUtil;

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

    Todo toggleTodo(Long id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        String sql = "select * from todos where id = ?";
        var query = session.createNativeQuery(sql, Todo.class);
        query.setParameter(1, id);
        var result = query.getSingleResult();

        result.setDone(!result.getDone());

        transaction.commit();
        session.close();

        return result;
    }

    Todo addTodo(Todo todo) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        session.persist(todo);

        transaction.commit();
        session.close();

        return todo;
    }
}
