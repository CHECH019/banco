package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.patrones.banco.dao.ClienteDAO;
import com.patrones.banco.dto.ClienteDTO;
import com.patrones.banco.iServicios.IClienteServicio;

@Service
public class ClienteServicio implements IClienteServicio{

    @Autowired
    private ClienteDAO repositorio;

    @Override
    public List<ClienteDTO> getAll() {
        return repositorio.findAll();
    }

    @Override
    public ClienteDTO getById(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public ClienteDTO save(ClienteDTO c) {
        return repositorio.save(c);
    }

    @Override
    public ClienteDTO update(ClienteDTO c) {
        return repositorio.save(c);
    }

    @Override
    public void delete(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<ClienteDTO> getByNameAndLastName(String name, String lastName) {
        return repositorio.findByNameAndLastName(name,lastName);
    }

    @Override
    public Page<ClienteDTO> getAllPageable(Pageable pageable) {
        return repositorio.findAll(pageable);
    }
    
    
    
}
