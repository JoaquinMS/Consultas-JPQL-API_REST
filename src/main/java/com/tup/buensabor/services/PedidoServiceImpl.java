package com.tup.buensabor.services;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;

    }

    public List<Pedido> findPedidosByClienteAndFecha(Long clienteId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.findPedidosByClienteAndFecha(clienteId, fechaInicio, fechaFin);
            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }


    //----------Consultas H17----------//
    @Override
    public List<Pedido> getAllPedidosPreparacion() throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.getAllPedidosPreparacion();
            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
