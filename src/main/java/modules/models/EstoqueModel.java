package modules.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Tabela Estoque
@Entity
@Table(name = "Estoque")
public class EstoqueModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    public  modules.models.ProdutoModel produto;
    public Integer quantidade;


    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public ProdutoModel getProduto() {return produto;}
    public void setProduto(ProdutoModel produto) {this.produto = produto;}

    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}
}
