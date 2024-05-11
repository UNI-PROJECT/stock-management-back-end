package stoquer.produto.dtos;

import stoquer.models.CategoriaModel;

public class CreateProdutoInput {
    public String nome;
    public String descricao;
    public double preco;
    public CategoriaModel categoria;
}
