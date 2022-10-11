package com.patrones.banco.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.patrones.banco.dto.TarjetaDTO;

@Repository
public interface TarjetaDAO extends CrudRepository<TarjetaDTO,Long>{
    
}
