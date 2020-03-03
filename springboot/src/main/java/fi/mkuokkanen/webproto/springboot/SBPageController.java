package fi.mkuokkanen.webproto.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class SBPageController {

    @RequestMapping("/page")
    public String getPage(Model model) {
        model.addAttribute("name", "Matti");
        return "page";
    }
}
