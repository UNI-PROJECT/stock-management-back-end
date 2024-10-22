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
        Integer totalProdutos = produtoRepository.contarProdutos();
        Integer totalClientes = (int) clienteRepository.count();
        Double totalProdutosVendidosKZ = vendaRepository.calcularReceitaTotal(); 
        List<VendaModel> ultimasVendas = vendaRepository.findTop5ByOrderByDataDaVendaDesc(pageable);
        System.err.println("Ultimas vendas: " + ultimasVendask);


        // Integer totalFornecedores = fornecedorRepository.count();




        System.err.println("Receita total: " + receitaTotal);
        System.err.println("Total de produtos: " + totalProdutos);
        System.err.println("Total de clientes: " + totalClientes);
        System.err.println("Total de produtos vendidos em KZ: " + totalProdutosVendidosKZ);

    

        // // Produtos vendidos em KZ (soma dos valores das vendas)

        // // Total de fornecedores

        // // Total de clientes

        // // 5 produtos recentes
        // List<ProdutoModel> produtosRecentes = produtoRepository.findTop5ByOrderByDataCriacaoDesc(); // Assumindo que você tenha um campo de data de criação

        // // Produtos mais vendidos
        // List<ProdutoModel> produtosMaisVendidos = produtoRepository.findTop5ByOrderByVendasDesc(); // Assumindo que você tenha um campo de vendas

        // // Vendas recentes
        // List<VendaModel> vendasRecentes = vendaRepository.findTop5ByOrderByDataVendaDesc(); // Assumindo que você tenha um campo de data de venda

        // // Ganho mensal
        // Double ganhoMensal = vendaRepository.sumGanhoMensal(); // Assumindo que você tenha um método para isso

        // // Ganho semanal
        // Double ganhoSemanal = vendaRepository.sumGanhoSemanal(); // Assumindo que você tenha um método para isso

        // // Adicionando dados ao modelo
        // model.addAttribute("receitaTotal", receitaTotal);
        // model.addAttribute("totalProdutos", totalProdutos);
        // model.addAttribute("totalProdutosVendidosKZ", totalProdutosVendidosKZ);
        // model.addAttribute("totalFornecedores", totalFornecedores);
        // model.addAttribute("totalClientes", totalClientes);
        // model.addAttribute("produtosRecentes", produtosRecentes);
        // model.addAttribute("produtosMaisVendidos", produtosMaisVendidos);
        // model.addAttribute("vendasRecentes", vendasRecentes);
        // model.addAttribute("ganhoMensal", ganhoMensal);
        // model.addAttribute("ganhoSemanal", ganhoSemanal);

        return "dashboard";
    }
}
