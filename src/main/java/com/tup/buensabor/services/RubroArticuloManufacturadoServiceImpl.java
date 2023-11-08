package com.tup.buensabor.services;

import com.tup.buensabor.entities.RubroArticuloManufacturado;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.RubroArticuloManufacturadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RubroArticuloManufacturadoServiceImpl extends BaseServiceImpl<RubroArticuloManufacturado, Long> implements RubroArticuloManufacturadoService{

    @Autowired
    private RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository;


    //Historia 21
    public List<RubroArticuloManufacturado> obtenerRubrosConEstado () {
        return rubroArticuloManufacturadoRepository.obtenerRubrosConEstado();
    }


    //Constructor
    public RubroArticuloManufacturadoServiceImpl(BaseRepository<RubroArticuloManufacturado, Long> baseRepository, RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository) {
        super(baseRepository);
        this.rubroArticuloManufacturadoRepository = rubroArticuloManufacturadoRepository;
    }


}