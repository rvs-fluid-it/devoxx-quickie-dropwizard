package be.fluid_it.devoxx.quickie.dropwizard.jee;

import be.fluid_it.devoxx.quickie.dropwizard.application.DevoxxApplication;
import be.fluid_it.devoxx.quickie.dropwizard.config.DevoxxConfig;
import be.fluid_it.tools.dropwizard.box.WebApplication;

import javax.servlet.annotation.WebListener;

@WebListener
public class DevoxxWebApplication extends WebApplication<DevoxxConfig> {
    public DevoxxWebApplication() {
        super(new DevoxxApplication() {
            @Override
            public String getName() {
                return DevoxxWebApplication.class.getSimpleName();
            }
        }, "jee/devoxx.yml");
    }
}
