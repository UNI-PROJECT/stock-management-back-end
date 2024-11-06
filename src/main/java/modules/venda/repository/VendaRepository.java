package modules.venda.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import modules.models.VendaModel;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface VendaRepository extends JpaRepository<VendaModel, UUID> {

    @Query("SELECT SUM(v.totalDaVenda) FROM VendaModel v")
    Double calcularReceitaTotal();

    @Query("SELECT v FROM VendaModel v ORDER BY v.data_da_venda DESC")
    Page<VendaModel> findUltimaVenda(Pageable pageable);
    

    @Query(value = "SELECT v FROM VendaModel v ORDER BY v.data_da_venda DESC")
    List<VendaModel> findTop5ByOrderByDataDaVendaDesc(Pageable pageable);

    @Query("SELECT COUNT(v) FROM VendaModel v")
    Integer contarVendas();

    @Query("SELECT v FROM VendaModel v ORDER BY v.data_da_venda DESC")
    List<VendaModel> encontrarVendasRecentes(Pageable pageable);

    @Query("SELECT SUM(v.totalDaVenda) FROM VendaModel v WHERE v.data_da_venda >= :startDate AND v.data_da_venda < :endDate")
    Double calcularGanhosMensais(LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(v.totalDaVenda) FROM VendaModel v WHERE v.data_da_venda >= :startDate AND v.data_da_venda < :endDate")
    Double calcularGanhosSemanais(LocalDate startDate, LocalDate endDate);
}
