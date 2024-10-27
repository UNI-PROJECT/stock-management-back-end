package modules.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class formVenda {
    
    @GetMapping("/venda/efetuar")
    public String efetuarVenda(){
        return "form";
    }

}
