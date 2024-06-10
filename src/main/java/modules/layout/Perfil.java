package modules.layout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Perfil {


    @GetMapping("/perfil")
    public String perfil() {
        return "perfil";
    }
    
}
