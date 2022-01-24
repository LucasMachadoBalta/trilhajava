package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.EntryDTO;
import com.trilhajava.trilhajava.entity.EntryEntity;

import java.util.List;

public interface EntryService {

    EntryEntity findById(Long id);

    List<EntryEntity> findAll();

    EntryDTO save(EntryDTO dto);

    EntryEntity put(EntryDTO dto);

    void delete(Long id);

    void updateById(Long id, EntryDTO dto); // ñ seria melhor return obj p/ mostrar alterações?
}