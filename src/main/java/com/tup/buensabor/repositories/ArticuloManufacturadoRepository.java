package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado, Long>{


   @Query("SELECT dp.articuloManufacturado, SUM(dp.cantidad) as totalPedidos " +
            "FROM DetallePedido dp " +
            "WHERE dp.pedido.fechaPedido BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY dp.articuloManufacturado " +
            "ORDER BY totalPedidos DESC")
    List<ArticuloManufacturado> findProductosMasPedidosEnRangoFechas(
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin
    );

   //Historia 9
   @Query("SELECT a FROM ArticuloManufacturado a " +
           "WHERE :nombre IS NULL OR a.denominacion LIKE %:nombre% " +
           "GROUP BY a.rubroArticuloManufacturado, a.id")
   List<ArticuloManufacturado> buscarProductoPorNombre(
           @Param("nombre") String nombre
   );





}
