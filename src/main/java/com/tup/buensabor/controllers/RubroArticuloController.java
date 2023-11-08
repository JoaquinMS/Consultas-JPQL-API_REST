package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.RubroArticulo;
import com.tup.buensabor.services.RubroArticuloServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/rubrosarticulo")

public class RubroArticuloController extends BaseControllerImpl<RubroArticulo, RubroArticuloServiceImpl>{


}


