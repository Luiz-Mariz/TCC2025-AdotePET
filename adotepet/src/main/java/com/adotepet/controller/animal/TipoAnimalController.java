package com.adotepet.controller.animal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adotepet.model.animal.TipoAnimalModel;
import com.adotepet.service.animal.TipoAnimalService;

@RestController

@RequestMapping("/api/tipoAnimal")
public class TipoAnimalController {

    @Autowired
    private TipoAnimalService service;

    @GetMapping
    public List<TipoAnimalModel> listarTodos(){ 
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoAnimalModel> buscarPorId(Long id){
        return service.buscarPorID(id)
               .map(ResponseEntity:: ok)
               .orElse(ResponseEntity.notFound().build());
    }
    

    @PostMapping
    public TipoAnimalModel savlar(@RequestBody TipoAnimalModel tipoAnimalModel){
        return service.salvar(tipoAnimalModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoAnimalModel> atualizar(@PathVariable Long id, @RequestBody TipoAnimalModel tipoAnimalModel){

        if (!service.buscarPorID(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        tipoAnimalModel.setId(id);

        return ResponseEntity.ok(service.salvar(tipoAnimalModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TipoAnimalModel> deletar(@PathVariable Long id){

        if (!service.buscarPorID(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
