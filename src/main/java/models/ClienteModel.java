package models;

import java.io.Serializable;
import java.util.UUID;

import enums.TipoCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


//Tabela Cliente
@Entity
@Table(name = "Cliente")
public class ClienteModel implements Serializable{
    private static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private  models.UsuarioModel usuario_id;
    
    private TipoCliente tipo_cliente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public TipoCliente getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(TipoCliente tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public UsuarioModel getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(UsuarioModel usuario_id) {
        this.usuario_id = usuario_id;
    }
}
