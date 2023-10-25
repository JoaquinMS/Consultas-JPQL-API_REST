package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositories.PedidoRepository;
import com.tup.buensabor.services.ClienteServiceImpl;
import com.tup.buensabor.services.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/pedidos")
public class PedidoController extends BaseControllerImpl<Cliente, ClienteServiceImpl> {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/productos-mas-pedidos")
    public List<ArticuloInsumo> findProductosMasPedidosEnRangoFechas(
            @RequestParam("fechaInicio") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,
            @RequestParam("fechaFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin
    ) {
        return pedidoRepository.findProductosMasPedidosEnRangoFechas(fechaInicio,fechaFin);
    }
}