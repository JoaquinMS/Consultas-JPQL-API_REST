package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long>{
    List<ArticuloManufacturado> findProductosMasPedidosEnRangoFechas (@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;
    List<ArticuloManufacturado> buscarPorNombreYRubro (String nombre, String rubroNombre) throws Exception;
}
