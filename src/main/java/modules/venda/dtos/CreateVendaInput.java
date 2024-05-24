package modules.venda.dtos;

import java.time.LocalDate;
import java.util.UUID;

public class CreateVendaInput {
    public UUID cliente_id;
    public UUID funionario_id;
    public UUID produto_id;
    public LocalDate data_da_venda;
    public String descricao;
}
