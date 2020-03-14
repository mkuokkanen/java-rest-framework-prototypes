package fi.mkuokkanen.webproto.spincast;

import com.google.inject.Inject;
import org.spincast.core.server.Server;
import org.spincast.defaults.bootstrapping.Spincast;
import org.spincast.plugins.routing.DefaultRouter;

public class SpincastMain {

    public static void main(String[] args) {
        Spincast.configure()
                .module(new ScModule())
                .init(args);
    }

    @Inject
    protected void init(Server server, DefaultRouter router, ScController controller) {
        router.GET("/test/hello").handle(controller::hello);
        router.GET("/test/page").handle(controller::page);
        router.GET("/test/json").handle(controller::json);
        server.start();
    }
}
