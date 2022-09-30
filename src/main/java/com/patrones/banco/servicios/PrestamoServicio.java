package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.iServicios.IPrestamoServicio;
import com.patrones.banco.modelo.Prestamo;
import com.patrones.banco.repositorios.PrestamoRepositorio;

@Service
public class PrestamoServicio implements IPrestamoServicio{

    @Autowired
    private PrestamoRepositorio repositorio;

    @Override
    public List<Prestamo> getList() {
        return (List<Prestamo>) repositorio.findAll();
    }

    @Override
    public Prestamo getById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Prestamo save(Prestamo c) {
        return repositorio.save(c);
    }

    @Override
    public Prestamo update(Prestamo c) {
        return repositorio.save(c);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
