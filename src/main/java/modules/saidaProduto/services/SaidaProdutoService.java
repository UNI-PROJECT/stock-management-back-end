package modules.saidaProduto.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modules.models.SaidaProduto;
import modules.saidaProduto.repository.SaidaProdutoRepository;

@Service
public class SaidaProdutoService {

  @Autowired
  SaidaProdutoRepository saidaProdutoRepository;



  public List<SaidaProduto> getAll() {
    return saidaProdutoRepository.findAll();
  }


  public Optional<SaidaProduto> findById(UUID id) {
    return saidaProdutoRepository.findById(id);
  }


}








