package modules.layout;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import modules.cliente.repository.ClienteRepository;
import modules.models.ProdutoModel;
import modules.models.VendaModel;
import modules.produto.repository.ProdutoRepository;
import modules.venda.repository.VendaRepository;


import org.springframework.data.domain.Pageable;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Controller
public class Dashboard {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/")
    public String dashboard(Model model) {
        Pageable pageable = PageRequest.of(0, 5);

        Double receitaTotal = vendaRepository.calcularReceitaTotal(); 
        Integer totalProdutos = produtoRepository.sumAllQuantidades();
        List<ProdutoModel> produtosRecentes = produtoRepository.findTop5ByOrderByDataCadastroDesc(pageable);
        Integer totalClientes = (int) clienteRepository.count();
        Double totalProdutosVendidosKZ = vendaRepository.calcularReceitaTotal(); 
        List<VendaModel> ultimasVendas = vendaRepository.encontrarVendasRecentes(pageable);
        List<VendaModel> produtosMaisVendidos = vendaRepository.findTop5ByOrderByDataDaVendaDesc(pageable);

        LocalDate agora = LocalDate.now();
        LocalDate primeiroDiaDaSemana = agora.with(DayOfWeek.MONDAY);
        LocalDate ultimoDiaDaSemana = primeiroDiaDaSemana.plusDays(6);

        Double ganhoSemanal = vendaRepository.calcularGanhosSemanais(primeiroDiaDaSemana, ultimoDiaDaSemana);

        LocalDate primeiroDiaDoMes = agora.withDayOfMonth(1); 
        LocalDate primeiroDiaDoProximoMes = primeiroDiaDoMes.plusMonths(1); 
        Double ganhoMensal = vendaRepository.calcularGanhosMensais(primeiroDiaDoMes, primeiroDiaDoProximoMes);

 

        // Integer totalFornecedores = fornecedorRepository.count();


        model.addAttribute("receitaTotal", receitaTotal);
        model.addAttribute("totalProdutos", totalProdutos);
        model.addAttribute("totalProdutosVendidosKZ", totalProdutosVendidosKZ);
        // model.addAttribute("totalFornecedores", totalFornecedores);
        model.addAttribute("totalClientes", totalClientes);
        model.addAttribute("produtosRecentes", produtosRecentes);
        model.addAttribute("produtosMaisVendidos", produtosMaisVendidos);
        model.addAttribute("vendas", ultimasVendas);
        model.addAttribute("ganhoMensal", ganhoMensal);
        model.addAttribute("ganhoSemanal", ganhoSemanal);

        return "dashboard";
    }
}
