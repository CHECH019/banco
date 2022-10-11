package com.patrones.banco.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patrones.banco.dto.ClienteDTO;

@Repository
public interface ClienteDAO extends CrudRepository<ClienteDTO,Long>{
    @Query(value = "select * from cliente where dni = :dni",nativeQuery = true)
    ClienteDTO findByDni(@Param("dni") long dni);
}
