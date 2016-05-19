package fi.iki.mkuokkanen.undertowresteasy;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

/**
 * Utility class to setup FreeMarker configuration.
 */
public class FMUtil {

    private static Configuration CONFIG_INSTANCE;

    public static Configuration config() {
        if (CONFIG_INSTANCE == null) {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
            ClassTemplateLoader loader = new ClassTemplateLoader(FMUtil.class, "/templates");
            cfg.setTemplateLoader(loader);
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
            cfg.setLogTemplateExceptions(false);

            CONFIG_INSTANCE = cfg;
        }

        return CONFIG_INSTANCE;
    }

    /**
     * Prevent instances of this helper class.
     */
    private FMUtil() {

    }

}
