package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.RubroArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RubroArticuloManufacturadoRepository extends BaseRepository<RubroArticuloManufacturado, Long>{


    //Historia 21
    @Query("SELECT r FROM RubroArticuloManufacturado r")
    List<RubroArticuloManufacturado> obtenerRubrosConEstado();

}
