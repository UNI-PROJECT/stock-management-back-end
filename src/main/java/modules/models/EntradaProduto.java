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


@Entity
@Table(name = "entrada_produto")
public class EntradaProduto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    public  modules.models.ProdutoModel produto;
    public Integer quantidade;
    public LocalDate data_de_entrada;


    public UUID getId() {return id;}
    public void setId(UUID id) {this.id = id;}

    public ProdutoModel getProduto() {return produto;}
    public void setProduto(ProdutoModel produto) {this.produto = produto;}

    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}

    public LocalDate getData_de_entrada() {return data_de_entrada;}
    public void setData_de_entrada(LocalDate data_de_entrada) {this.data_de_entrada = data_de_entrada;}
}
