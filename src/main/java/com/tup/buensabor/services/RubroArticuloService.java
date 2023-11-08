package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticulo;
import com.tup.buensabor.entities.RubroArticuloManufacturado;

import java.util.List;


public interface RubroArticuloService extends BaseService<RubroArticulo, Long>{
    //Historia 20
    List<RubroArticulo> obtenerRubrosConEstado() throws Exception;
}

