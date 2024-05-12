package modules.categoria.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.CategoriaModel;
import modules.categoria.dtos.CreateCategoriaInput;
import modules.categoria.dtos.UpdateCategoriaInput;
import modules.categoria.repository.CategoriaRepository;
import modules.produto.dtos.UpdateProdutoInput;

import java.util.NoSuchElementException;


@Service
public class CategoriaCrudService {
  @Autowired
  private CategoriaRepository categoriaRepository;

  // Cadastro das categoria
  public CategoriaModel create(CreateCategoriaInput data) {
    var categoria = new CategoriaModel();
    categoria.setNome(data.nome);
    categoria.setDescricao(data.descricao);
    return categoriaRepository.save(categoria);
  }

  // Listagem das categoria
  public List<CategoriaModel> getAll() {
    return categoriaRepository.findAll();
  }

  // // Encontrar categoria pelo ID
  // public Optional<CategoriaModel> findById(UUID id) {
  //   return CategoriaRepository.findById(id);
  // }

  // // Deleta categoria
  // public void delete(UUID id) {
  //   CategoriaRepository.deleteById(id);
  // }

  // // Autualizar categoria
  // public CategoriaModel update(UUID id, UpdateCategoriaInput data) {
  //   Optional<CategoriaModel> categoriaOptional = CategoriaRepository.findById(id);

  //   if (categoriaOptional.isPresent()) {
  //     CategoriaModel categoria = categoriaOptional.get();
  //     categoria.setNome(data.nome); 
  //     categoria.setDescricao(data.descricao);
  //     return categoriaRepository.save(categoria);
  //   } else {
  //     throw new NoSuchElementException("categoria não encontrado com o id: " + id);
  //   }
  // }
}
