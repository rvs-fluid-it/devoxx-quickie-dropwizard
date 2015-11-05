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

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final String name;
    private final String prompt;

    @Inject
    public HelloResource(@Named("prompt") String prompt, @Named("name") String name) {
        this.prompt = prompt;
        this.name = name;
    }

    @GET
    @Timed
    public String hello() {
        String response = prompt + "> Hello " + name + "!";
        logger.info(response);
        return response;
    }
}
