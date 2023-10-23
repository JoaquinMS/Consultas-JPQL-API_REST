package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Domicilio;
import com.tup.buensabor.services.DomicilioService;
import com.tup.buensabor.services.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{
}
