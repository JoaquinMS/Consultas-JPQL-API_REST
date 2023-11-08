package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.repositories.ArticuloInsumoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;


    //Consulta H25
    public List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo() {
        return articuloInsumoRepository.findArticulosInsumoBajoStockMinimo();
    }


    //Consulta H25
    @Override
    public List<ArticuloInsumo> findArticulosInsumoCercaStockMinimo() {
        return articuloInsumoRepository.findArticulosInsumoCercaStockMinimo();
    }


    //Constructor
    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }
}