package be.fluid_it.devoxx.quickie.dropwizard.routes;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.core.MediaType;

public class DevoxxRoutes extends RouteBuilder {
    private final String name;
    private final String prompt;

    @Inject
    public DevoxxRoutes(@Named("prompt") String prompt, @Named("name") String name) {
        this.prompt = prompt;
        this.name = name;
    }

    @Override
    public void configure() throws Exception {
        rest("/route/hello").get().produces(MediaType.TEXT_HTML)
                .route()
                .transform().constant(hello()).log(LoggingLevel.INFO, hello());
        restConfiguration().component("jersey2");
    }

    private String hello() {
        return prompt + ":Route> Hello " + name + "!" ;
    }
}
