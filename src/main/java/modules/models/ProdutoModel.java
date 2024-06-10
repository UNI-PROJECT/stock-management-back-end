package modules.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Tabela Produto
@Entity
@Table(name = "Produto")
public class ProdutoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String nome;
    public String descricao;
    public double preco;
    public Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private  CategoriaModel categoria;





    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public double getPreco() {return preco;}
    public void setPreco(double preco) {this.preco = preco;}

    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}

    public CategoriaModel getCategoria() {return categoria;}
    public void setCategoria(CategoriaModel categoria) {this.categoria = categoria;}



 


}
