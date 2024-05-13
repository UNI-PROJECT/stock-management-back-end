package modules.cliente.controllers;

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

import models.ClienteModel;
import modules.cliente.dtos.CreateClienteInput;
import modules.cliente.services.ClienteCrudService;




@RestController
public class ClienteCrudController {
    @Autowired
    private ClienteCrudService clienteService;

    @GetMapping("cliente/listar")
    public ResponseEntity<List<ClienteModel>> findAll() {
        return ResponseEntity.ok(clienteService.getAll());
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<ClienteModel> getClienteById(@PathVariable UUID id) {
        Optional<ClienteModel> cliente = clienteService.findById(id);
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("cliente/cadastrar")
    public ResponseEntity<ClienteModel> create(@RequestBody CreateClienteInput data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.create(data));

    }

    // // Autualizar cliente
    // @PutMapping("/cliente/{id}")
    // public ResponseEntity<ClienteModel> updateCliente(@PathVariable UUID id, @RequestBody UpdateClienteInput data) {
    //     return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, data));

    // }

    //Deletar cliente
    @DeleteMapping("/cliente/{id}")
    public void deleteCliente(@PathVariable UUID id) {
        clienteService.delete(id);
    }
    

}
