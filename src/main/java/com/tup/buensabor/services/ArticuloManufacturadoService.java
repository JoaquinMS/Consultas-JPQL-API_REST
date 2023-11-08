package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.DetallePedido;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface ArticuloManufacturadoService extends BaseService<ArticuloManufacturado, Long>{

    List<ArticuloManufacturado> findProductosMasPedidosEnRangoFechas (@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;
    List<ArticuloManufacturado> buscarPorNombreYRubro (String nombre, String rubroNombre) throws Exception;
    List<ArticuloManufacturado> buscarProductoPorNombre (String nombre) throws Exception;
    List<ArticuloManufacturado> mostrarProductosPaginaPrincipal() throws Exception;
    //Historia 11
    List<Object[]> consultarDenominacionPrecioSubtotalCantidad() throws Exception;
}
