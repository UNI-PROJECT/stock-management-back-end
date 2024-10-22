package modules.venda.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modules.models.VendaModel;
import modules.venda.dtos.CreateVendaInput;
import modules.venda.services.VendaCrudService;




@RestController
public class VendaCrudController {
    @Autowired
    private VendaCrudService vendaService;

    @GetMapping("vendas/listar")
    public ResponseEntity<List<VendaModel>> findAll() {
        return ResponseEntity.ok(vendaService.getAll());
    }

    @GetMapping("/vendas/{id}")
    public ResponseEntity<VendaModel> getvendaById(@PathVariable UUID id) {
        Optional<VendaModel> venda = vendaService.findById(id);
        if (venda.isPresent()) {
            return ResponseEntity.ok(venda.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("vendas/cadastrar")
    public ResponseEntity<VendaModel> create(@RequestBody CreateVendaInput data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaService.create(data));

    }

    // // Autualizar cliente
    // @PutMapping("/cliente/{id}")
    // public ResponseEntity<ClienteModel> updateCliente(@PathVariable UUID id, @RequestBody UpdateClienteInput data) {
    //     return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, data));

    // }

    //Deletar cliente
    @DeleteMapping("/vendas/{id}")
    public void deleteCliente(@PathVariable UUID id) {
        vendaService.delete(id);
    }
    

}
