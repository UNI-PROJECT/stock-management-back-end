package modules.cliente.dtos;


import enums.TipoCliente;
import modules.models.UsuarioModel;

public class CreateClienteInput {
    public UsuarioModel id_usuario;
    public TipoCliente tipo_cliente;
    public String nome;
    public String email;
    public String telefone;
    public String nacionalidade;
    public String endereco;
    public String senha;

}
