package com.tup.buensabor.services;


import com.tup.buensabor.entities.DTOIngresoIngredientes;
import com.tup.buensabor.entities.DetalleArticuloManufacturado;
import com.tup.buensabor.entities.DetalleFactura;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetalleArticuloManufacturadoRepository;
import com.tup.buensabor.repositories.DetalleFacturaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service

public class DetalleArticuloManufacturadoServiceImpl extends BaseServiceImpl<DetalleArticuloManufacturado, Long> implements DetalleArticuloManufacturadoService{

    @Autowired
    private DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;


    public DetalleArticuloManufacturadoServiceImpl(BaseRepository<DetalleArticuloManufacturado, Long> baseRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository) {
        super(baseRepository);
        this.detalleArticuloManufacturadoRepository = detalleArticuloManufacturadoRepository;
    }

    public DTOIngresoIngredientes getIngresoIngredientes()  {


        List<Object[]> results = detalleArticuloManufacturadoRepository.getIngresoIngredientes();


        // A continuación, crea el objeto DTOInformeMonetario manualmente
        if (results != null && !results.isEmpty()) {
            Object[] resultado = results.get(0);


            DTOIngresoIngredientes ingresoIngredientes = new DTOIngresoIngredientes();
            ingresoIngredientes.setCostoTotal((BigDecimal) resultado[0]);
            ingresoIngredientes.setNombreArticuloManufacturado( (String) resultado[1]);




            return ingresoIngredientes;
        } else {
            // Lidiar con el caso en el que no se encontraron resultados
            return null;
        }












    };




}