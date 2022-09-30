package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.modelo.Cliente;

public interface IClienteServicio {
    public List<Cliente> getList();
    public Cliente getById(long id);
    public Cliente getByDni(long dni);
    public Cliente save(Cliente c);
    public Cliente update(Cliente c);
    public void delete(long id);
}
