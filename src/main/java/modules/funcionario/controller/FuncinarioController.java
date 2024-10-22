package modules.funcionario.controller;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.model.Model;
import modules.funcionario.dtos.CreateFuncionarioInput;
import modules.funcionario.services.FuncinarioCrudService;
import modules.models.funcionarioModel;





@RestController
@RequestMapping("/funcionarios") 
public class FuncinarioController {
    @Autowired
    private FuncinarioCrudService funcionarioService;

    @GetMapping("/listar")
    public ResponseEntity<List<funcionarioModel>> findAll(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
     

        System.out.println("Nome Completo: " + authentication.getClass());

        return ResponseEntity.ok(funcionarioService.getAll());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<funcionarioModel> create(@RequestBody CreateFuncionarioInput data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.create(data));
    }



    

}
