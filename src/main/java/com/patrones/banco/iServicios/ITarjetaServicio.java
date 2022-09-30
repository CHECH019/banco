package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.modelo.TarjetaDebito;

public interface ITarjetaServicio {
    public List<TarjetaDebito> getList();
    public TarjetaDebito getById(long id);
    public TarjetaDebito save(TarjetaDebito t);
    public TarjetaDebito update(TarjetaDebito t);
    public void delete(long id);
}
