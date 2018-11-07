import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class RandomAnimalTest {

    @Test //this test checks the return of the raw JSON output
    public void getMessage() {
        RandomAnimal animal01 = new RandomAnimal();
        Response response =  animal01.getMessage();

        System.out.println(response.getEntity().toString());
        String result = response.getEntity().toString();
        assertEquals("{\n" +
                "\"animal\":{\n" +
                "\"name\":\"snake\",\n" +
                "\"fact\": \"snakes have leg bones\"\n" +
                "}\n" +
                "}", result);


    }
}