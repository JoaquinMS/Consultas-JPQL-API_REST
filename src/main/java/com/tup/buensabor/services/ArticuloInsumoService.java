package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{


    //Historia 25
    List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo();


    //Historia 25
    List<ArticuloInsumo> findArticulosInsumoCercaStockMinimo();


    //Historia 22
    List<ArticuloInsumo> findAllArticuloInsumoWithRubro();


}