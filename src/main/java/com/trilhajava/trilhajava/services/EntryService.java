package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.EntryDTO;
import com.trilhajava.trilhajava.entity.EntryEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public interface EntryService {

    EntryEntity findById(Long id);

    List<EntryEntity> findAll();

    EntryDTO save(EntryDTO dto);

    EntryEntity put(EntryDTO dto);

    void delete(Long id);

    EntryEntity updateById(EntryDTO dto); // ñ seria melhor return obj p/ mostrar alterações?

    OptionalDouble getAverage();
}
