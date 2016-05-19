package fi.iki.mkuokkanen.sparkproto;

import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerEngine;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

public class SparkApplication {

    public static void main(String[] args) {

        // set port
        port(8080);

        // location to serve files from
        staticFileLocation("/public");

        get("/test/hello", "text/plain", (req, res) -> "hello world");

        get("/test/page", "text/html", SparkApplication::handleGetPage, new FreeMarkerEngine());
    }

    private static ModelAndView handleGetPage(Request req, Response res) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("user", "Matti");
        return new ModelAndView(attributes, "index.ftl");
    }
}
