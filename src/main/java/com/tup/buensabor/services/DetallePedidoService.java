package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.DetallePedido;

import java.util.List;

public interface DetallePedidoService extends BaseService<DetallePedido,Long>{

    //Historia 17
    List<DetallePedido> obtenerDetallesPedidosConRecetas() throws Exception;
}
