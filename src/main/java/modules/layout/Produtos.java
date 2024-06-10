package modules.layout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import modules.models.ProdutoModel;
import modules.produto.repository.ProdutoRepository;

@Controller
public class Produtos {
    @Autowired
    private ProdutoRepository proService;

    @GetMapping("/produtos")
    public String produto(Model model) {
        List<ProdutoModel> produtos = proService.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

}
