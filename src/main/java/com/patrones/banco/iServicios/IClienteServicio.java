package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.dto.ClienteDTO;

public interface IClienteServicio {
    public List<ClienteDTO> getList();
    public ClienteDTO getById(long id);
    public ClienteDTO getByDni(long dni);
    public ClienteDTO save(ClienteDTO c);
    public ClienteDTO update(ClienteDTO c);
    public void delete(long id);
}
