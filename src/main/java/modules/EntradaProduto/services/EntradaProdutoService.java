package modules.EntradaProduto.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modules.EntradaProduto.repository.EntradaProdutoRepository;
import modules.models.EntradaProduto;

@Service
public class EntradaProdutoService {

  @Autowired
  EntradaProdutoRepository entrSaidaProdutoRepository;



  public List<EntradaProduto> getAll() {
    return entrSaidaProdutoRepository.findAll();
  }


  public Optional<EntradaProduto> findById(UUID id) {
    return entrSaidaProdutoRepository.findById(id);
  }


}








