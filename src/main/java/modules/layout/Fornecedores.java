package modules.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Fornecedores {


    @GetMapping("/fornecedores")
    public String fornecedores() {
        return "fornecedores";
    }
    
}
