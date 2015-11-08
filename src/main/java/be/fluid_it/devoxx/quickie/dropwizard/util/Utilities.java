package be.fluid_it.devoxx.quickie.dropwizard.util;

import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class Utilities {
    public static void registerCorsFilter(Environment environment) {
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
        FilterRegistration.Dynamic filter = environment.servlets().addFilter(
                "CORS", CrossOriginFilter.class);
        // Add URL mapping
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),
                true, "/*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM,
                "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(
                CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter("allowedHeaders",
                "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
        filter.setInitParameter("allowCredentials", "true");
    }

}
