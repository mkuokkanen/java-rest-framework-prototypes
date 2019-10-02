package fi.mkuokkanen.webproto.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;


public class DropwizardApplication extends Application<DropwizardConfig> {

    public static void main(String[] args) throws Exception {
        new DropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropWizard prototype";
    }

    @Override
    public void initialize(Bootstrap<DropwizardConfig> bootstrap) {
        // load config from classpath
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());
        bootstrap.addBundle(new ViewBundle<DropwizardConfig>());
    }

    @Override
    public void run(DropwizardConfig configuration, Environment environment) {
        final DropwizardResource resource = new DropwizardResource(
                configuration.getDefaultName(),
                configuration.getDefaultAge()
        );
        environment.jersey().register(resource);
    }

}
