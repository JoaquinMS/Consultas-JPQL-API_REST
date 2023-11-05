package com.tup.buensabor.services;

import com.tup.buensabor.entities.DTOInformeMonetario;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.InformeMonetarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class InformeMonetarioServiceImpl extends BaseServiceImpl<DTOInformeMonetario, Long>{

    @Autowired
    private InformeMonetarioRepository informeMonetarioRepository;

    public InformeMonetarioServiceImpl(BaseRepository<DTOInformeMonetario, Long> baseRepository, InformeMonetarioRepository informeMonetarioRepository) {
        super(baseRepository);
        this.informeMonetarioRepository = informeMonetarioRepository;
    }

    public DTOInformeMonetario getInformeMonetarioByDateRange(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception {
        List<Object[]> results = informeMonetarioRepository.getInformeMonetarioByDateRange(fechaInicio, fechaFin);

        // A continuación, crea el objeto DTOInformeMonetario manualmente
        if (results != null && !results.isEmpty()) {
            Object[] resultado = results.get(0);

            DTOInformeMonetario informeMonetario = new DTOInformeMonetario();
            informeMonetario.setIngresos((BigDecimal) resultado[0]);
            informeMonetario.setCostos((BigDecimal) resultado[1]);
            informeMonetario.setGanancias((BigDecimal) resultado[2]);

            return informeMonetario;
        } else {
            // Lidiar con el caso en el que no se encontraron resultados
            return null;
        }
    }
}
