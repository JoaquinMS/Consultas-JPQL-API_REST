package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.DTOInformeMonetario;
import com.tup.buensabor.services.InformeMonetarioServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/informe")
public class InformeMonetarioController extends BaseControllerImpl<DTOInformeMonetario, InformeMonetarioServiceImpl>{

    @GetMapping("/getInformeMonetarioByDateRange")
    public ResponseEntity<?> getInformeMonetarioByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin
    ) {
        try {
            DTOInformeMonetario informe = servicio.getInformeMonetarioByDateRange(fechaInicio, fechaFin);
            return ResponseEntity.status(HttpStatus.OK).body(informe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }

    }

}
