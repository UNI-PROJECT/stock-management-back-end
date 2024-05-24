package modules.venda.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modules.cliente.repository.ClienteRepository;
import modules.funcionario.repository.FuncionarioRepository;
import modules.models.ClienteModel;
import modules.models.ProdutoModel;
import modules.models.SaidaProduto;
import modules.models.VendaModel;
import modules.models.funcionarioModel;
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

  public VendaModel create(CreateVendaInput data){

  
    ClienteModel cliente = clienteRepository.findById(data.cliente_id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    ProdutoModel produto = produtoRepository.findById(data.produto_id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    funcionarioModel funcionario = funcionarioRepository.findById(data.funionario_id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

    var venda = new VendaModel();
    venda.setCliente(cliente);
    venda.setProduto(produto);
    venda.setFunionario(funcionario);
    venda.setData_da_venda(LocalDate.now());
    venda.setTotalDaVenda(produto.getPreco());

    var saidaProduto =  new SaidaProduto();

    saidaProduto.setData_de_saida(LocalDate.now());
    saidaProduto.setProduto(produto);
    saidaProduto.setQuantidade(1);
    saidaProdutoRepository.save(saidaProduto);




    return vendaRepository.save(venda);
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








