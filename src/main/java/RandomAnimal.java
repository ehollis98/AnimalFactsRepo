import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/random")
public class RandomAnimal {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("application/json")
    public Response getMessage() {
        // Return a simple message
        String output = "{\n" +
                "\"animal\":{\n" +
                "\"name\":\"snake\",\n" +
                "\"fact\": \"snakes have leg bones\"\n" +
                "}\n" +
                "}";
        return Response.status(200).entity(output).build();
    }

}