package stoquer.produto.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @GetMapping
    @RequestMapping("/produto")
    public ResponseEntity Listar() {
        return ResponseEntity.ok("Sim, passou");
    }

}
