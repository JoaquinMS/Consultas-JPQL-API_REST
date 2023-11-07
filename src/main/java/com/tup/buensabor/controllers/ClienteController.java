package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.services.ClienteServiceImpl;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {

    @GetMapping("/obtenerClientesConMasPedidos")
    public ResponseEntity<?> obtenerClientesConMasPedidosEnRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin
    ) {
        try {
            List<Cliente> clientes = servicio.findClientesConMasPedidosEnRangoFechas(fechaInicio, fechaFin);
            if (clientes.isEmpty()){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No se encontraron clientes.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(clientes);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }

    }

    @GetMapping("/obtenerClientePorCorreoYContraseña")
    public ResponseEntity<?> obtenerClientesConMasPedidosEnRangoFechas(
            @RequestParam String email,
            @RequestParam String password
    ) {
        try {
            Cliente cliente = servicio.findClientePorCorreoYContraseña(email, password);
            if (cliente == null){
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"No existe cliente asociado a ese correo y contraseña.\"}");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body(cliente);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("{\"error\":\"" + e.getMessage() + "\"}");
        }

    }

}