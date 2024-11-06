package modules.cliente.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

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

    private Number gerarNumeroClienteAleatorio() {
      int anoAtual = java.time.Year.now().getValue();
      int numeroAleatorio = new Random().nextInt(9000) + 1000; 
      return (anoAtual * 10000L) + numeroAleatorio; 
  }
  
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
        cliente.setNumeroCliente(gerarNumeroClienteAleatorio()); 
        cliente.setUsuario(usuario);
        cliente.setTipo_cliente(TipoCliente.PARTICULAR);

        return clienteRepository.save(cliente);
    }

    public List<ClienteModel> getAll() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findById(UUID id) {
        return clienteRepository.findById(id);
    }

    public void delete(UUID id) {
        clienteRepository.deleteById(id);
    }
}
