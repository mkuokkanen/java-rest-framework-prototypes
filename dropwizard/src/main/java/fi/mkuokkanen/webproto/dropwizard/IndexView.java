package fi.mkuokkanen.webproto.dropwizard;

import io.dropwizard.views.View;

public class IndexView extends View {
    private final String name;

    public IndexView(String name) {
        super("/templates/index.ftl");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
