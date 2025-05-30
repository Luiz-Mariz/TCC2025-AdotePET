package com.adotepet.service.animal;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adotepet.model.animal.TipoAnimalModel;
import com.adotepet.repository.animal.TipoAnimalRepository;

@Service
public class TipoAnimalService {
    
    @Autowired
    private TipoAnimalRepository repository;

    public List<TipoAnimalModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<TipoAnimalModel> buscarPorID(Long id){
        return repository.findById(id);
    }

    public TipoAnimalModel salvar(TipoAnimalModel tipoAnimalModel){
        return repository.save(tipoAnimalModel);
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }

    
}
