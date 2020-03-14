package fi.mkuokkanen.webproto.spincast;

import com.google.inject.Scopes;
import org.spincast.core.guice.SpincastGuiceModuleBase;

public class ScModule extends SpincastGuiceModuleBase {

    @Override
    protected void configure() {
        bind(ScConfig.class).to(ScConfigDefault.class).in(Scopes.SINGLETON);
        bind(ScController.class).in(Scopes.SINGLETON);
    }
}
