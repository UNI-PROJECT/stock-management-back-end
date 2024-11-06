package modules.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import jakarta.persistence.*;

@Entity
@Table(name = "Venda")
public class VendaModel implements Serializable {
    
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteModel cliente;

    @ManyToOne(optional = true)
    @JoinColumn(name = "id_funcionario")
    private funcionarioModel funcionario;

    @ManyToMany
    @JoinTable(
        name = "Venda_Produtos",
        joinColumns = @JoinColumn(name = "venda_id"),
        inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    // private List<ProdutoModel> produtos;
    //  private List<ProdutoModel> produtos ;
     private List<ProdutoModel> produtos = new ArrayList<>();
    

    private LocalDate data_da_venda;
    private Double totalDaVenda;
    private String descricao;
    private String n_fatura;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    // Getters e setters para os atributos

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public ClienteModel getCliente() { return cliente; }
    public void setCliente(ClienteModel cliente) { this.cliente = cliente; }

    public LocalDate getData_da_venda() { return data_da_venda; }
    public void setData_da_venda(LocalDate data_da_venda) { this.data_da_venda = data_da_venda; }

    public Double getTotalDaVenda() { return totalDaVenda; }
    public void setTotalDaVenda(Double totalDaVenda) { this.totalDaVenda = totalDaVenda; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getFatura() { return n_fatura; }
    public void setFatura(String n_fatura) { this.n_fatura = n_fatura; }

    public funcionarioModel getFuncionario() { return funcionario; }
    public void setFuncionario(funcionarioModel funcionario) { this.funcionario = funcionario; }

    public List<ProdutoModel> getProdutos() { return produtos; }
    public void setProdutos(List<ProdutoModel> produtos) { this.produtos = produtos; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public Timestamp getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Timestamp updatedAt) { this.updatedAt = updatedAt; }
}
