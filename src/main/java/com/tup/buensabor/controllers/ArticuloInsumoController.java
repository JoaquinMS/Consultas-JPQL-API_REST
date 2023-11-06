package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.repositories.ArticuloInsumoRepository;
import com.tup.buensabor.services.ArticuloInsumoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articulosinsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {

    @GetMapping("/obtenerProductosMasPedidos")
    public ResponseEntity<?> obtenerProductosMasPedidosEnRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin
    ) {
        try {
            List<ArticuloInsumo> articuloInsumos = servicio.findProductosMasPedidosEnRangoFechas(fechaInicio, fechaFin);
            if (articuloInsumos.isEmpty()){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron articulos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(articuloInsumos);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/obtenerProductosPorNombreYRubro")
    public ResponseEntity<?> buscarProductosPorNombreYRubro(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "rubroNombre", required = false) String rubroNombre
    ) {
        try {
            List<ArticuloInsumo> articuloInsumos = servicio.buscarPorNombreYRubro(nombre, rubroNombre);
            if(articuloInsumos.isEmpty()){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron articulos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(articuloInsumos);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
