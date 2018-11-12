package persistence;

import entity.Fact;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactDAOTest {

    @Test
    public void getAllFacts() {
        FactDAO fact = new FactDAO();
        fact.getAllFacts();
        assertEquals("???", fact.getAllFacts());
    }

    @Test
    public void getById() {
        FactDAO fact = new FactDAO();
        assertEquals("???", fact.getById(1));

    }
}