package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo,Long>{

    List<ArticuloInsumo> buscarPorNombreYRubro (String nombre, String rubroNombre) throws Exception;

}