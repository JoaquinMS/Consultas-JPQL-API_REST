package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.DetallePedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends BaseRepository<DetallePedido, Long>{
    //Historia 17
    @Query("SELECT DISTINCT dp FROM DetallePedido dp LEFT JOIN FETCH dp.articuloManufacturado am WHERE dp.pedido.estado = 'PREPARACION'"
           )
    List<DetallePedido> obtenerDetallesPedidosConRecetas();
}
