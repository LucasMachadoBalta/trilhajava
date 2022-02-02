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
import java.util.OptionalDouble;

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
        Optional<EntryEntity> opt = entryRepository.findById(id);
        return opt.orElseThrow(() -> new EntryNotFoundException(
                "ID: " + id + " não encontrado. " + "Tipo: " + EntryNotFoundException.class.getName()));
    }

    @Override
    public List<EntryEntity> findAll() {
        return new ArrayList<>(entryRepository.findAll());
    }

    @Override
    public EntryDTO save(EntryDTO dto) {
        return mapToDTO(entryRepository.save(mapToEntity((EntryDTO) dto)));

        /*
        Optional<EntryEntity> opt = entryRepository.findById(dto.getId());
        try {
            if (opt.isPresent()) {
                throw new EntryNotFoundException("id já existente");
            } else {
                return mapToDTO(entryRepository.save(mapToEntity((EntryDTO) dto)));
            }
        } catch (EntryNotFoundException e) {
            e.printStackTrace();

         */
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
    }


    @Override
    public EntryEntity put(EntryDTO dto) {
        return entryRepository.save(mapToEntity((EntryDTO) dto));
    }

    @Override
    public EntryEntity updateById(EntryDTO dto) {
        EntryEntity entryUpdated = entryRepository.findById(dto.getId())
                .orElseThrow(() -> new EntryNotFoundException("Entry não encontrada"));
        entryUpdated.setName(dto.getName());
        entryUpdated.setDescription(dto.getDescription());
        return entryRepository.save(entryUpdated);
    }

    @Override
    public OptionalDouble getAverage() {
        List<EntryEntity> list = new ArrayList<>(entryRepository.findAll());
        OptionalDouble average = list.stream().mapToInt(e -> e.getAmount()).average();
        return average;
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
