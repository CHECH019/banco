package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.dao.PrestamoDAO;
import com.patrones.banco.dto.PrestamoDTO;
import com.patrones.banco.iServicios.IPrestamoServicio;

@Service
public class PrestamoServicio implements IPrestamoServicio{

    @Autowired
    private PrestamoDAO repositorio;

    @Override
    public List<PrestamoDTO> getList() {
        return (List<PrestamoDTO>) repositorio.findAll();
    }

    @Override
    public PrestamoDTO getById(long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public PrestamoDTO save(PrestamoDTO c) {
        return repositorio.save(c);
    }

    @Override
    public PrestamoDTO update(PrestamoDTO c) {
        return repositorio.save(c);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);
    }
    
}
