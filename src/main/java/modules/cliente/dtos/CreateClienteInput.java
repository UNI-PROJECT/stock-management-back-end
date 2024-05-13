package modules.cliente.dtos;

import java.util.UUID;

import enums.TipoCliente;
import models.UsuarioModel;

public class CreateClienteInput {
    public UsuarioModel id_usuario;
    public TipoCliente tipo_cliente;
}
