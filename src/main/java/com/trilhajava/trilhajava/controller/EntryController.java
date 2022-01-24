package com.trilhajava.trilhajava.controller;

import com.trilhajava.trilhajava.dto.EntryDTO;
import com.trilhajava.trilhajava.models.EntryEntity;
import com.trilhajava.trilhajava.services.EntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {

    @Autowired
    EntryServiceImpl service;

    // create(save) read(get) updateById deleteById

    @GetMapping("/")
    public List<Object> listEntry() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Object saveCategory(@RequestBody EntryEntity dto) { //EntryDTO

        //return ResponseEntity.ok().body(service.save(dto)).getBody();
        return ResponseEntity.ok().body(service.save(dto)).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        service.delete(id);
    }


    @PutMapping("/{id}")
    public Object putCategory(@RequestBody EntryEntity dto) {
        return service.save(dto);
    }


}
