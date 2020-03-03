package fi.mkuokkanen.webproto.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class SBRestController {

    @GetMapping("/hello")
    public String getHello() {
        return "hello world";
    }

    @GetMapping("/json")
    public PersonJaxb getJson(@RequestParam(value = "name", required = false, defaultValue = "Matti") String name,
                              @RequestParam(value = "age", required = false, defaultValue = "36") int age) {
        return new PersonJaxb(name, age);
    }
}
