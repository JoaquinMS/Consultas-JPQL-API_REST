package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.DTOInformeMonetario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface InformeMonetarioRepository extends BaseRepository<DTOInformeMonetario, Long>{


    //Historia 28
    @Query("SELECT SUM(p.total) AS ingresos, " +
            "SUM(p.totalCosto) AS costos, " +
            "SUM(p.total - p.totalCosto) AS ganancias " +
            "FROM Pedido p WHERE p.fechaPedido " +
            "BETWEEN :fechaInicio AND :fechaFin")
    List<Object[]> getInformeMonetarioByDateRange(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);


}
