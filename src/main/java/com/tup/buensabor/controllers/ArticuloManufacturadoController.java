package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.services.ArticuloManufacturadoServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/articulosmanufacturado")

public class ArticuloManufacturadoController extends BaseControllerImpl<ArticuloManufacturado, ArticuloManufacturadoServiceImpl>{


    //Historia 26
    @GetMapping("/obtenerProductosMasPedidos")
    public ResponseEntity<?> obtenerProductosMasPedidosEnRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin
    ) {
        try {
            List<ArticuloManufacturado> articuloManufacturado = servicio.findProductosMasPedidosEnRangoFechas(fechaInicio, fechaFin);
            if (articuloManufacturado.isEmpty()){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron articulos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturado);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    //Historia 11
    @GetMapping("/consultarSubtotalCantidad")
    public ResponseEntity<?> consultarDenominacionPrecioSubtotalCantidad() {
        try {
            List<Object[]> detallePedido = servicio.consultarDenominacionPrecioSubtotalCantidad();
            if (detallePedido.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron articulos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(detallePedido);
            }
        } catch (Exception e) {
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
            List<ArticuloManufacturado> articuloManufacturado = servicio.buscarPorNombreYRubro(nombre, rubroNombre);
            if(articuloManufacturado.isEmpty()){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron articulos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturado);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/obtenerProductosPorNombre")
    public ResponseEntity<?> buscarProductoPorNombre(
            @RequestParam(value = "nombre", required = false) String nombre
    ) {
        try {
            List<ArticuloManufacturado> articuloManufacturado = servicio.buscarProductoPorNombre(nombre);
            if(articuloManufacturado.isEmpty()){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron articulos.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturado);
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
