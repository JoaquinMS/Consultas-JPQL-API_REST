package com.tup.buensabor.services;


import com.tup.buensabor.dto.DTOIngresoIngredientes;
import com.tup.buensabor.entities.DetalleArticuloManufacturado;


public interface DetalleArticuloManufacturadoService extends BaseService<DetalleArticuloManufacturado, Long>{

    DTOIngresoIngredientes getIngresoIngredientes() ;

}
