package com.adotepet.service.ong;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adotepet.model.ong.OngModel;
import com.adotepet.repository.ong.OngRepository;

@Service
public class OngService {

    @Autowired
    private OngRepository repository;

    public List<OngModel> listarTodos(){
        return repository.findAll();
    }

    
   
}
