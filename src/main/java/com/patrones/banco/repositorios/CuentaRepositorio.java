package com.patrones.banco.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.patrones.banco.modelo.CuentaAhorros;

@Repository
public interface CuentaRepositorio extends CrudRepository<CuentaAhorros,Long>{
    
}