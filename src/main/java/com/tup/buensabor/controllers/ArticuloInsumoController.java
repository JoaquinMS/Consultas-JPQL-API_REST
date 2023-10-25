package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.repositories.ArticuloInsumoRepository;
import com.tup.buensabor.services.ArticuloInsumoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/articulosinsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {


    @Autowired
    private ArticuloInsumoRepository articuloInsumoRepository;

    @GetMapping("/buscar-productos")
    public List<ArticuloInsumo> buscarProductosPorNombreYRubro(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "rubroNombre", required = false) String rubroNombre
    ) {
        return articuloInsumoRepository.buscarPorNombreYRubro(nombre, rubroNombre);
    }
}
