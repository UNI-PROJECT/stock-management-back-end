package modules.venda.dtos;

import java.util.List;
import java.util.UUID;

public class CreateVendaInput {
    public UUID cliente_id;
    public List<UUID> produto_ids; 
    public UUID funcionario_id;
    public Double totalDaVenda;
    
}
