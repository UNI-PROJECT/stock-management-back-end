package stoquer.produto.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import stoquer.models.ProdutoModel;
import stoquer.produto.dtos.CreateProdutoInput;
import stoquer.produto.dtos.UpdateProdutoInput;
import stoquer.produto.repository.ProdutoRepository;

import java.util.NoSuchElementException;


@Service
public class Produto_createService {
  @Autowired
  private ProdutoRepository produtoRepository;

  // Cadastro dos produtos
  public ProdutoModel create(CreateProdutoInput data) {
    var produto = new ProdutoModel();
    produto.setNome(data.nome);
    produto.setDescricao(data.descricao);
    produto.setPreco(data.preco);
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
