package fi.iki.mkuokkanen.grizzlyjersey;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;

/**
 * ResourceConfig extends JaxRs Application with extra features.
 */
public class JaxRsApp extends ResourceConfig {

    public JaxRsApp() {

        property(FreemarkerMvcFeature.TEMPLATE_BASE_PATH, "templates");
        property(FreemarkerMvcFeature.CACHE_TEMPLATES, true);

        register(FreemarkerMvcFeature.class);
        register(LoggingFeature.class);

        register(JaxRsResource.class);
    }
}

