package com.tup.buensabor.services;

import com.tup.buensabor.entities.Base;

import java.io.Serializable;
import java.util.List;

public interface DetalleFacturaService <E extends Base,ID extends Serializable>{

    public List<E> findALL() throws Exception;

    public E findById(ID id) throws Exception;

    public E save(E entity) throws Exception;

    public E update(ID id, E entity) throws Exception;

    public boolean delete(ID id) throws Exception;

}
