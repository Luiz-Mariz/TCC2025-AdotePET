package com.adotepet.repository.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adotepet.model.animal.TipoAnimalModel;

@Repository
public interface TipoAnimalRepository extends JpaRepository<TipoAnimalModel,Long>{
}
