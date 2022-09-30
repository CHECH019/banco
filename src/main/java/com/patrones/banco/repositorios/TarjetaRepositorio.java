package com.patrones.banco.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.patrones.banco.modelo.TarjetaDebito;

@Repository
public interface TarjetaRepositorio extends CrudRepository<TarjetaDebito,Long>{
    
}
