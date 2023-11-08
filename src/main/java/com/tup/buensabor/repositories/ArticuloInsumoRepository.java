package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {


        //Historia 25
        @Query("SELECT a FROM ArticuloInsumo a WHERE a.stockActual < a.stockMinimo")
        List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo();


        //Historia 25
        @Query("SELECT a FROM ArticuloInsumo a WHERE a.stockActual <= (a.stockMinimo + a.stockMinimo * 0.2)")
        List<ArticuloInsumo> findArticulosInsumoCercaStockMinimo();
}




