package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.DetallePedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    @Query("SELECT a FROM ArticuloManufacturado a " +
            "WHERE (:nombre IS NULL OR a.denominacion LIKE %:nombre%) " +
            "AND (:rubroNombre IS NULL OR a.rubroArticuloManufacturado.denominacion = :rubroNombre)")
    List<ArticuloManufacturado> buscarPorNombreYRubro(
            @Param("nombre") String nombre,
            @Param("rubroNombre") String rubroNombre
    );

   //Historia 9
   @Query("SELECT a FROM ArticuloManufacturado a " +
           "WHERE :nombre IS NULL OR a.denominacion LIKE %:nombre% " +
           "GROUP BY a.rubroArticuloManufacturado, a.id")
   List<ArticuloManufacturado> buscarProductoPorNombre(
           @Param("nombre") String nombre
   );

   //Historia 11
    @Query("SELECT dp.articuloManufacturado.denominacion AS nombreArticulo, dp.articuloManufacturado.precioVenta AS precio, dp.subtotal AS subtotal, dp.cantidad AS cantidad\n" +
            "            FROM DetallePedido dp")
    List<Object[]> consultarDenominacionPrecioSubtotalCantidad(

    ) ;
}



