package modules.EntradaProduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modules.models.EntradaProduto;

import java.util.UUID;

@Repository
public interface EntradaProdutoRepository extends JpaRepository<EntradaProduto, UUID> {
}
