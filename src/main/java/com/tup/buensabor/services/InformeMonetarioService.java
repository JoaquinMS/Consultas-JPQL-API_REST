package com.tup.buensabor.services;

import com.tup.buensabor.entities.DTOInformeMonetario;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public interface InformeMonetarioService extends BaseService<DTOInformeMonetario,Long>{

    DTOInformeMonetario getInformeMonetarioByDateRange(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;

}
