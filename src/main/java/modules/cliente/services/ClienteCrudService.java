package modules.cliente.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.hibernate.mapping.Any;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.TipoCliente;
import enums.TipoUsuario;
import modules.cliente.dtos.CreateClienteInput;
import modules.cliente.repository.ClienteRepository;
import modules.models.ClienteModel;
import modules.models.UsuarioModel;
import modules.usuario.repository.UsuarioRepository;

@Service
public class ClienteCrudService {
  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private UsuarioRepository usuarioRepository;

  //  Cadastro das cliente
  public ClienteModel create(CreateClienteInput data) {
    System.out.println("nome: " + data.nome);
    var usuario = new UsuarioModel();
    usuario.setNome(data.nome);
    usuario.setEmail(data.email);
    usuario.setTelefone(data.telefone);
    usuario.setEndereco(data.endereco);
    usuario.setTipoUsuario(TipoUsuario.CLIENTE);
    usuario.setNacionalidade(data.nacionalidade);
    usuarioRepository.save(usuario);

    var cliente = new ClienteModel();


    // Define o usuário_id manualmente
    cliente.setUsuario(usuario);
    cliente.setTipo_cliente(TipoCliente.PARTICULAR);
    // System.out.println("userID: " + cliente.getUsuario_id());

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
