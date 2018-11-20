package rest;

import entity.Fact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import persistence.GenericDAO;

import static org.junit.Assert.*;

public class RestServiceTest {

    GenericDAO dao;

    @BeforeEach
    void setUp() {


        dao = new GenericDAO(Fact.class);
    }

    /**
     * Verify successful retrieval of a fact
     */
    @Test
    void getByIdSuccess() {
        Object retrievedFact = dao.getById(1);
        assertEquals("Fact{id=1, fact='The heart of a shrimp is located in its head!'}", retrievedFact);
    }



}