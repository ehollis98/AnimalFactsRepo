import com.animalFacts.Animal;
import com.animalFacts.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static junit.framework.TestCase.assertEquals;


public class TestAnimalJSONReponse {

    @Test
    public void testAnimalFactsJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://18.219.184.166:8080/animalFacts/random");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        System.out.println("response: " + response);

        ObjectMapper mapper = new ObjectMapper();

        Response animalResponse = mapper.readValue(response, Response.class);
        System.out.println(animalResponse.getAnimal().getName());

        String animalName = animalResponse.getAnimal().getName();
        String animalFact = animalResponse.getAnimal().getFact();

        assertEquals("???", animalName);
        assertEquals("???", animalFact);

        assertEquals("???", response);
    }
}