package com.tup.buensabor.services;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoPedido;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface PedidoService extends BaseService<Pedido, Long> {

    List<Pedido> findPedidosByClienteAndFecha(Long clienteId, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;

    //Historia 17
    List<Pedido> getAllPedidosPreparacion() throws Exception;

    //Historia 14
    public List<Pedido> obtenerTodosLosPedidos() throws Exception;

    //Historia 14
    List<Pedido> obtenerPedidosPorEstado(EstadoPedido estado) throws Exception;


    //Historia 14
    Pedido buscarPedidoPorId(Long pedidoId) throws Exception;



    //Historia 16

    List<Pedido> obtenerPedidosEnDelivery() throws Exception;
    //Historia 16
    DetallePedido obtenerDetallePedido(Long pedidoId) throws Exception;

    DTOInformeMonetario getInformeMonetarioByDateRange(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;

}

