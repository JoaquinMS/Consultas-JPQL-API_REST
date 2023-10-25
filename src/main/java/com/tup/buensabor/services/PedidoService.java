package com.tup.buensabor.services;

import com.tup.buensabor.entities.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    List<ArticuloInsumo> findProductosMasPedidosEnRangoFechas (@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;

}

