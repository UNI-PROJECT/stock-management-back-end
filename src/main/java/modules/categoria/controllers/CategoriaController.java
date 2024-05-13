package modules.categoria.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import modules.categoria.dtos.CreateCategoriaInput;
import modules.categoria.services.CategoriaCrudService;
import modules.models.CategoriaModel;



//Essa camada se cominica com o SERVICE

@RestController
public class CategoriaController {
    @Autowired
    private CategoriaCrudService categoriaService;

    @GetMapping("categoria/listar")
    public ResponseEntity<List<CategoriaModel>> findAll() {
        return ResponseEntity.ok(categoriaService.getAll());
    }

    // @GetMapping("/categoria/{id}")
    // public ResponseEntity<CategoriaModel> getcategoriaById(@PathVariable UUID id) {
    //     Optional<CategoriaModel> categoriaOptional = categoriaService.findById(id);
    //     if (categoriaOptional.isPresent()) {
    //         return ResponseEntity.ok(categoriaOptional.get());
    //     } else {k
    //         return ResponseEntity.notFound().build();
    //     }
    // }

    @PostMapping("categoria/cadastrar")
    public ResponseEntity<CategoriaModel> create(@RequestBody CreateCategoriaInput data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.create(data));

    }

    // // Autualizar categoria
    // @PutMapping("/categoria/{id}")
    // public ResponseEntity<CategoriaModel> updatecategoria(@PathVariable UUID id, @RequestBody UpdateCategoriaInput data) {
    //     return ResponseEntity.status(HttpStatus.OK).body(categoriaService.update(id, data));

    // }

    // //Deletar categoria
    // @DeleteMapping("/categoria/{id}")
    // public void deletecategoria(@PathVariable UUID id) {
    //     categoriaService.delete(id);
    // }
    

}
