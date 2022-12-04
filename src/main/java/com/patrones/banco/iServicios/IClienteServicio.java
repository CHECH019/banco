package com.patrones.banco.iServicios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.patrones.banco.dto.ClienteDTO;

public interface IClienteServicio extends GenericService<ClienteDTO, Long>{
    public Page<ClienteDTO> getAllPageable(Pageable pageable);
    public List<ClienteDTO> getByNameAndLastName(String name, String lastName);
}
