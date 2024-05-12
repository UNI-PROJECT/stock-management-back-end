package modules.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.ProdutoModel;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {
}
