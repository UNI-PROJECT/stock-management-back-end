package modules.venda.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modules.cliente.repository.ClienteRepository;
import modules.funcionario.repository.FuncionarioRepository;
import modules.models.ClienteModel;
import modules.models.ProdutoModel;
import modules.models.SaidaProduto;
import modules.models.VendaModel;
import modules.produto.repository.ProdutoRepository;
import modules.saidaProduto.repository.SaidaProdutoRepository;
import modules.venda.dtos.CreateVendaInput;
import modules.venda.repository.VendaRepository;

@Service
public class VendaCrudService {

  @Autowired
  SaidaProdutoRepository saidaProdutoRepository;

  @Autowired
  private VendaRepository vendaRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  public VendaModel create(CreateVendaInput data) {
    ClienteModel cliente = clienteRepository.findById(data.cliente_id)
        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

    var venda = new VendaModel();
    venda.setCliente(cliente);
    venda.setData_da_venda(LocalDate.now());

    if (!data.produto_ids.isEmpty()) {
      ProdutoModel primeiroProduto = produtoRepository.findById(data.produto_ids.get(0))
          .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
      String numeroFatura = gerarNumeroFatura(primeiroProduto.getNome());
      venda.setFatura(numeroFatura);
    }

    double totalDaVenda = 0.0;
    for (UUID produtoId : data.produto_ids) {
      ProdutoModel produto = produtoRepository.findById(produtoId)
          .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
      venda.getProdutos().add(produto);
      totalDaVenda += produto.getPreco();

      SaidaProduto saidaProduto = new SaidaProduto();
      saidaProduto.setData_de_saida(LocalDate.now());
      saidaProduto.setProduto(produto);
      saidaProduto.setQuantidade(1); 
      saidaProdutoRepository.save(saidaProduto);
    }

    venda.setTotalDaVenda(data.totalDaVenda);
    return vendaRepository.save(venda);
  }

  private String gerarNumeroFatura(String nomeProduto) {
    String prefixo = nomeProduto.length() >= 3
        ? nomeProduto.substring(0, 3).toUpperCase()
        : nomeProduto.toUpperCase();

    Random random = new Random();
    int numero1 = random.nextInt(900) + 100;
    int numero2 = random.nextInt(9000) + 1000;

    return String.format("%s-%03d-%04d", prefixo, numero1, numero2);
  }

  public List<VendaModel> getAll() {
    return vendaRepository.findAll();
  }

  public Optional<VendaModel> findById(UUID id) {
    return vendaRepository.findById(id);
  }

  public void delete(UUID id) {
    vendaRepository.deleteById(id);
  }
}
