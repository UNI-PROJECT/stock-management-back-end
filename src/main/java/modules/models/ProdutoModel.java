package modules.models;

import java.io.Serializable;
import java.util.UUID;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Tabela Produto
@Entity
@Table(name = "Produto")
public class ProdutoModel implements Serializable {
    private static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String descricao;
    private double preco;

    // @ManyToOne
    // @JoinColumn(name = "categoria_id")
    // private  stoquer.models.CategoriaModel categoria;


    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public double getPreco() {return preco;}
    public void setPreco(double preco) {this.preco = preco;}

 


}
