package modules.categoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modules.models.CategoriaModel;

import java.util.UUID;


//Essa camada se comunica diretamente com o banco de dados
@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, UUID> {
}
