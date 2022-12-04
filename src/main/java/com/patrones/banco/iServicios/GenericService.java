package com.patrones.banco.iServicios;

import java.util.List;

public interface GenericService<T,ID> {
    public List<T> getAll();
    public T getById(ID id);
    public T save(T entity);
    public T update (T entity);
    public void delete(ID id);
}
