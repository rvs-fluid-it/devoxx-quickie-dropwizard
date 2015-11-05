package be.fluid_it.devoxx.quickie.dropwizard.modules;

import be.fluid_it.devoxx.quickie.dropwizard.config.DevoxxConfig;
import be.fluid_it.µs.bundle.guice.ApplicationModule;
import com.google.inject.Binder;
import com.google.inject.Provides;
import com.google.inject.name.Names;

import javax.inject.Named;

public class DevoxxModule implements ApplicationModule {
    private final String prompt;

    public DevoxxModule(String prompt) {
        this.prompt = prompt;
    }

    @Override
    public void configure(Binder binder) {
        binder.bind(String.class).annotatedWith(Names.named("prompt")).toInstance(prompt);
    }

    @Provides
    @Named("name")
    public String providesName(DevoxxConfig config) {
        return config.getName();
    }
}
