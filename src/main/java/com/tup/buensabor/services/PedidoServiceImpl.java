package com.tup.buensabor.services;

import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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


    //historia 17
    @Override
    public List<Pedido> getAllPedidosPreparacion() throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.getAllPedidosPreparacion();
            return pedidos;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



    //historia 14

    @Override
    public List<Pedido> obtenerTodosLosPedidos() throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.obtenerTodosLosPedidos();
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //historia 14
    @Override
    public List<Pedido> obtenerPedidosPorEstado(EstadoPedido estado) throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.obtenerPedidosPorEstado(estado);
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    //historia 14
    @Override
    public Pedido buscarPedidoPorId(Long pedidoId) throws Exception {
        try {
            Pedido pedido = pedidoRepository.buscarPedidoPorId(pedidoId);
            return pedido;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

//historia 16

    @Override
    public List<Pedido> obtenerPedidosEnDelivery() throws Exception {
        try {
            List<Pedido> pedidos = pedidoRepository.obtenerPedidosEnDelivery(); // Llama a la consulta en el repositorio
            return pedidos;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //historia 16
    @Override
    public DetallePedido obtenerDetallePedido(Long pedidoId) throws Exception {
        try {
            // Llama a una consulta personalizada en el repositorio para obtener el detalle del pedido según su ID
            DetallePedido pedidoDetalle = pedidoRepository.obtenerDetallePedido(pedidoId);

            return pedidoDetalle;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    public void asignarEstadoEntregado(Long pedidoId) throws Exception {
        try {
            pedidoRepository.asignarEstadoEntregado(pedidoId);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public DTOInformeMonetario getInformeMonetarioByDateRange(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception {
        List<Object[]> results = pedidoRepository.getInformeMonetarioByDateRange(fechaInicio, fechaFin);

        // A continuación, crea el objeto DTOInformeMonetario manualmente
        if (results != null && !results.isEmpty()) {
            Object[] resultado = results.get(0);

            DTOInformeMonetario informeMonetario = new DTOInformeMonetario();
            informeMonetario.setIngresos((BigDecimal) resultado[0]);
            informeMonetario.setCostos((BigDecimal) resultado[1]);
            informeMonetario.setGanancias((BigDecimal) resultado[2]);

            return informeMonetario;
        } else {
            // Lidiar con el caso en el que no se encontraron resultados
            return null;
        }
    }

}
