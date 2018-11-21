package controller;

import com.animalFacts.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * A simple servlet to welcome the user.
 * @author ehollis98
 */

@WebServlet(
        urlPatterns = {"/searchAnimal"}
)

public class SearchAnimal extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDAO<Animal> animalDao = new GenericDAO<>(Animal.class);

        if (req.getParameter("submit").equals("searchByAnimalId")) {
            logger.info("Searching by animal.");
            req.setAttribute("searchedAnimalById", animalDao.getById(Integer.parseInt(req.getParameter("animalSearchId"))));
        }
        else if (req.getParameter("submit").equals("searchAllAnimals")) {
            logger.info("Searching by all animals.");
            req.setAttribute("allAnimals", animalDao.getAll());
        }
        else if (req.getParameter("submit").equals("searchRandomAnimal")) {
            logger.info("Getting JSON data.");

            Client client = ClientBuilder.newClient();
            WebTarget target =
                    client.target("http://18.219.184.166:8080/animalFacts/animals/random");
            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
            System.out.println("response: " + response);
/*
            ObjectMapper mapper = new ObjectMapper();

            Response animalResponse = mapper.readValue(response, Response.class);
            System.out.println(animalResponse.getAnimal().getName());

            String animalName = animalResponse.getAnimal().getName();
            String animalFact = animalResponse.getAnimal().getFact();
*/
            req.setAttribute("randomAnimal", response);

        }


        else{
            logger.info("No option chosen.");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}