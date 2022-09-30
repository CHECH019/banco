package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.iServicios.ITarjetaServicio;
import com.patrones.banco.modelo.TarjetaDebito;
import com.patrones.banco.repositorios.TarjetaRepositorio;

@Service
public class TarjetaServicio implements ITarjetaServicio{

    @Autowired
    private TarjetaRepositorio repositorio;

    @Override
    public List<TarjetaDebito> getList() {
        return (List<TarjetaDebito>) repositorio.findAll();
    }

    @Override
    public TarjetaDebito getById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public TarjetaDebito save(TarjetaDebito c) {
        return repositorio.save(c);
    }

    @Override
    public TarjetaDebito update(TarjetaDebito c) {
        return repositorio.save(c);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
