package com.adotepet.repository.ong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adotepet.model.ong.OngModel;

@Repository
public interface OngRepository extends JpaRepository<OngModel, Long>{    
}
