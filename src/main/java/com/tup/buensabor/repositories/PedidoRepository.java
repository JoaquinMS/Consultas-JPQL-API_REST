package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Pedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long>{
    @Query("SELECT dp.articuloInsumo, SUM(dp.cantidad) as totalPedidos " +
            "FROM DetallePedido dp " +
            "WHERE dp.pedido.fechaPedido BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY dp.articuloInsumo " +
            "ORDER BY totalPedidos DESC")

    List<ArticuloInsumo> findProductosMasPedidosEnRangoFechas(
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin
    );
}

