package com.animais.apianimais.controller;


import com.animais.apianimais.Repository.AnimaisRepository; 
import com.animais.apianimais.Repository.DonoRepository;
import com.animais.apianimais.model.Animais;
import com.animais.apianimais.model.Dono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api")
public class AnimaisController {

    @Autowired
    AnimaisRepository animaisRepository;

    @Autowired
    DonoRepository donoRepository;


    @GetMapping("/animais")
    public List<Animais> listaanimais(){
        return animaisRepository.findAll();
    }
    
    @PostMapping("/animais/{id}")
    public ResponseEntity<?> criarAnimal(@PathVariable Long id, @RequestBody Animais animal){
        Optional<Dono> dono = donoRepository.findById(id);
        if(dono.isPresent()){
            animal.setDono(dono.get());
            return ResponseEntity.ok(animaisRepository.save(animal));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Você inseriu um id de dono inexistente");
    }

    @DeleteMapping("/animais/{id}")
    public ResponseEntity<?> deletarAnimal(@PathVariable Long id){
        Optional<Animais> animal = animaisRepository.findById(id);
        if(animal.isPresent()){
            animaisRepository.deleteById(id);
            return ResponseEntity.ok("Animal deletado com sucesso");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Você inseriu um id de animal inexistente");
    }

}


