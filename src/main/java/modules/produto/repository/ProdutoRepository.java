package modules.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import modules.models.ProdutoModel;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {

     @Query("SELECT SUM(p.quantidade) FROM ProdutoModel p")
    Integer sumAllQuantidades();

    @Query("SELECT COUNT(p) FROM ProdutoModel p")
    Integer contarProdutos();

    @Query("SELECT p FROM ProdutoModel p WHERE p.quantidade != 0")
    List<ProdutoModel> findAllWithNonZeroQuantity();

}
