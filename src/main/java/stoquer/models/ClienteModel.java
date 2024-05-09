package stoquer.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import stoquer.enums.TipoCliente;


//Tabela Cliente
@Entity
@Table(name = "Cliente")
public class ClienteModel implements Serializable{
    private static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private  stoquer.models.UsuarioModel usuario;
    private TipoCliente tipo_cliente;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

   
}
