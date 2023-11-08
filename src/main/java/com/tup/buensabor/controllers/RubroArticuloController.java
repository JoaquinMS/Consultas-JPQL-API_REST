package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.RubroArticulo;
import com.tup.buensabor.services.RubroArticuloServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/rubrosarticulo")

public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServiceImpl>{
    //Historia 20
    @GetMapping("/obtenerRubrosConEstado")
    public ResponseEntity<?> obtenerRubrosConEstado() {
        try {
            List<RubroArticulo> rubroArticulos = servicio.obtenerRubrosConEstado();
            if (rubroArticulos.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron pedidos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(rubroArticulos);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

}


