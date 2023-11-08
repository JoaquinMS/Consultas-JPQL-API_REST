package com.tup.buensabor.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DTOInformeMonetario {

    private BigDecimal ingresos;
    private BigDecimal costos;
    private BigDecimal ganancias;

}
