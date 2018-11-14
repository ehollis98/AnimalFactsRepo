package rest;

import entity.Animal;
import entity.Fact;
import persistence.AnimalDAO;
import persistence.FactDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;

@Path("/fact")
public class RestService {
    // The Java method will process HTTP GET requests
    @GET
    @Path("/random")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getRandomFact() {

        // Return a simple message

        FactDAO factDAO = new FactDAO();
        AnimalDAO animalDAO = new AnimalDAO();
        List<Fact> facts = factDAO.getAllFacts();
        Random rand = new Random();
        int randomNumber = rand.nextInt(facts.size());

        Fact fact = factDAO.getById(randomNumber);
        Animal animal = animalDAO.getById(fact.getAnimalId());
        String output = "{\"animal\":{\"name\":\"" + animal.getAnimal()+ "\",\"fact\":\"" + fact.getFact() + "\"}}";

        return Response.status(200).entity(output).build();
    }
    @GET
    @Path("/all")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getAllFacts(){
        String output = "";
        FactDAO factDAO = new FactDAO();
        AnimalDAO animalDAO = new AnimalDAO();
        List<Fact> facts = factDAO.getAllFacts();
        output +="{\"animal\":{";
        //todo fix output of all animals repeats names
        for (Fact fact:facts) {
            output += animalDAO.getById(fact.getAnimalId()).getAnimal()+ "\n";
        }


        return Response.status(200).entity(output).build();
    }
}