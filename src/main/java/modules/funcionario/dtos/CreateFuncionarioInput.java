package modules.funcionario.dtos;


import enums.Previlegio;
import modules.models.UsuarioModel;

public class CreateFuncionarioInput {
    public UsuarioModel id_usuario;
    public Previlegio previlegio;
    public String nome;
    public String email;
    public String telefone;
    public String nacionalidade;
    public String endereco;
    public String senha;
}
