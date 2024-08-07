package modules.produto.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modules.models.EntradaProduto;
import modules.models.ProdutoModel;
import modules.produto.dtos.CreateProdutoInput;
import modules.produto.dtos.UpdateProdutoInput;
import modules.produto.services.Produto_createService;

@RestController
// @RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private Produto_createService proService;

    @GetMapping("produto/listar")
    public ResponseEntity<List<ProdutoModel>> findAll() {
        return ResponseEntity.ok(proService.getAll());
    }

    @GetMapping("/produto/{id}")
    public ResponseEntity<ProdutoModel> getProdutoById(@PathVariable UUID id) {
        Optional<ProdutoModel> produtoOptional = proService.findById(id);
        if (produtoOptional.isPresent()) {
            return ResponseEntity.ok(produtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("produto/registrar")
    public ResponseEntity<EntradaProduto> create(@RequestBody CreateProdutoInput data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proService.create(data));

    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<ProdutoModel> updateProduto(@PathVariable UUID id, @RequestBody UpdateProdutoInput data) {
        return ResponseEntity.status(HttpStatus.OK).body(proService.update(id, data));

    }

    @DeleteMapping("/produto/{id}")
    public void deleteProduto(@PathVariable UUID id) {
        proService.delete(id);
    }
    

}
