package rest;

import entity.Animal;
import entity.Fact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Path("/fact")
public class RestService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    @Path("/random")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getRandomFact() {

        // Return a simple message

        GenericDAO FactDAO = new GenericDAO(Fact.class);
        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Fact> facts = FactDAO.getAll();
        Random rand = new Random();
        int randomNumber = rand.nextInt(facts.size());

        Fact fact = (Fact) FactDAO.getById(randomNumber);
        logger.debug("Fact by Id " + fact);

        Animal animal = fact.getAnimal();
        logger.debug("Animal " + animal);



        String output = "{\"animal\":{\"name\":\"" + animal.getAnimal() + "\",\"fact\":\"" + fact.getFact() + "\"}}";
        logger.debug("Output " + output);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/all")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getAllFacts() {
        String output = "";
        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Animal> animalList = animalDAO.getAll();
        logger.debug("Animal List " + animalList);
        output += "{\"animals\": [";
        //todo fix output of all animals repeats names
        int index = 0;
        for (Animal animal : animalList) {

            if (index == 0){
                output += "{";
            } else {
                output += ",{";
            }
            index ++;
            output +="\"name\" :\"" +animal.getAnimal() + "\",";
            Set<Fact> factList = animal.getFact();
            logger.debug("Fact List " + factList);
            output += "\"fact\":[";
            int factIndex = 0;
            for (Fact fact : factList){

                output +="\"" +fact.getFact()+ "\"";
                if (factIndex==factList.size() - 1){

                }else {
                    output += ",";
                }
                factIndex++;
            }
            output += "]}";
        }
        output +="]}";

        return Response.status(200).entity(output).build();
        logger.debug("Response " + Response.status(200).entity(output).build());
    }
}