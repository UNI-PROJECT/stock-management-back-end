package modules.estoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modules.models.EstoqueModel;
import java.util.UUID;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueModel, UUID> {
}
