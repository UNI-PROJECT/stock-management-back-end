package stoquer.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Saida_produto")
public class SaidaProduto {
    private static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private  stoquer.models.ProdutoModel produto;
    private Integer quantidade;
    private LocalDate data_de_saida;


    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public ProdutoModel getProduto() {return produto;}
    public void setProduto(ProdutoModel produto) {this.produto = produto;}

    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}

    public LocalDate getData_de_saida() {return data_de_saida;}
    public void setData_de_saida(LocalDate data_de_saida) {this.data_de_saida = data_de_entrada;}

    
}
