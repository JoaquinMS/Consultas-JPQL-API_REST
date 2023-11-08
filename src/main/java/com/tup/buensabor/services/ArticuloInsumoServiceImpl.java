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


    //Historia 25
    public List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo() {
        return articuloInsumoRepository.findArticulosInsumoBajoStockMinimo();
    }


    //Historia 25
    @Override
    public List<ArticuloInsumo> findArticulosInsumoCercaStockMinimo() {
        return articuloInsumoRepository.findArticulosInsumoCercaStockMinimo();
    }

    //Historia 22
    @Override
    public List<ArticuloInsumo> findAllArticuloInsumoWithRubro() {
        return articuloInsumoRepository.findAllArticuloInsumoWithRubro();
    }

    //Constructor
    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }
}