package com.trilhajava.trilhajava.controller;

import com.trilhajava.trilhajava.dto.EntryDTO;
import com.trilhajava.trilhajava.entity.EntryEntity;
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

    @GetMapping("/all")
    public List<EntryEntity> listEntry() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public EntryDTO saveEntry(@RequestBody EntryDTO dto) {
        return ResponseEntity.ok().body(service.save(dto)).getBody();
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable("id") Long id) {
        service.delete(id);
    }


    @PutMapping("/{id}")
    public void updateById(@RequestBody EntryDTO dto) {
        //return service.save(dto);
        ResponseEntity.ok().body(service.updateById(dto));
    }


}
