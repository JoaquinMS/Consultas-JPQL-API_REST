package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{

    List<ArticuloInsumo> findProductosMasPedidosEnRangoFechas (@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;
    List<ArticuloInsumo> buscarPorNombreYRubro (String nombre, String rubroNombre) throws Exception;

}