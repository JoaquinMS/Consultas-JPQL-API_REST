package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.ArticuloInsumo;
import com.tup.buensabor.services.ArticuloInsumoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/articulosinsumo")

public class ArticuloInsumoController extends BaseControllerImpl<ArticuloInsumo, ArticuloInsumoServiceImpl> {

    @Autowired
    private ArticuloInsumoServiceImpl articuloInsumoServiceImpl;


    //Historia 25
    @GetMapping("/cercastockminimo")
    public List<ArticuloInsumo> getArticulosInsumoCercaStockMinimo() {
        return articuloInsumoServiceImpl.findArticulosInsumoCercaStockMinimo();
    }


    //Historia 25
    @GetMapping("/bajostockminimo")
    public List<ArticuloInsumo> getArticulosInsumoBajoStockMinimo() {
        return articuloInsumoServiceImpl.findArticulosInsumoBajoStockMinimo();
    }


    //Historia 22
    @GetMapping("/ingredientesconrubro")
    public List<ArticuloInsumo> findAllArticuloInsumoWithRubro() {
        return articuloInsumoServiceImpl.findAllArticuloInsumoWithRubro();
    }
    //comentario de prueba
    int numero = 15;
    
}
