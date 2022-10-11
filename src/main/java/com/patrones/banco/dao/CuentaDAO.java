package com.patrones.banco.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.patrones.banco.dto.CuentaDTO;

@Repository
public interface CuentaDAO extends CrudRepository<CuentaDTO,Long>{
    
}