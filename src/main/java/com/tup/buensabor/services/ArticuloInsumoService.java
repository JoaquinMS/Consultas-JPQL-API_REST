package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{

    //----------Consultas H25----------//
    List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo();
    List<ArticuloInsumo> findArticulosInsumoCercaStockMinimo();

    //----------Consultas H----------//

}