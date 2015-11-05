package be.fluid_it.devoxx.quickie.dropwizard.application;

import be.fluid_it.devoxx.quickie.dropwizard.config.DevoxxConfig;
import be.fluid_it.devoxx.quickie.dropwizard.resources.ExplodeResource;
import be.fluid_it.devoxx.quickie.dropwizard.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DevoxxApplication extends Application<DevoxxConfig> {
    public static void main(String[] args) throws Exception {
        new DevoxxApplication().run("server", "./src/main/config/application/devoxx.yml");
    }

    @Override
    public void run(DevoxxConfig devoxxConfig, Environment environment) throws Exception {
        environment.jersey().register(new HelloResource(
                getName(),
                devoxxConfig.getName()));
        environment.jersey().register(ExplodeResource.class);
    }
}
