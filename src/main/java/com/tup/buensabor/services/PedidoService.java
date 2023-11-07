package com.tup.buensabor.services;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoPedido;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long>{

    List<Pedido> findPedidosByClienteAndFecha(Long clienteId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;

    //----------Consultas H17----------//
    List<Pedido> getAllPedidosPreparacion() throws Exception;

    //----------Consultas H14----------//
    public List<Pedido> obtenerTodosLosPedidos() throws Exception;

    //--------------------------------//
    List<Pedido> obtenerPedidosPorEstado(EstadoPedido estado) throws Exception;


}

