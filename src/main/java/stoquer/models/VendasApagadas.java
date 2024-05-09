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

@Entity
@Table(name = "Vendas_apagadas")
public class VendasApagadas implements Serializable{
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
}
