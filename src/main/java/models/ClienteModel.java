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
    private  models.UsuarioModel usuario;
    private TipoCliente tipo_cliente;

    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

   
}
