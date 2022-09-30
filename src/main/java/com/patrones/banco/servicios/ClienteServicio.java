package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.iServicios.IClienteServicio;
import com.patrones.banco.modelo.Cliente;
import com.patrones.banco.repositorios.ClienteRepositorio;

@Service
public class ClienteServicio implements IClienteServicio{

    @Autowired
    private ClienteRepositorio repositorio;

    @Override
    public List<Cliente> getList() {
        return (List<Cliente>) repositorio.findAll();
    }

    @Override
    public Cliente getById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Cliente save(Cliente c) {
        return repositorio.save(c);
    }

    @Override
    public Cliente update(Cliente c) {
        return repositorio.save(c);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Cliente getByDni(long dni) {
        return repositorio.findByDni(dni);
    }
    
}
