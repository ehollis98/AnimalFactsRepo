package persistence;

import entity.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AnimalDAO {


    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Animal> getAllFacts() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
        Root<Animal> root = query.from(Animal.class);
        List<Animal> animals = session.createQuery(query).getResultList();
        session.close();
        return animals;
    }

}
