package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Pedido;
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

}