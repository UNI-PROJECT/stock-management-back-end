package modules.estoque.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modules.cliente.repository.ClienteRepository;
import modules.estoque.repository.EstoqueRepository;
import modules.funcionario.repository.FuncionarioRepository;
import modules.models.ClienteModel;
import modules.models.EstoqueModel;
import modules.models.ProdutoModel;
import modules.models.SaidaProduto;
import modules.models.VendaModel;
import modules.models.funcionarioModel;
import modules.produto.repository.ProdutoRepository;
import modules.saidaProduto.repository.SaidaProdutoRepository;
import modules.venda.dtos.CreateVendaInput;
import modules.venda.repository.VendaRepository;

@Service
public class EstoqueService {

  @Autowired
  EstoqueRepository estoqueRepository;



  public List<EstoqueModel> getAll() {
    return estoqueRepository.findAll();
  }




}








