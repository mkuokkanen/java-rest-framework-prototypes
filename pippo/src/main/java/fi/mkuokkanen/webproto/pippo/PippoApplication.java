package fi.mkuokkanen.webproto.pippo;

import ro.pippo.core.Application;

public class PippoApplication extends Application {

    @Override
    protected void onInit() {
        GET("/test/hello", routeContext -> routeContext.send("Hello World"));

        GET("/test/page", routeContext -> {
            routeContext.setLocal("name", "Matti");
            routeContext.render("hello");
        });

        GET("/test/json", routeContext -> {
            String name = routeContext.getParameter("name").toString("Matti");
            int age = routeContext.getParameter("age").toInt(36);
            Person person = new Person(name, age);
            routeContext.json().send(person);
        });
    }
}