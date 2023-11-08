package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.RubroArticuloManufacturado;
import com.tup.buensabor.services.RubroArticuloManufacturadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/rubrosarticulomanufacturados")

public class RubroArticuloManufacturadoController extends BaseControllerImpl<RubroArticuloManufacturado, RubroArticuloManufacturadoServiceImpl>{


        //Historia 21
        @GetMapping("/obtenerRubrosConEstado")
        public ResponseEntity<?> obtenerRubrosConEstado() {
            try {
                List<RubroArticuloManufacturado> rubroArticuloManufacturado = servicio.obtenerRubrosConEstado();
                if (rubroArticuloManufacturado.isEmpty()) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron rubros.\"}");
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body(rubroArticuloManufacturado);
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("{\"error\":\"" + e.getMessage() + "\"}");
            }
        }


    }
