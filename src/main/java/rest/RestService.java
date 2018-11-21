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

@Path("/")
public class RestService {

    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    @Path("/fact/random")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getRandomFact() {

        // Return a simple message

        GenericDAO FactDAO = new GenericDAO(Fact.class);
        List<Fact> facts = FactDAO.getAll();
        Random rand = new Random();
        int randomNumber = rand.nextInt(facts.size())+ 1;

        Fact fact = (Fact) FactDAO.getById(randomNumber);
        logger.debug("Fact by Id " + fact);

        Animal animal = fact.getAnimal();
        logger.debug("Animal " + animal);



        String output = "{\"animal\":{\"name\":\"" + animal.getAnimal() + "\",\"fact\":\"" + fact.getFact() + "\"}}";
        logger.debug("Output " + output);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/fact/random/xml")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/xml")
    public Response getRandomFactXml() {

        // Return a simple message

        GenericDAO FactDAO = new GenericDAO(Fact.class);
        List<Fact> facts = FactDAO.getAll();
        Random rand = new Random();
        int randomNumber = rand.nextInt(facts.size())+ 1;

        Fact fact = (Fact) FactDAO.getById(randomNumber);
        logger.debug("Fact by Id " + fact);

        Animal animal = fact.getAnimal();
        logger.debug("Animal " + animal);



        String output ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        output +="<root>";
        output +="<animal>";
        output += "<name>"+ animal.getAnimal() +"</name>";
        output += "<fact>" + fact.getFact() + "</fact>";
        output+= "</animal>";
        output +="</root>";
        logger.debug("Output " + output);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/fact/all")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getAllFacts() {
        String output = "";
        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Animal> animalList = animalDAO.getAll();
        logger.debug("Animal List " + animalList);
        output += "{\"animals\": [";

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
            output += formatFacts(factList);

        }
        output +="]}";

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/fact/all/xml")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/xml")
    public Response getAllFactsXml() {
        String output = "";
        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Animal> animalList = animalDAO.getAll();
        logger.debug("Animal List " + animalList);

        output +="<root>";
        for (Animal animal : animalList) {
            output += "<animal>";
            output +="<name>" +animal.getAnimal() + "</name>";
            Set<Fact> factList = animal.getFact();
            logger.debug("Fact List " + factList);
            output += formatFactsXml(factList);
            output +="</animal>";
        }
        output +="</root>";

        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/random")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getRandomAnimal() {

        // Return a simple message

        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Animal> animals = animalDAO.getAll();
        Random rand = new Random();
        int randomNumber = rand.nextInt(animals.size())+ 1;
        logger.debug("Animal List Size " + animals.size());
        logger.debug("Animal by Id " + randomNumber);

        Animal animal = (Animal) animalDAO.getById(randomNumber);
        logger.debug("Animal by Id " + animal);

        logger.debug("Animal " + animal.getAnimal());

        String output = "{\"animal\":{\"name\":\"" + animal.getAnimal() +"\","+ formatFacts(animal.getFact()) + "}";

        logger.debug("Output " + output);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/random/xml")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/xml")
    public Response getRandomAnimalXml() {

        // Return a simple message

        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Animal> animals = animalDAO.getAll();
        Random rand = new Random();
        int randomNumber = rand.nextInt(animals.size())+ 1;
        logger.debug("Animal List Size " + animals.size());
        logger.debug("Animal by Id " + randomNumber);

        Animal animal = (Animal) animalDAO.getById(randomNumber);
        logger.debug("Animal by Id " + animal);

        logger.debug("Animal " + animal.getAnimal());

        String output ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        output +="<root>";
        output +="<animal>";
        output += "<name>"+ animal.getAnimal() +"</name>";
        output += formatFactsXml(animal.getFact());
        output+= "</animal>";
        output +="</root>";
        logger.debug("Output " + output);
        return Response.status(200).entity(output).build();
    }

    private String formatFacts(Set<Fact> factList){
        String jsonFactsList = "";
        int factIndex = 0;
        jsonFactsList += "\"fact\":[";
        for (Fact fact : factList){

            jsonFactsList += "\"" +fact.getFact()+ "\"";
            if (factIndex==factList.size() - 1){

            }else {
                jsonFactsList += ",";
            }
            factIndex++;
        }
        jsonFactsList += "]}";
        logger.debug("jsonFactsList" + jsonFactsList);
        return jsonFactsList;
    }

    private String formatFactsXml(Set<Fact> factList) {
        String xmlFactsList = "";
        for (Fact fact : factList) {
            xmlFactsList += "<fact>" + fact.getFact() + "</fact>";
        }
        logger.debug("jsonFactsList" + xmlFactsList);
        return xmlFactsList;
        }


    @GET
    @Path("/{animalID}")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getAnimalById(@PathParam("animalID") int animalID){
        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Animal> animals = animalDAO.getAll();

        logger.debug("Animal List Size " + animals.size());
        logger.debug("Animal by Id " + animalID);
        if (animalID >animals.size()){
            String output = "{\"OutOfBoundsError\":\"Out of bounds choose a number from 1 to "+ animals.size() +"\"}";
            return Response.status(200).entity(output).build();
        }
        Animal animal = (Animal) animalDAO.getById(animalID);
        logger.debug("Animal by Id " + animal);
        logger.debug("Animal " + animal.getAnimal());

        String output = "{\"animal\":{\"name\":\"" + animal.getAnimal() +"\","+ formatFacts(animal.getFact()) + "}";

        logger.debug("Output " + output);
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/{animalID}/xml")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/xml")
    public Response getAnimalByIdXml(@PathParam("animalID") int animalID){
        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Animal> animals = animalDAO.getAll();

        logger.debug("Animal List Size " + animals.size());
        logger.debug("Animal by Id " + animalID);
        if (animalID >animals.size()){
            String output = "<OutOfBoundsError>Out of bounds choose a number from 1 to "+ animals.size() +"</OutOfBoundsError>";
            return Response.status(200).entity(output).build();
        }
        Animal animal = (Animal) animalDAO.getById(animalID);
        logger.debug("Animal by Id " + animal);
        logger.debug("Animal " + animal.getAnimal());

        String output = "<animal><name>"+ animal.getAnimal() +"</name>"+ formatFactsXml(animal.getFact()) + "</animal>";

        logger.debug("Output " + output);
        return Response.status(200).entity(output).build();
    }


    @GET
    @Path("/dropdown")
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/html")
    public Response getHtmlDropdown() {
        String output = "";
        GenericDAO animalDAO = new GenericDAO(Animal.class);
        List<Animal> animalList = animalDAO.getAll();
        logger.debug("Animal List " + animalList);

       output += "<select>";
       for (Animal animal: animalList) {
           output += "<option value=\"" +animal.getId() + "\">"
                +animal.getAnimal() + "</option>";
       }
       output += "</select>";
        return Response.status(200).entity(output).build();
    }
}