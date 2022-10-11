package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.dao.TarjetaDAO;
import com.patrones.banco.dto.TarjetaDTO;
import com.patrones.banco.iServicios.ITarjetaServicio;

@Service
public class TarjetaServicio implements ITarjetaServicio{

    @Autowired
    private TarjetaDAO repositorio;

    @Override
    public List<TarjetaDTO> getList() {
        return (List<TarjetaDTO>) repositorio.findAll();
    }

    @Override
    public TarjetaDTO getById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public TarjetaDTO save(TarjetaDTO c) {
        return repositorio.save(c);
    }

    @Override
    public TarjetaDTO update(TarjetaDTO c) {
        return repositorio.save(c);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
