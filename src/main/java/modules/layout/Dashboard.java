package modules.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Dashboard {


    @GetMapping("/dashboard")
    public String index() {
        return "index";
    }
    
}
