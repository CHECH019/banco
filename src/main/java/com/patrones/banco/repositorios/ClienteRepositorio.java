package com.patrones.banco.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patrones.banco.modelo.Cliente;

@Repository
public interface ClienteRepositorio extends CrudRepository<Cliente,Long>{
    @Query(value = "select * from cliente where dni = :dni",nativeQuery = true)
    Cliente findByDni(@Param("dni") long dni);
}
