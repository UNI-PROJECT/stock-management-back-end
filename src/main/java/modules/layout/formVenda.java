package modules.layout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;


import modules.models.ProdutoModel;
import modules.produto.repository.ProdutoRepository;

@Controller
public class formVenda {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping("/venda/efetuar")
    public String efetuarVenda(Model model){


        List<ProdutoModel> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);

        ProdutoModel produtoModel = new ProdutoModel(); 
        model.addAttribute("produtoModel", produtoModel);
        return "form";
    }

}
