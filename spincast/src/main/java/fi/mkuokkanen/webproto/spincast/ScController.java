package fi.mkuokkanen.webproto.spincast;

import com.google.inject.Inject;
import org.spincast.core.exchange.DefaultRequestContext;
import org.spincast.core.json.JsonObject;

public class ScController {

    private final ScConfig config;

    @Inject
    public ScController(ScConfig config) {
        this.config = config;
    }

    public void hello(DefaultRequestContext context) {
        context.response().sendPlainText("Hello from Spincast");
    }

    public void page(DefaultRequestContext context) {
        JsonObject model = context.response().getModel();
        model.set("framework", config.getFrameworkName());

        context.response().sendTemplateHtml("/templates/hello.html");
    }

    public void json(DefaultRequestContext context) {
        String name = context.request().getQueryStringParamFirst("name");
        String age = context.request().getQueryStringParamFirst("age");

        JsonObject data = context.json().create();
        data.set("name", name == null ? "Mikko" : name);
        data.set("age", age == null ? "42" : age);

        context.response().sendJson(data);
    }
}
