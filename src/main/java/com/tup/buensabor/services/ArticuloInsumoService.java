package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{
    List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo();

}