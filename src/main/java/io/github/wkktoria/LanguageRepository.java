package io.github.wkktoria;

import java.util.List;
import java.util.Optional;

class LanguageRepository {
    Optional<Language> findById(Long id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.get(Language.class, id);

        transaction.commit();
        session.close();

        return Optional.ofNullable(result);
    }

    List<Language> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.createNativeQuery("select * from languages", Language.class).list();

        transaction.commit();
        session.close();

        return result;
    }
}
