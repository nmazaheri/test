package interview.healthChecker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public class test {
    @Entity
    @Table(name = "person_data")
    class Person {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String first_name;

        private String last_name;

        public String getFullName() {
            return first_name + " " + last_name;
        }
    }

    public class PersonDao {
        @PersistenceContext
        private EntityManager em;

        public List<Person> listPersons() {
            CriteriaQuery<Person> criteriaQuery = em.getCriteriaBuilder().createQuery(Person.class);
            Root<Person> root = criteriaQuery.from(Person.class);
            return em.createQuery(criteriaQuery).getResultList();
        }
    }

    @Service
    class PersonService {

        @Autowired
        private Person person;

//        @Transactional
//        List<Person> findAll() {
//            return person.findAll();
//        }

    }
}
