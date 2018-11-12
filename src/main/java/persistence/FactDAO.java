package persistence;

import entity.Fact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;



public class FactDAO {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    public List<Fact> getAllFacts() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Fact> query = builder.createQuery(Fact.class);
        Root<Fact> root = query.from(Fact.class);
        List<Fact> facts = session.createQuery(query).getResultList();
        session.close();
        return facts;
    }

    public Fact getById(int id){
        Session session = sessionFactory.openSession();
        Fact fact = session.get(Fact.class, id);
        session.close();
        return fact;
    }

}
