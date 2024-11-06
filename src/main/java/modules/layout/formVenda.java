package modules.layout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import modules.models.VendaModel;
import modules.venda.repository.VendaRepository;

@Controller
public class formVenda {

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping("/venda/efetuar")
    public String efetuarVenda(@ModelAttribute VendaModel venda) {
        vendaRepository.save(venda);
        return "form";
    }

}
