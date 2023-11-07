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
@RequestMapping(path = "api/articulosinsumo")
public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {

    @Autowired
    private ArticuloInsumoServiceImpl articuloInsumoServiceImpl;



    //----------Consultas H25----------//
    @GetMapping("/cercastockminimo")
    public List<ArticuloInsumo> getArticulosInsumoCercaStockMinimo() {
        return articuloInsumoServiceImpl.findArticulosInsumoCercaStockMinimo();
    }
    @GetMapping("/bajostockminimo")
    public List<ArticuloInsumo> getArticulosInsumoBajoStockMinimo() {
        return articuloInsumoServiceImpl.findArticulosInsumoBajoStockMinimo();
    }

    //----------Consultas H----------//
}
