package com.tup.buensabor.services;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.RubroArticulo;
import com.tup.buensabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroArticuloServiceImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService{
    @Autowired
    private RubroArticuloRepository rubroarticuloRepository;


    public RubroArticuloServiceImpl(BaseRepository<RubroArticulo, Long> baseRepository, RubroArticuloRepository rubroarticuloRepository) {
        super(baseRepository);
        this.rubroarticuloRepository = rubroarticuloRepository;
    }
    
}






