package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.dto.CuentaDTO;

public interface ICuentaServicio {
    public List<CuentaDTO> getList();
    public CuentaDTO getById(long id);
    public CuentaDTO save(CuentaDTO c);
    public CuentaDTO update(CuentaDTO c);
    public void delete(long id);
}
