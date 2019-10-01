package fi.mkuokkanen.webproto.spark;

import com.google.gson.Gson;

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

        Gson gson = new Gson();
        get("/test/json", "application/json", SparkApplication::handleGetJson, gson::toJson);

    }

    private static ModelAndView handleGetPage(Request req, Response res) {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("user", "Matti");
        return new ModelAndView(attributes, "index.ftl");
    }

    private static Person handleGetJson(Request req, Response res) {
        String name = req.queryParamOrDefault("name", "Matti");
        int age = Integer.parseInt(req.queryParamOrDefault("age", "36"));

        res.type("application/json");

        return new Person(name, age);
    }
}
