package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{


    //Consulta H25
    List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo();


    //Consulta H25
    List<ArticuloInsumo> findArticulosInsumoCercaStockMinimo();



}