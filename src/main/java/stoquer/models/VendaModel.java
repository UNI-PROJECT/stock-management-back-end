package stoquer.models;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


//Tabela de registros de venda
@Entity
@Table(name = "Venda")
public class VendaModel implements Serializable{
    private static final long serialVersioUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private stoquer.models.ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private stoquer.models.ProdutoModel produto;


    @ManyToOne
    @JoinColumn(name = "id_funcionario")
    private stoquer.models.funcionarioModel funionario;

    private LocalDate data_da_venda;
    private Double totalDaVenda;
    private String descricao;

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public ClienteModel getCliente() {return cliente;}
    public void setCliente(ClienteModel cliente) {this.cliente = cliente;}

    public LocalDate getData_da_venda() {return data_da_venda;}
    public void setData_da_venda(LocalDate data_da_venda) {this.data_da_venda = data_da_venda;}

    public Double getTotalDaVenda() {return totalDaVenda;}
    public void setTotalDaVenda(Double totalDaVenda) {this.totalDaVenda = totalDaVenda;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public funcionarioModel getFunionario() {return funionario;}

    public void setFunionario(funcionarioModel funionario) {this.funionario = funionario;}

    public ProdutoModel getProduto() {return produto;}

    public void setProduto(ProdutoModel produto) {this.produto = produto;}
}
