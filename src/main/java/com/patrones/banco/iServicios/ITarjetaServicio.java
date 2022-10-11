package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.dto.TarjetaDTO;

public interface ITarjetaServicio {
    public List<TarjetaDTO> getList();
    public TarjetaDTO getById(long id);
    public TarjetaDTO save(TarjetaDTO t);
    public TarjetaDTO update(TarjetaDTO t);
    public void delete(long id);
}
