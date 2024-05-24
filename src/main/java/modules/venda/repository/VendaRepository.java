package modules.venda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modules.models.VendaModel;

import java.util.UUID;

@Repository
public interface VendaRepository extends JpaRepository<VendaModel, UUID> {
}
