package com.trilhajava.trilhajava.services;

import com.trilhajava.trilhajava.dto.EntryDTO;
import com.trilhajava.trilhajava.entity.EntryEntity;
import com.trilhajava.trilhajava.exceptions.EntryNotFoundException;
import com.trilhajava.trilhajava.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.trilhajava.trilhajava.dto.EntryDTO.mapToEntity;
import static com.trilhajava.trilhajava.entity.EntryEntity.mapToDTO;

@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryRepository entryRepository;


    //@Autowired
    //private ModelMapper modelMapper;


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
        Optional<EntryEntity> opt = entryRepository.findById(id);
        try {
            if (opt.isPresent()) {
                entryRepository.deleteById(id);
            } else {
                throw new EntryNotFoundException("id não encontrado");
            }
        } catch (EntryNotFoundException e) {
            e.printStackTrace();
        }

        //entryRepository.deleteById(id);
    }


    @Override
    public EntryEntity put(EntryDTO dto) {
        return entryRepository.save(mapToEntity((EntryDTO) dto));
        //return entryRepository.save(dto);
    }

    @Override
    public EntryEntity updateById(EntryDTO dto) {
        EntryEntity entryUpdated = entryRepository.findById(dto.getId())
                .orElseThrow(() -> new EntryNotFoundException("Entry não encontrada"));
        entryUpdated.setName(dto.getName());
        entryUpdated.setDescription(dto.getDescription());
        return entryRepository.save(entryUpdated);
    }

    /*
    private EntryEntity mapToEntity(EntryDTO entryDTO) {
        return modelMapper.map(entryDTO, EntryEntity.class);
    }

    private EntryDTO mapToDTO(EntryEntity entryEntity) {
        return modelMapper.map(entryEntity, EntryDTO.class);
    }
     */

}
