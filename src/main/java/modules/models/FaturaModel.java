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

@Entity
@Table(name = "Fatura")
public class FaturaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String nome;
    public String descricao;


    @ManyToOne
    @JoinColumn(name = "id_venda")
    public modules.models.VendaModel venda;
 

    public UUID getId(){return id;}
    public void  setID (UUID id){this.id = id;}

    public String getNOme(){return nome;}
    public void setNome(String nome){this.nome =  nome;}

    public String getDescricao(){return descricao;}
    public void setDescricao(String descricao){this.descricao = descricao;}


}

