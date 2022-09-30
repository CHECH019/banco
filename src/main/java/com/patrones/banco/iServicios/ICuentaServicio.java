package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.modelo.CuentaAhorros;

public interface ICuentaServicio {
    public List<CuentaAhorros> getList();
    public CuentaAhorros getById(long id);
    public CuentaAhorros save(CuentaAhorros c);
    public CuentaAhorros update(CuentaAhorros c);
    public void delete(long id);
}
