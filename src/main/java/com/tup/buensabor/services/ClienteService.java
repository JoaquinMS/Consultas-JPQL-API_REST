package com.tup.buensabor.services;

import com.tup.buensabor.entities.Cliente;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public interface ClienteService extends BaseService<Cliente, Long>{

        List<Cliente> findClientesConMasPedidosEnRangoFechas ( @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception;

        Cliente findClientePorCorreoYContraseña (String email, String password) throws Exception;

}

