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

        if (req.getParameter("submit").equals("getRandomAnimalDropdown")) {
            logger.info("Getting animals as dropdown.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/dropdown");

            String response = target.request(MediaType.TEXT_HTML).get(String.class);

            req.setAttribute("randomAnimalDropdown", response);
        }
        else if (req.getParameter("submit").equals("getRandomAnimalJSON")) {
            logger.info("Getting random animal as JSON.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/random");

            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            req.setAttribute("randomAnimalJSON", response);
        }
        else if (req.getParameter("submit").equals("getRandomAnimalXML")) {
            logger.info("Getting random animal as XML.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/random/xml");
            //todo fix this so it returns an XML object, not string
            String response = target.request(MediaType.APPLICATION_XML).get(String.class);

            req.setAttribute("randomAnimalXML", response);
        }
        else if (req.getParameter("submit").equals("getRandomAnimalFactJSON")) {
            logger.info("Getting random animal fact as JSON.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/fact/random");

            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            req.setAttribute("randomAnimalFactJSON", response);
        }
        else if (req.getParameter("submit").equals("getRandomAnimalFactXML")) {
            logger.info("Getting random animal fact as XML.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/fact/random/xml");
            //todo fix this so it returns an XML object, not string
            String response = target.request(MediaType.APPLICATION_XML).get(String.class);

            req.setAttribute("randomAnimalFactXML", response);
        }
        else if (req.getParameter("submit").equals("getAllAnimalFactsJSON")) {
            logger.info("Getting all animal facts as JSON.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/fact/all");

            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            req.setAttribute("allAnimalFactsJSON", response);
        }
        else if (req.getParameter("submit").equals("getAllAnimalFactsXML")) {
            logger.info("Getting all animal facts as XML.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/fact/all/xml");
            //todo fix this so it returns an XML object, not string
            String response = target.request(MediaType.APPLICATION_XML).get(String.class);

            req.setAttribute("allAnimalFactsXML", response);
        }
        else if (req.getParameter("submit").equals("getAnimalFactsByIdJSON")) {
            logger.info("Getting animal facts by id as JSON.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/" + Integer.parseInt(req.getParameter("animalSearchId01")));

            String response = target.request(MediaType.APPLICATION_JSON).get(String.class);

            req.setAttribute("animalFactsByIdJSON", response);
        }
        else if (req.getParameter("submit").equals("getAnimalFactsByIdXML")) {
            logger.info("Getting animal facts by id as XML.");

            Client client = ClientBuilder.newClient();

            WebTarget target = client.target("http://18.219.184.166:8080/animalFacts/animals/" + Integer.parseInt(req.getParameter("animalSearchId02")) + "/xml");
            //todo fix this so it returns an XML object, not string
            String response = target.request(MediaType.APPLICATION_XML).get(String.class);

            req.setAttribute("animalFactsByIdXML", response);
        }


        else{
            logger.info("No option chosen.");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }
}