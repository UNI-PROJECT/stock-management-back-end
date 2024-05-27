package modules.funcionario.controllers;

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

import modules.funcionario.dtos.CreateFuncionarioInput;
import modules.funcionario.services.FuncinarioCrudService;
import modules.models.funcionarioModel;



@RestController
public class funcionarioCrudController {
    @Autowired
    private FuncinarioCrudService funcionarioService;

    @GetMapping("funcionario/listar")
    public ResponseEntity<List<funcionarioModel>> findAll() {
        return ResponseEntity.ok(funcionarioService.getAll());
    }

    @GetMapping("/funcionario/{id}")
    public ResponseEntity<funcionarioModel> getfuncionarioById(@PathVariable UUID id) {
        Optional<funcionarioModel> funcionario = funcionarioService.findById(id);
        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("funcionario/cadastrar")
    public ResponseEntity<funcionarioModel> create(@RequestBody CreateFuncionarioInput data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.create(data));

    }

    // // Autualizar cliente
    // @PutMapping("/cliente/{id}")
    // public ResponseEntity<ClienteModel> updateCliente(@PathVariable UUID id, @RequestBody UpdateClienteInput data) {
    //     return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, data));

    // }

    //Deletar cliente
    @DeleteMapping("/funcionario/{id}")
    public void deleteCliente(@PathVariable UUID id) {
        funcionarioService.delete(id);
    }
    

}