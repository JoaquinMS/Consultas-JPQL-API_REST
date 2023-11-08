package com.tup.buensabor.controllers;

import com.tup.buensabor.entities.Base;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

public interface BaseController <E extends Base, ID extends Serializable>{

    //Consultas CRUD genericas que heredan hacia las demas clases...

    //Trae a todos:
    public ResponseEntity<?> getAll();

    //Trae a uno por id:
    public ResponseEntity<?> getOne(@PathVariable ID id);

    //Crea un nuevo objeto:
    public ResponseEntity<?> save(@RequestBody E entity);

    //Actualiza atributos de un objeto:
    public ResponseEntity<?> update(@PathVariable ID id,@RequestBody E entity);

    //Elimina objetos ya creados anteriormente:
    public ResponseEntity<?> delete(@PathVariable ID id);
}
