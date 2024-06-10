package modules.models;

import java.io.Serializable;
import java.util.UUID;

import enums.TipoUsuario;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Tabele de cadastro de usuário
@Entity
@Table(name = "Usuario")
public class UsuarioModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String nome;
    public String email;
    public String telefone;
    public String nacionalidade;
    public String endereco;
    public String data_nacimento;
    public String senha;
    public String avatar;
    public TipoUsuario tipoUsuario;

   

    public UUID getId() {return id; }
    public void setId(UUID id) {this.id = id;}

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

    public String getAvatar() {return avatar;}
    public void setAvatar(String avatar) {this.avatar = avatar;}

    public TipoUsuario getTipoUsuario() {return tipoUsuario;}
    public void setTipoUsuario(TipoUsuario tipoUsuario) {this.tipoUsuario = tipoUsuario;}
}
