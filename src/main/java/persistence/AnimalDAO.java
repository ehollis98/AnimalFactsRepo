package persistence;

import entity.Animal;
import entity.Fact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class AnimalDAO {


    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Animal> getAllAnimals() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
        Root<Animal> root = query.from(Animal.class);
        List<Animal> facts = session.createQuery(query).getResultList();
        session.close();
        return facts;
    }


    public Animal getById(int id){
        Session session = sessionFactory.openSession();
        Animal animal = session.get(Animal.class, id);
        session.close();
        return animal;
    }
    //todo
    public List<Fact> getFactsByAnimalId(int id){
        return null;
    }

}
