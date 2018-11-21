package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.*;

/**
 * The type Rest application.
 */
@ApplicationPath("/animals")

public class RestApplication extends Application {

        //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
        @Override
        public Set<Class<?>> getClasses() {
            HashSet h = new HashSet<Class<?>>();
            h.add(RestService.class );
            return h;
        }
}

