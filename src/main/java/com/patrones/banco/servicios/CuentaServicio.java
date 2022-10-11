package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.dao.CuentaDAO;
import com.patrones.banco.dto.CuentaDTO;
import com.patrones.banco.iServicios.ICuentaServicio;

@Service
public class CuentaServicio implements ICuentaServicio{

    @Autowired
    private CuentaDAO repositorio;

    @Override
    public List<CuentaDTO> getList() {
        return (List<CuentaDTO>) repositorio.findAll();
    }

    @Override
    public CuentaDTO getById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public CuentaDTO save(CuentaDTO c) {
        return repositorio.save(c);
    }

    @Override
    public CuentaDTO update(CuentaDTO c) {
        return repositorio.save(c);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
