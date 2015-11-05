package be.fluid_it.devoxx.quickie.dropwizard.resources;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/explode")
@Produces(MediaType.APPLICATION_JSON)
public class ExplodeResource {
    @GET
    @Timed
    public String explode() {
        throw new RuntimeException("Boom!");
    }
}
