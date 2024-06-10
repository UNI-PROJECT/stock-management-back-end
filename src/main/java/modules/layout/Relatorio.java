package modules.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Relatorio {


    @GetMapping("/relatorio")
    public String relatorio() {
        return "relatorio";
    }
    
}
