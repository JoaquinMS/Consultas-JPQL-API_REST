package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.MPDatos;
import com.tup.buensabor.services.MPDatosServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/MPdatos")
public class MPDatosController extends BaseControllerImpl<MPDatos, MPDatosServiceImpl>{
}
