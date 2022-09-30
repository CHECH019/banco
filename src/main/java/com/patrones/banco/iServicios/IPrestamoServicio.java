package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.modelo.Prestamo;

public interface IPrestamoServicio {
    public List<Prestamo> getList();
    public Prestamo getById(long id);
    public Prestamo save(Prestamo p);
    public Prestamo update(Prestamo p);
    public void delete(long id);
}