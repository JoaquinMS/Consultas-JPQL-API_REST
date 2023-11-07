package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo, Long> {

        @Query("SELECT a FROM ArticuloInsumo a WHERE a.stockActual < a.stockMinimo")
        List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo();

}




