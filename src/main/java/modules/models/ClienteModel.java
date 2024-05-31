package modules.models;


import java.io.Serializable;
import java.util.UUID;

import enums.TipoCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class ClienteModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    // @Transient
    // private UUID usuario_id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;
    

    @Column
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

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;

    }

    public UsuarioModel getUsuario() {
        return usuario;
    }
}
