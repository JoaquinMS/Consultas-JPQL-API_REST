package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.ArticuloManufacturado;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.entities.RubroArticulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RubroArticuloRepository extends BaseRepository<RubroArticulo, Long>{


}
