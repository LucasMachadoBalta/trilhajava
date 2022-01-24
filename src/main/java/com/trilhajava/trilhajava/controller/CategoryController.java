package com.trilhajava.trilhajava.controller;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import com.trilhajava.trilhajava.entity.CategoryEntity;
import com.trilhajava.trilhajava.services.CategoryService;
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
    CategoryService service;

    @GetMapping("/all")
    @ApiOperation(value="Retorna uma lista de categorias")
    public List<CategoryEntity> listCategory() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value="Retorna uma única categoria")
    public CategoryEntity findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value="Salva uma categoria")
    public CategoryEntity saveCategory(@RequestBody CategoryDTO dto) {
        return ResponseEntity.ok().body(service.save(dto)).getBody();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value="Deleta uma categoria")
    public void deleteCategory(@PathVariable("id") Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value="Atualiza uma categoria")
    public void updateById(@RequestBody CategoryDTO dto) {
        ResponseEntity.ok().body(service.save(dto));
    }

}
