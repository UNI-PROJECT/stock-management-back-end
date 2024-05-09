package stoquer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import stoquer.enums.Previlegio;


//Tabela funcionario
@Entity
@Table(name = "Funcionario")
public class funcionarioModel {
    private static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private  stoquer.models.UsuarioModel usuario;
    private Previlegio previlegio;


    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public UsuarioModel getUsuario() {return usuario;}
    public void setUsuario(UsuarioModel usuario) {this.usuario = usuario;}

    public Previlegio getPrevilegio() {return previlegio;}
    public void setPrevilegio(Previlegio previlegio) {this.previlegio = previlegio;}
}
