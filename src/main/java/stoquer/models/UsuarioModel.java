package stoquer.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuario")
public class UsuarioModel {
    private static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nome;
    private String email;
    private String telefone;
    private String nacionalidade;
    private String endereco;
    private String data_nacimento;
    private String senha;

    public String getId() {return id; }
    public void setId(String id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefone() {return telefone;}
    public void setTelefone(String telefone) {this.telefone = telefone;}

    public String getNacionalidade() {return nacionalidade;}
    public void setNacionalidade(String nacionalidade) {this.nacionalidade = nacionalidade;}

    public String getEndereco() {return endereco;}
    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getData_nacimento() {return data_nacimento;}
    public void setData_nacimento(String data_nacimento) {this.data_nacimento = data_nacimento;}

    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
}
