package modules.layout;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.data.domain.Pageable;

import modules.models.VendaModel;
import modules.venda.repository.VendaRepository;

import org.springframework.ui.Model;

@Controller
public class Venda {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/vendas")
    public String vendas(Model model) {
        List<VendaModel> vendas = vendaRepository.findAll();
        Pageable pageable = PageRequest.of(0, 1); 
        Page<VendaModel> ultimaVendaPage = vendaRepository.findUltimaVenda(pageable);
        VendaModel ultimaVenda = ultimaVendaPage.getContent().get(0); 

        model.addAttribute("ultimaVenda", ultimaVenda);

    

        model.addAttribute("vendas", vendas);

        VendaModel produtoModel = new VendaModel();
        model.addAttribute("produtoModel", produtoModel);
        return "vendas";
    }

}
