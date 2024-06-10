package modules.models;

import java.util.UUID;

import enums.Previlegio;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


//Tabela funcionario
@Entity
@Table(name = "Funcionario")
public class funcionarioModel {
    public static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    public  modules.models.UsuarioModel usuario;
    public Previlegio previlegio;


    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}


    public UsuarioModel getUsuario() {return usuario;}
    public void setUsuario(UsuarioModel usuario) {this.usuario = usuario;}

    public Previlegio getPrevilegio() {return previlegio;}
    public void setPrevilegio(Previlegio previlegio) {this.previlegio = previlegio;}
}


