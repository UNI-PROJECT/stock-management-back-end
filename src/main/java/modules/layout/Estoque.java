package modules.layout;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Estoque {


    @GetMapping("/estoque")
    public String estoque(Model model) {
        return "estoque";
    }
    
}
