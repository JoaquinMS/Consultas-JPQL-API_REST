package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.repositories.ClienteRepository;
import com.tup.buensabor.services.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes-mas-pedidos")
    public List<Cliente> obtenerClientesConMasPedidosEnRangoFechas(
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin
    ) {
        return clienteRepository.findClientesConMasPedidosEnRangoFechas(fechaInicio, fechaFin);
    }
}