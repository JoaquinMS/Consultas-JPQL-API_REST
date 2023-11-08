package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.services.DetallePedidoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/detallepedido")

public class DetallePedidoController extends BaseControllerImpl<DetallePedido, DetallePedidoServiceImpl>{

    //Historia 17
    @GetMapping("/obtenerDetallesPedidosConRecetas")
    public ResponseEntity<?> obtenerDetallesPedidosConRecetas() {
        try {
            List<DetallePedido> detallesPedidos = servicio.obtenerDetallesPedidosConRecetas();
            if (detallesPedidos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron detalles de pedido.\"}");
            } else {
                List<String> recetas = new ArrayList<>();
                for (DetallePedido detalle : detallesPedidos) {
                    ArticuloManufacturado producto = detalle.getArticuloManufacturado();
                    String receta = producto.getReceta();
                    recetas.add(receta);
                }
                return ResponseEntity.status(HttpStatus.OK).body(recetas);
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
