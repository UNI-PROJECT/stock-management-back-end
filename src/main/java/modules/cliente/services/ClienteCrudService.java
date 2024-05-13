package modules.cliente.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.ClienteModel;
import modules.cliente.dtos.CreateClienteInput;
import modules.cliente.repository.ClienteRepository;



@Service
public class ClienteCrudService {
  @Autowired
  private ClienteRepository clienteRepository;

  // Cadastro das cliente
  public ClienteModel create(CreateClienteInput data) {
    var cliente = new ClienteModel();
    cliente.setUsuario_id(data.id_usuario);
    cliente.setTipo_cliente(data.tipo_cliente);
    return clienteRepository.save(cliente);
  }

  // Listagem das cliente-
  public List<ClienteModel> getAll() {
    return clienteRepository.findAll();
  }

  // Encontrar cliente pelo ID
  public Optional<ClienteModel> findById(UUID id) {
    return clienteRepository.findById(id);
  }

  // Deleta cliente
  public void delete(UUID id) {
    clienteRepository.deleteById(id);
  }

 
}
