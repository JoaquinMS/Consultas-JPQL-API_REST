package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.enums.EstadoPedido;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PedidoRepository extends BaseRepository<Pedido, Long>{


    //Historia 27
    @Query("SELECT p FROM Pedido p WHERE p.cliente.id = :clienteId AND p.fechaPedido BETWEEN :fechaInicio AND :fechaFin")
    List<Pedido> findPedidosByClienteAndFecha(
            @Param("clienteId") Long clienteId,
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin);


    //Historia 17
    @Query(
            "SELECT p FROM Pedido p WHERE p.estado = 'PREPARACION'"
    )
    List<Pedido> getAllPedidosPreparacion();


    //Historia 14
    @Query("SELECT p FROM Pedido p")
    List<Pedido> obtenerPedidosConEstado();


    //Historia 14
    @Query("SELECT p FROM Pedido p")
    List<Pedido> obtenerTodosLosPedidos();


    //Historia 14
    @Query("SELECT p FROM Pedido p WHERE p.estado = :estado")
    List<Pedido> obtenerPedidosPorEstado(@Param("estado") EstadoPedido estado);


    //Historia 14
    @Query("SELECT p FROM Pedido p WHERE p.id = :pedidoId")
    Pedido buscarPedidoPorId(@Param("pedidoId") Long pedidoId);


    //Historia 16
    @Query("SELECT p FROM Pedido p WHERE p.estado = 'EN_CAMINO'")
    List<Pedido> obtenerPedidosEnDelivery();


    //Historia 16
    @Query("SELECT dp, dp.pedido.cliente.nombre, dp.pedido.cliente.apellido, dp.pedido.cliente.telefono, dp.pedido.domicilioEntrega.calle FROM DetallePedido dp WHERE dp.pedido.id = :pedidoId")
    DetallePedido obtenerDetallePedido(@Param("pedidoId") Long pedidoId);
}

