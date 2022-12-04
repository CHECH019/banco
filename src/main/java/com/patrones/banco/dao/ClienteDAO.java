package com.patrones.banco.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.patrones.banco.dto.ClienteDTO;

@Repository
public interface ClienteDAO extends JpaRepository<ClienteDTO,Long>{
    @Query("SELECT c FROM ClienteDTO c WHERE c.nombre = ?1 AND c.apellido = ?2")
    List<ClienteDTO> findByNameAndLastName(String name, String lastName);

}
