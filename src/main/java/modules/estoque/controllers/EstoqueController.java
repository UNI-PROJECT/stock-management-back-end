package modules.estoque.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import modules.estoque.services.EstoqueService;
import modules.models.EstoqueModel;



@RestController
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @GetMapping("estoque/listar")
    public ResponseEntity<List<EstoqueModel>> findAll() {
        return ResponseEntity.ok(estoqueService.getAll());
    }



    // // Autualizar cliente
    // @PutMapping("/cliente/{id}")
    // public ResponseEntity<ClienteModel> updateCliente(@PathVariable UUID id, @RequestBody UpdateClienteInput data) {
    //     return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, data));

    // }


    

}
