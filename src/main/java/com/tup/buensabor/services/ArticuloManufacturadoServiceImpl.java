package com.tup.buensabor.services;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }

    @Override
    public List<ArticuloManufacturado> findProductosMasPedidosEnRangoFechas (@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception {
        try {
            List<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepository.findProductosMasPedidosEnRangoFechas(fechaInicio,fechaFin);
            return articuloManufacturado;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ArticuloManufacturado> buscarProductoPorNombre(String nombre) throws Exception {
        try {
            List<ArticuloManufacturado>  articuloManufacturado =   articuloManufacturadoRepository.buscarProductoPorNombre(nombre);
            return articuloManufacturado;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
