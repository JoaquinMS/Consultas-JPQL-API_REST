package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.enums.EstadoPedido;
import com.tup.buensabor.services.PedidoServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl> {

    @GetMapping("/obtenerPedidosPorClienteYFechas")
    public ResponseEntity<?> obtenerPedidosPorClienteYFechas(
            @RequestParam Long clienteId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        try {
            List<Pedido> pedidos = servicio.findPedidosByClienteAndFecha(clienteId, fechaInicio, fechaFin);
            if (pedidos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron pedidos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(pedidos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }


    //----------Consultas H17----------//
    @GetMapping("/getAllPedidosPreparacion")
    public ResponseEntity<?> getAllPedidosPreparacion() {
        try {
            List<Pedido> pedidos = servicio.getAllPedidosPreparacion();
            if (pedidos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron pedidos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(pedidos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    //----------Consultas H14----------//
    @GetMapping("/obtenerTodosLosPedidos")
    public ResponseEntity<?> obtenerTodosLosPedidos() {
        try {
            List<Pedido> pedidos = servicio.obtenerTodosLosPedidos();
            if (pedidos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron pedidos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(pedidos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    //------------------------------//
    @GetMapping("/pedidoPorEstado")
    public ResponseEntity<?> obtenerPedidosPorEstado(@RequestParam("estado") EstadoPedido estado) {
        try {
            List<Pedido> pedidos = servicio.obtenerPedidosPorEstado(estado);
            if (pedidos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron pedidos con el estado " + estado + ".\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(pedidos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    //------------------------------//
    @GetMapping("/buscarPedidoPorId")
    public ResponseEntity<?> buscarPedidoPorId(@RequestParam Long id) {
        try {
            Pedido pedido = servicio.buscarPedidoPorId(id);
            if (pedido == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Pedido no encontrado.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(pedido);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }




}