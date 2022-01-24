package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.models.EntryEntity;
import com.trilhajava.trilhajava.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntryServiceImpl {

    @Autowired
    private EntryRepository entryRepository;

    /*
    @Autowired
    private ModelMapper modelMapper;
     */

    //@Override
    public Object findById(Long id) {
        return entryRepository.findById(id).get();
    }

    //@Override
    public List<Object> findAll() {
        return new ArrayList<>(entryRepository.findAll());
    }

    //@Override
    public Object save(EntryEntity dto) {

        //return entryRepository.save(mapToDTO((EntryDTO) dto));
        return entryRepository.save(dto);
    }

    //@Override
    public void delete(Long id) {
        entryRepository.deleteById(id);
    }

    //@Override
    public Object put(EntryEntity dto) {
        //return entryRepository.save(mapToDTO((EntryDTO) dto));
        return entryRepository.save(dto);
    }

    /*
    private EntryEntity mapToDTO(EntryDTO entryDTO) {
        return modelMapper.map(entryDTO, EntryEntity.class);

    }

     */
}
