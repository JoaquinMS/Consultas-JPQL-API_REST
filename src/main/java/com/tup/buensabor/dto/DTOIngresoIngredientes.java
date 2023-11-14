package com.tup.buensabor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class DTOIngresoIngredientes {

    private BigDecimal costoTotal;
    private String nombreArticuloManufacturado;
}
