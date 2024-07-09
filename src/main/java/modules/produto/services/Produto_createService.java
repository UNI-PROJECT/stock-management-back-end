package modules.produto.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modules.EntradaProduto.repository.EntradaProdutoRepository;
import modules.categoria.repository.CategoriaRepository;
import modules.models.CategoriaModel;
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
  private CategoriaRepository categoriaRepository;

  @Autowired
  private EntradaProdutoRepository entradaRepository;

  public EntradaProduto create(CreateProdutoInput data) {

    var categoria = new CategoriaModel();
    categoria.setDescricao(data.descricao);
    categoria.setNome(data.categoria);
    categoriaRepository.save(categoria);

    var produto = new ProdutoModel();
    produto.setNome(data.nome);
    produto.setDescricao(data.descricao);
    produto.setPreco(data.preco);
    produto.setQuantidade(data.quantidade);
    produto.setCategoria(categoria);
    produtoRepository.save(produto);

    var entrada = new EntradaProduto();
    entrada.setData_de_entrada(LocalDate.now());
    entrada.setQuantidade(data.quantidade);
    entrada.setProduto(produto);
    entradaRepository.save(entrada);

    return entradaRepository.save(entrada);
  }

  public List<ProdutoModel> getAll() {
    return produtoRepository.findAll();
  }

  public Optional<ProdutoModel> findById(UUID id) {
    return produtoRepository.findById(id);
  }

  public void delete(UUID id) {
    System.err.println(id);
    produtoRepository.deleteById(id);
  }

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
