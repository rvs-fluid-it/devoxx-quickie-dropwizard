package be.fluid_it.devoxx.quickie.dropwizard.config;

import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class DevoxxConfig extends Configuration {
    @NotEmpty
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
