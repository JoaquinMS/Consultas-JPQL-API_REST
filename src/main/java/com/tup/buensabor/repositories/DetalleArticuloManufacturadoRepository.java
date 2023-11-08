package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.DetalleArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleArticuloManufacturadoRepository extends BaseRepository<DetalleArticuloManufacturado, Long>{


    @Query(
            "SELECT SUM(D.cantidad * A.precioCompra) AS costoTotal, M.denominacion " +
                    "FROM DetalleArticuloManufacturado D " +
                    "JOIN D.articuloInsumo A " +
                    "JOIN D.articuloManufacturado M " +
                    "GROUP BY M.denominacion")
    List<Object[]> getIngresoIngredientes();




}
