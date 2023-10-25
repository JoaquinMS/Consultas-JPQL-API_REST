package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long>{
        @Query( "SELECT a FROM ArticuloInsumo a " +
                "WHERE (:nombre IS NULL OR a.denominacion LIKE %:nombre%) " +
                "AND (:rubroNombre IS NULL OR a.rubroArticulo.denominacion = :rubroNombre)")
        List<ArticuloInsumo> buscarPorNombreYRubro(
                @Param("nombre") String nombre,
                @Param("rubroNombre") String rubroNombre
        );
    }

