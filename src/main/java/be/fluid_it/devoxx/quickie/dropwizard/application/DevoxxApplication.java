package be.fluid_it.devoxx.quickie.dropwizard.application;

import be.fluid_it.devoxx.quickie.dropwizard.config.DevoxxConfig;
import be.fluid_it.devoxx.quickie.dropwizard.resources.ExplodeResource;
import be.fluid_it.devoxx.quickie.dropwizard.resources.HelloResource;
import be.fluid_it.devoxx.quickie.dropwizard.util.Utilities;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class DevoxxApplication extends Application<DevoxxConfig> {
    public static void main(String[] args) throws Exception {
        new DevoxxApplication().run("server", "./src/main/config/application/devoxx.yml");
    }

    @Override
    public void run(DevoxxConfig devoxxConfig, Environment environment) throws Exception {
        Utilities.registerCorsFilter(environment);
        environment.jersey().register(new HelloResource(
                getName(),
                devoxxConfig.getName()));
        environment.jersey().register(ExplodeResource.class);
    }

}
