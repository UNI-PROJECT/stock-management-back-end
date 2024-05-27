package modules.EntradaProduto.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import modules.EntradaProduto.services.EntradaProdutoService;
import modules.models.EntradaProduto;



@RestController
public class EntradaProdutoController {
    @Autowired
    private EntradaProdutoService entradaProduto;

    @GetMapping("entrada-produto/listar")
    public ResponseEntity<List<EntradaProduto>> findAll() {
        return ResponseEntity.ok(entradaProduto.getAll());
    }

    @GetMapping("/entrada-produto/{id}")
    public ResponseEntity<EntradaProduto> getvendaById(@PathVariable UUID id) {
        Optional<EntradaProduto> produto = entradaProduto.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // @DeleteMapping("/venda/{id}")
    // public void deleteCliente(@PathVariable UUID id) {
    //     saidaProduto.delete(id);
    // }
    

}
