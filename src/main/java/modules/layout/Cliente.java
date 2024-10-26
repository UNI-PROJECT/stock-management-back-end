package modules.layout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import modules.models.ClienteModel;
import modules.models.ProdutoModel;
import modules.cliente.repository.ClienteRepository;


@Controller
public class Cliente {


    @Autowired
    private ClienteRepository clienteRepository;


    @GetMapping("/clientes")
    public String index(Model model) {
        List<ClienteModel> produtos = clienteRepository.findAll();
        model.addAttribute("cliente", produtos);

        ProdutoModel produtoModel = new ProdutoModel(); 
        model.addAttribute("produtoModel", produtoModel);
        return "clientes";
    }
    
}
