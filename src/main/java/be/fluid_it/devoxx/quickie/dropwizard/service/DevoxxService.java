package be.fluid_it.devoxx.quickie.dropwizard.service;

import be.fluid_it.devoxx.quickie.dropwizard.config.DevoxxConfig;
import be.fluid_it.devoxx.quickie.dropwizard.modules.DevoxxModule;
import be.fluid_it.devoxx.quickie.dropwizard.resources.HelloResource;
import be.fluid_it.devoxx.quickie.dropwizard.routes.DevoxxRoutes;
import be.fluid_it.µs.bundle.dropwizard.µService;
import be.fluid_it.µs.bundle.dropwizard.µsBundle;
import be.fluid_it.µs.bundle.dropwizard.µsEnvironment;
import io.dropwizard.setup.Environment;

public class DevoxxService extends µService<DevoxxConfig> {
    static {
        µService.µServiceClass = DevoxxService.class;
        µService.relativePathToYmlInIDE = "./src/main/config/service/devoxx.yml";
    }

    @Override
    public void initialize(µsBundle.Builder<DevoxxConfig> µsBundleBuilder) {
        µsBundleBuilder.addModule(new DevoxxModule(getName())).addRoutes(DevoxxRoutes.class);
    }

    @Override
    public Class<DevoxxConfig> configurationClass() {
        return DevoxxConfig.class;
    }

    @Override
    protected void run(DevoxxConfig configuration, Environment environment, µsEnvironment µsEnvironment) throws Exception {
        environment.jersey().register(HelloResource.class);
    }
}
