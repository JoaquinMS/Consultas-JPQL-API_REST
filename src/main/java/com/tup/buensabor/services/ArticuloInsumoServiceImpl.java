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

    public ArticuloInsumoServiceImpl(BaseRepository<ArticuloInsumo, Long> baseRepository, ArticuloInsumoRepository articuloInsumoRepository) {
        super(baseRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    @Override
    public List<ArticuloInsumo> findProductosMasPedidosEnRangoFechas (@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception {
        try {
            List<ArticuloInsumo> articuloInsumos = articuloInsumoRepository.findProductosMasPedidosEnRangoFechas(fechaInicio,fechaFin);
            return articuloInsumos;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloInsumo> buscarPorNombreYRubro(String nombre, String rubroNombre) throws Exception {
        try {
            List<ArticuloInsumo>  articuloInsumos =   articuloInsumoRepository.buscarPorNombreYRubro(nombre, rubroNombre);
            return articuloInsumos;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }


}