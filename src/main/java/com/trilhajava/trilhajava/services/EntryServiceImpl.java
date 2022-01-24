package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.EntryDTO;
import com.trilhajava.trilhajava.entity.EntryEntity;
import com.trilhajava.trilhajava.repositories.EntryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public EntryEntity findById(Long id) {
        return entryRepository.findById(id).get();
    }

    @Override
    public List<EntryEntity> findAll() {
        return new ArrayList<>(entryRepository.findAll());
    }

    @Override
    public EntryDTO save(EntryDTO dto) {

        return mapToDTO(entryRepository.save(mapToEntity((EntryDTO) dto)));
        //return entryRepository.save(dto);
    }

    @Override
    public void delete(Long id) {
        entryRepository.deleteById(id);
    }

    @Override
    public void updateById(Long id, EntryDTO dto) {

    }

    @Override
    public EntryEntity put(EntryDTO dto) {

        return entryRepository.save(mapToEntity((EntryDTO) dto));
        //return entryRepository.save(dto);
    }


    private EntryEntity mapToEntity(EntryDTO entryDTO) {
        return modelMapper.map(entryDTO, EntryEntity.class);

    }

    private EntryDTO mapToDTO(EntryEntity entryEntity) {
        return modelMapper.map(entryEntity, EntryDTO.class);
    }

}
