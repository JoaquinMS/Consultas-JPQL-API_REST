package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.DTOInformeMonetario;
import com.tup.buensabor.entities.DTOIngresoIngredientes;
import com.tup.buensabor.entities.DetalleArticuloManufacturado;
import com.tup.buensabor.services.DetalleArticuloManufacturadoServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/detallesartculomanufacturado")

public class DetalleArticuloManufacturadoController extends BaseControllerImpl<DetalleArticuloManufacturado, DetalleArticuloManufacturadoServiceImpl>{

    @GetMapping("/getIngresoIngredientes")
    public ResponseEntity<?> getInformeMonetarioByDateRange(

    ) {
        try {
            DTOIngresoIngredientes sumIngredientes = servicio.getIngresoIngredientes();
            return ResponseEntity.status(HttpStatus.OK).body(sumIngredientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }



}
