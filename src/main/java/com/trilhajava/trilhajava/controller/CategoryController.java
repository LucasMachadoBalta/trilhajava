package com.trilhajava.trilhajava.controller;

import com.trilhajava.trilhajava.models.CategoryEntity;
import com.trilhajava.trilhajava.services.CategoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Api(value="API REST Controle Financeiro")
@CrossOrigin(origins="*")
public class CategoryController {

    @Autowired
    CategoryServiceImpl service;

    @GetMapping("/")
    @ApiOperation(value="Retorna uma lista de categorias")
    public List<Object> listCategory() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Retorna uma única categoria")
    public Object findById(@PathVariable("id") Long id) {

        //return id;
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Salva uma categoria")
    public CategoryEntity saveCategory(@RequestBody CategoryEntity category) {

        //return category;
        return ResponseEntity.ok().body(service.save(category)).getBody();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta uma categoria")
    public void deleteCategory(@PathVariable("id") Long id) {

        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza uma categoria")
    public Object putCategory(@RequestBody CategoryEntity dto) {
        return service.save(dto);
    }

}