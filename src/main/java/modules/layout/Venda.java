package modules.layout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import modules.models.VendaModel;
import modules.venda.repository.VendaRepository;
import org.springframework.ui.Model;




@Controller
public class Venda {


    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/vendas")
    public String vendas(Model model) {
           List<VendaModel> produtos = vendaRepository.findAll();
        model.addAttribute("vendas", produtos);

        VendaModel produtoModel = new VendaModel(); 
        model.addAttribute("produtoModel", produtoModel);
        return "vendas";
    }
    
}
