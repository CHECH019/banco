package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.dto.PrestamoDTO;

public interface IPrestamoServicio {
    public List<PrestamoDTO> getList();
    public PrestamoDTO getById(long id);
    public PrestamoDTO save(PrestamoDTO p);
    public PrestamoDTO update(PrestamoDTO p);
    public void delete(long id);
}