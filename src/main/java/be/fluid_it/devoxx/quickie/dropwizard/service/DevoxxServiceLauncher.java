package be.fluid_it.devoxx.quickie.dropwizard.service;

/**
 * Workaround to enable launching the service with the maven-exec-plugin
 */
public class DevoxxServiceLauncher {
    public static void main(String[] args) throws Exception {
        // Workaround to execute static block of DevoxxService
        DevoxxService.class.newInstance();
        DevoxxService.main(args);
    }
}
