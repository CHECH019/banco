package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.iServicios.ICuentaServicio;
import com.patrones.banco.modelo.CuentaAhorros;
import com.patrones.banco.repositorios.CuentaRepositorio;

@Service
public class CuentaServicio implements ICuentaServicio{

    @Autowired
    private CuentaRepositorio repositorio;

    @Override
    public List<CuentaAhorros> getList() {
        return (List<CuentaAhorros>) repositorio.findAll();
    }

    @Override
    public CuentaAhorros getById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public CuentaAhorros save(CuentaAhorros c) {
        return repositorio.save(c);
    }

    @Override
    public CuentaAhorros update(CuentaAhorros c) {
        return repositorio.save(c);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
