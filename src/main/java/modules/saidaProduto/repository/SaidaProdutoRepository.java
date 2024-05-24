package modules.saidaProduto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modules.models.SaidaProduto;

import java.util.UUID;

@Repository
public interface SaidaProdutoRepository extends JpaRepository<SaidaProduto, UUID> {
}
