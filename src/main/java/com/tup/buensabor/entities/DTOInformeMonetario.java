package com.tup.buensabor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "informe")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DTOInformeMonetario extends Base {

    private BigDecimal ingresos;
    private BigDecimal costos;
    private BigDecimal ganancias;

}
