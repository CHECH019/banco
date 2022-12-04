package com.patrones.banco.iServicios;

import java.util.List;

import com.patrones.banco.dto.ProductoDTO;

public interface IProductoServicio extends GenericService<ProductoDTO, Integer>{
    List<ProductoDTO> findProductsByClientId(Long id);
    void saveClienteProducto(Long client_id, Integer product_id);
}
