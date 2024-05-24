package modules.funcionario.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import enums.Previlegio;
import enums.TipoUsuario;
import modules.funcionario.dtos.CreateFuncionarioInput;
import modules.funcionario.repository.FuncionarioRepository;
import modules.models.UsuarioModel;
import modules.models.funcionarioModel;
import modules.usuario.repository.UsuarioRepository;

@Service
public class FuncinarioCrudService {
  @Autowired
  private UsuarioRepository usuarioRepository;

  @Autowired
  private FuncionarioRepository funcionarioRepository;

  public funcionarioModel create(CreateFuncionarioInput data) {
    var usuario = new UsuarioModel();
    usuario.setNome(data.nome);
    usuario.setEmail(data.email);
    usuario.setTelefone(data.telefone);
    usuario.setEndereco(data.endereco);
    usuario.setTipoUsuario(TipoUsuario.FUNCIONARIO);
    usuario.setNacionalidade(data.nacionalidade);
    usuarioRepository.save(usuario);

    var funcionario = new funcionarioModel();
    funcionario.setUsuario(usuario);
    funcionario.setPrevilegio(Previlegio.EDITAR);


    return funcionarioRepository.save(funcionario);
  }


  public List<funcionarioModel> getAll() {
    return funcionarioRepository.findAll();
  }


  public Optional<funcionarioModel> findById(UUID id) {
    return funcionarioRepository.findById(id);
  }

  public void delete(UUID id) {
    funcionarioRepository.deleteById(id);
  }
}








