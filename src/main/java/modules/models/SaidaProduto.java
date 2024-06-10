package modules.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Tabela de saídas de produto
@Entity
@Table(name = "Saida_produto")
public class SaidaProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    public  modules.models.ProdutoModel produto;
    public Integer quantidade;
    public LocalDate data_de_saida;


    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public ProdutoModel getProduto() {return produto;}
    public void setProduto(ProdutoModel produto) {this.produto = produto;}

    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}

    public LocalDate getData_de_saida() {return data_de_saida;}
    public void setData_de_saida(LocalDate data_de_saida) {this.data_de_saida = data_de_saida;}


    
}
