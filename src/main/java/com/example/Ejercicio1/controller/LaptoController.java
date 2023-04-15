package com.example.Ejercicio1.controller;


import com.example.Ejercicio1.models.Lapto;
import com.example.Ejercicio1.repository.LaptoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptoController {

    //atributos
    private LaptoRepository repository;


    //constructores


    public LaptoController(LaptoRepository repository) {
        this.repository = repository;
    }


    //obtener todas las laptos

    @GetMapping("/api/laptos")
    public List<Lapto> findAll(){
        return repository.findAll();
    }

    @GetMapping("/api/laptos/{id}")
    public ResponseEntity<Lapto> findOneById(@PathVariable Long id){
        Optional<Lapto> optLapto = repository.findById(id);

        if(optLapto.isPresent()){
            return ResponseEntity.ok(optLapto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/laptos")
    public Lapto create(@RequestBody Lapto lapto){
        return repository.save(lapto);
    }

    @PutMapping("/api/laptos")
    public Lapto update(@RequestBody Lapto lapto){
        return repository.save(lapto);
    }

    @DeleteMapping("/api/laptos/{id}")
    public ResponseEntity<Lapto> delete(@PathVariable Long id){
        Optional<Lapto> optLapto = repository.findById(id);
        if(optLapto.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok(optLapto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/laptos")
    public void deleteAll(@RequestBody Lapto lapto){
        repository.delete(lapto);
    }


}
