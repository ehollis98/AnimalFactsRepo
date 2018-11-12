package persistence;

import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalDAOTest {

    @Test
    public void getAllFacts() {
        AnimalDAO animal = new AnimalDAO();
        animal.getAllAnimals();
        assertEquals("???", animal.getAllAnimals());
    }

    @Test
    public void getById() {
    }
}