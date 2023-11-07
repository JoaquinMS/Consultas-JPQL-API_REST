package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.repositories.ArticuloInsumoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {

    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    public List<ArticuloInsumo> findArticulosInsumoBajoStockMinimo() {
        return articuloInsumoRepository.findArticulosInsumoBajoStockMinimo();
    }

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }
}