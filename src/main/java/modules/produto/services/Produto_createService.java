package modules.produto.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modules.EntradaProduto.repository.EntradaProdutoRepository;
import modules.models.EntradaProduto;
import modules.models.ProdutoModel;
import modules.produto.dtos.CreateProdutoInput;
import modules.produto.dtos.UpdateProdutoInput;
import modules.produto.repository.ProdutoRepository;

import java.util.NoSuchElementException;


@Service
public class Produto_createService {
  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private EntradaProdutoRepository entradaRepository;

  // Cadastro dos produtos
  public ProdutoModel create(CreateProdutoInput data) {
    var produto = new ProdutoModel();
    produto.setNome(data.nome);
    produto.setDescricao(data.descricao);
    produto.setPreco(data.preco);

    var entrada = new EntradaProduto();
    entrada.setData_de_entrada(LocalDate.now());
    entrada.setQuantidade(1);
    entrada.setProduto(produto); 
    entradaRepository.save(entrada);

    return produtoRepository.save(produto);
  }
 
  // Listagem dos produtos
  public List<ProdutoModel> getAll() {
    return produtoRepository.findAll();
  }

  // Encontrar produto pelo ID
  public Optional<ProdutoModel> findById(UUID id) {
    return produtoRepository.findById(id);
  }

  // Deleta produto
  public void delete(UUID id) {
    produtoRepository.deleteById(id);
  }

  // Autualizar produto
  public ProdutoModel update(UUID id, UpdateProdutoInput data) {
    Optional<ProdutoModel> produtoOptional = produtoRepository.findById(id);

    if (produtoOptional.isPresent()) {
      ProdutoModel produto = produtoOptional.get();
      produto.setNome(data.nome);
      produto.setDescricao(data.descricao);
      produto.setPreco(data.preco);
      return produtoRepository.save(produto);
    } else {
      throw new NoSuchElementException("Produto não encontrado com o id: " + id);
    }
  }
}
