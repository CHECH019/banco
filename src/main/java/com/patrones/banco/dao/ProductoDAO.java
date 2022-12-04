package com.patrones.banco.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.patrones.banco.dto.ProductoDTO;

public interface ProductoDAO extends JpaRepository<ProductoDTO,Integer>{
    @Query(value="SELECT p.id, p.nombre, p.tipo_producto_id FROM producto p JOIN cliente_producto cp ON p.id = cp.producto_id JOIN cliente c ON cp.cliente_id = c.id WHERE c.id = ?1", nativeQuery=true)
    List<ProductoDTO> findProductsByClientId(Long id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO cliente_producto VALUES(?1,?2)", nativeQuery = true)
    void saveClientProduct(Long client_id, Integer product_id);
}
