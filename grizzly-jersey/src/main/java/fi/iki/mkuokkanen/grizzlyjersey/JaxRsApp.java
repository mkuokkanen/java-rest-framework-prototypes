package fi.iki.mkuokkanen.grizzlyjersey;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//Application path is ignored by jersey?
//@ApplicationPath("/gj")
public class JaxRsApp extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<>();
        classes.add(JaxRsResource.class);
        return classes;
    }
}

