package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.dao.ClienteDAO;
import com.patrones.banco.dto.ClienteDTO;
import com.patrones.banco.iServicios.IClienteServicio;

@Service
public class ClienteServicio implements IClienteServicio{

    @Autowired
    private ClienteDAO repositorio;

    @Override
    public List<ClienteDTO> getList() {
        return (List<ClienteDTO>) repositorio.findAll();
    }

    @Override
    public ClienteDTO getById(long id) {
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
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public ClienteDTO getByDni(long dni) {
        return repositorio.findByDni(dni);
    }
    
}
