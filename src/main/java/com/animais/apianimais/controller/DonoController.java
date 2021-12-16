package com.animais.apianimais.controller;

import com.animais.apianimais.Repository.DonoRepository; 
import com.animais.apianimais.model.Dono;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
 
@RestController
@RequestMapping("/api")
public class DonoController {

    @Autowired
    DonoRepository donoRepository;

    @GetMapping("/donos")
    public List<Dono> listadeDonos(){
        return donoRepository.findAll();
    }

    @GetMapping("/donos/{id}")
    public ResponseEntity<?> listadeDonos(@PathVariable Long id){

        Optional<Dono> dono = donoRepository.findById(id);
        if(dono.isPresent()) {
            return  ResponseEntity.ok(dono.get());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi encontrado um dono com esse ID");
    }

    @PostMapping("/donos")
    public Dono criarDono(@RequestBody Dono dono){
        return donoRepository.save(dono);
    }

}
