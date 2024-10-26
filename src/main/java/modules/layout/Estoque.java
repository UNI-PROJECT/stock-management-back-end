package modules.layout;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import modules.models.ProdutoModel;
import modules.produto.repository.ProdutoRepository;



@Controller
public class Estoque {


    @Autowired
    private ProdutoRepository produtoRepository;


    @GetMapping("/estoque")
    public String estoque(Model model) {
           List<ProdutoModel> produtos = produtoRepository.findAllWithNonZeroQuantity();
           model.addAttribute("estoque", produtos != null ? produtos : Collections.emptyList());
   
           Integer totalQuantidades = produtoRepository.sumAllQuantidades();
           model.addAttribute("totalQuantidades", totalQuantidades != null ? totalQuantidades : 0);
   

   
           return "estoque";
    }

    
}
