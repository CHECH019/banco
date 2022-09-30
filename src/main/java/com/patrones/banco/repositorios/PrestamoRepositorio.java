package com.patrones.banco.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.patrones.banco.modelo.Prestamo;

@Repository
public interface PrestamoRepositorio extends CrudRepository<Prestamo,Long>{
    
}
