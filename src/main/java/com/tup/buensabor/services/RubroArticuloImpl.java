package com.tup.buensabor.services;

import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.entities.Domicilio;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.RubroArticulo;
import com.tup.buensabor.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RubroArticuloImpl extends BaseServiceImpl<RubroArticulo, Long> implements RubroArticuloService{
    @Autowired
    private RubroArticuloRepository rubroarticuloRepository;


    public RubroArticuloImpl(BaseRepository<RubroArticulo, Long> baseRepository, RubroArticuloRepository rubroarticuloRepository) {
        super(baseRepository);
        this.rubroarticuloRepository = rubroarticuloRepository;
    }
}
