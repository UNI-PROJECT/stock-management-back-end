package modules.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Cliente {


    @GetMapping("/clientes")
    public String index() {
        return "clientes";
    }
    
}
