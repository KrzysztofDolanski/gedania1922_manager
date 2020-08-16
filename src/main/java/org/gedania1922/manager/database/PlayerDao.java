package org.gedania1922.manager.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class PlayerDao  {

    public <T extends LastNameSearchable> List<T> findByLastName(Class<T> classType, String surname){
        List<T> list = new ArrayList<>();

        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<T> criteriaQuery = cb.createQuery(classType);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<T> rootTable = criteriaQuery.from(classType);

            // wykonanie zapytania
            criteriaQuery.select(rootTable)
                    .where(
                            // *lastName*
                            // czy wartośćkolumny 'lastName' jest równa wartości zmiennej lastName
                            cb.equal(rootTable.get("surname"), surname)
                    );

            // specification
            list.addAll(session.createQuery(criteriaQuery).list());

        } catch (HibernateException he) {
            he.printStackTrace();
        }

        return list;
    }
}
