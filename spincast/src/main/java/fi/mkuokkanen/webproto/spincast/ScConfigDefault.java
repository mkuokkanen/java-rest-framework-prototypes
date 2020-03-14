package fi.mkuokkanen.webproto.spincast;

import com.google.inject.Inject;
import org.spincast.core.guice.TestingMode;
import org.spincast.plugins.config.SpincastConfigDefault;
import org.spincast.plugins.config.SpincastConfigPluginConfig;

public class ScConfigDefault extends SpincastConfigDefault implements ScConfig {

    @Inject
    protected ScConfigDefault(SpincastConfigPluginConfig spincastConfigPluginConfig, @TestingMode boolean testingMode) {
        super(spincastConfigPluginConfig, testingMode);
    }

    @Override
    public int getHttpServerPort() {
        return getInteger("server.port", 12345);
    }

    @Override
    public String getFrameworkName() {
        return getString("app.framework", "something is broken");
    }
}
