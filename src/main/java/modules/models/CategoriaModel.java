package modules.models;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Tabela Categoria
@Entity
@Table(name = "Categoria")
public class CategoriaModel implements Serializable {
    private static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String descricao;

    public UUID getId(){return id;}
    public void  setID (UUID id){this.id = id;}

    public String getNOme(){return nome;}
    public void setNome(String nome){this.nome =  nome;}

    public String getDescricao(){return descricao;}
    public void setDescricao(String descricao){this.descricao = descricao;}


    
}


//GENHESssd