package com.patrones.banco.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.patrones.banco.dto.PrestamoDTO;

@Repository
public interface PrestamoDAO extends CrudRepository<PrestamoDTO,Long>{
    
}
