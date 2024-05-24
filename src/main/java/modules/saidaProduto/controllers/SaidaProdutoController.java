package modules.saidaProduto.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import modules.models.SaidaProduto;
import modules.saidaProduto.services.SaidaProdutoService;





@RestController
public class SaidaProdutoController {
    @Autowired
    private SaidaProdutoService saidaProduto;

    @GetMapping("saida-produto/listar")
    public ResponseEntity<List<SaidaProduto>> findAll() {
        return ResponseEntity.ok(saidaProduto.getAll());
    }

    @GetMapping("/saida-produto/{id}")
    public ResponseEntity<SaidaProduto> getvendaById(@PathVariable UUID id) {
        Optional<SaidaProduto> venda = saidaProduto.findById(id);
        if (venda.isPresent()) {
            return ResponseEntity.ok(venda.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // @DeleteMapping("/venda/{id}")
    // public void deleteCliente(@PathVariable UUID id) {
    //     saidaProduto.delete(id);
    // }
    

}
