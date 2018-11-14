import org.junit.Test;
import rest.RestService;

import javax.ws.rs.core.Response;

import static org.junit.Assert.*;

public class RestServiceTest {

    @Test //this test checks the return of the raw JSON output
    public void getMessage() {
        RestService animal01 = new RestService();
        Response response =  animal01.getRandomFact();

        String result = response.getEntity().toString();
        
    }



}