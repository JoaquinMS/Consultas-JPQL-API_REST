package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloManufacturado;



import java.util.List;

public interface RubroArticuloManufacturadoService extends BaseService<RubroArticuloManufacturado, Long>{


    //Historia 21
    List<RubroArticuloManufacturado> obtenerRubrosConEstado() ;

}
