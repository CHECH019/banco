package com.patrones.banco.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patrones.banco.dao.ProductoDAO;
import com.patrones.banco.dto.ProductoDTO;
import com.patrones.banco.iServicios.IProductoServicio;

@Service
public class ProductoServicio implements IProductoServicio{

    @Autowired
    private ProductoDAO dao;

    @Override
    public List<ProductoDTO> getAll() {
        return dao.findAll();
    }

    @Override
    public ProductoDTO getById(Integer id) {
        return dao.findById(id).get();
    }

    @Override
    public ProductoDTO save(ProductoDTO entity) {
        return dao.save(entity);
    }

    @Override
    public ProductoDTO update(ProductoDTO entity) {
        return dao.save(entity);
    }

    @Override
    public void delete(Integer id) {
        dao.deleteById(id);
    }

    @Override
    public List<ProductoDTO> findProductsByClientId(Long id) {
        return dao.findProductsByClientId(id);
    }

    @Override
    public void saveClienteProducto(Long client_id, Integer product_id) {
        dao.saveClientProduct(client_id, product_id);
    }
    
}
