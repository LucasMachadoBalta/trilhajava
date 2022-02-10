package com.trilhajava.trilhajava;

import com.trilhajava.trilhajava.dto.CategoryDTO;
import com.trilhajava.trilhajava.entity.CategoryEntity;
import com.trilhajava.trilhajava.exceptions.EmptyListException;
import com.trilhajava.trilhajava.exceptions.ParametersNotFoundException;
import com.trilhajava.trilhajava.services.CategoryServiceImpl;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TrilhajavaApplicationTests {

    @Autowired
    CategoryServiceImpl service;

    CategoryDTO categorydto;
    CategoryEntity category;

    @Test
    public void shouldReturnCategoryError404Test() throws Exception {
        categorydto = new CategoryDTO("name", "description");
        category = service.save(categorydto);
        try {
            List<CategoryEntity> categoryTeste = service.filter(null, null);
        } catch (ParametersNotFoundException e) {
            Assert.isInstanceOf(ParametersNotFoundException.class, e);
            Assertions.assertEquals(e.getMessage(),
                    "Parâmetros com valores errados"
            );
        }
    }

    @Test
    public void shouldReturnCategoryError204Test() throws Exception {
        categorydto = new CategoryDTO("name", "description");
        category = service.save(categorydto);
        try {
            List<CategoryEntity> categoryTeste = service.filter("nameWrong", "descriptionWrong");
        } catch (EmptyListException e) {
            Assert.isInstanceOf(EmptyListException.class, e);
            Assertions.assertEquals(e.getMessage(),
                    "Não existe os dados pelo parâmetro passado"
            );
        }

        //verificar resultado
//		Assert.assertNull(null);
    }

    @Test
    @Transactional
    public void shouldReturnCategory200Test() throws Exception {
        categorydto = new CategoryDTO("name", "description");
        category = service.save(categorydto);
        List<CategoryEntity> categoryTeste = service.filter("name", "description");

        Assert.notEmpty(categoryTeste);
        Assertions.assertEquals(category, categoryTeste.get(0));
    }

}
