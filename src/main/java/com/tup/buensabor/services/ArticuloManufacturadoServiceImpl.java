package com.tup.buensabor.services;


import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.repositories.ArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {

    @Autowired
    private ArticuloManufacturadoRepository articuloManufacturadoRepository;

    @Override
    public List<ArticuloManufacturado> findProductosMasPedidosEnRangoFechas (@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception{
        try {
            List<ArticuloManufacturado> articuloManufacturados = articuloManufacturadoRepository.findProductosMasPedidosEnRangoFechas(fechaInicio, fechaFin);
            return articuloManufacturados;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(baseRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }



    @Override
    public List<ArticuloManufacturado> buscarPorNombreYRubro(String nombre, String rubroNombre) throws Exception {
        return null;
    }
}
