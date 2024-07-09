package modules.layout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import modules.models.ProdutoModel;
import modules.produto.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class Produtos {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public String listarProdutos(Model model) {
        List<ProdutoModel> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);

        ProdutoModel produtoModel = new ProdutoModel(); 
        model.addAttribute("produtoModel", produtoModel);
        return "produtos";
    }

    @PostMapping("/produtos/registrar")
    public String adicionarNovoProduto(@ModelAttribute ProdutoModel produto) {
        System.err.println("Dados" + produto);
        produtoRepository.save(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/produto/editar/{id}")
    public String exibirFormularioEditarProduto(@PathVariable UUID id, Model model) {
        Optional<ProdutoModel> optionalProduto = produtoRepository.findById(id);
        model.addAttribute("produto", optionalProduto.get());
        return "editar";
    }

    @PostMapping("/produto/edit/{id}")
    public String editarProduto(@PathVariable UUID id, ProdutoModel produtoAtualizado) {
        System.err.println("Produto:" + produtoAtualizado);
        Optional<ProdutoModel> optionalProduto = produtoRepository.findById(id);
      
            ProdutoModel produtoExistente = optionalProduto.get();
            produtoExistente.setNome(produtoAtualizado.getNome());
            // produtoExistente.setCategoria(produtoAtualizado.getCategoria());
            produtoExistente.setPreco(produtoAtualizado.getPreco());
            produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());
            produtoRepository.save(produtoExistente);
            return "redirect:/produtos";
       
    }



    @GetMapping("/produto/detalhe/{id}")
    public String VerProduto(@PathVariable UUID id, Model model) {
        Optional<ProdutoModel> optionalProduto = produtoRepository.findById(id);
        model.addAttribute("produto", optionalProduto.get());
        return "detalhes";
    }

    @GetMapping("/produto/excluir/{id}")
    public String excluirProduto(@PathVariable UUID id) {
        produtoRepository.deleteById(id);
        return "redirect:/produtos";
    }
}
