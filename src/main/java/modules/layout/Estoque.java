package modules.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Estoque {


    @GetMapping("/estoque")
    public String estoque() {
        return "estoque";
    }
    
}
