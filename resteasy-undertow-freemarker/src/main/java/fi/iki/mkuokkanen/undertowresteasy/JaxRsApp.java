package fi.iki.mkuokkanen.undertowresteasy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//@ApplicationPath("/app")
public class JaxRsApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(JaxRsResource.class);
        return classes;
    }
}

