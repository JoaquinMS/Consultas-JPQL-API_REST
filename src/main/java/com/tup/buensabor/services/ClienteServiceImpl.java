package com.tup.buensabor.services;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long>{
    @Autowired
   private ClienteRepository clienteRepository;

    public ClienteServiceImpl(BaseRepository<Cliente, Long> baseRepository, ClienteRepository clienteRepository) {
        super(baseRepository);
        this.clienteRepository = clienteRepository;
    }
    public List<Cliente> findClientesConMasPedidosEnRangoFechas (@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio, @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) throws Exception {
        try {
            List<Cliente> clientes = clienteRepository.findClientesConMasPedidosEnRangoFechas(fechaInicio,fechaFin);
            return clientes;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public Cliente findClientePorCorreoYContraseña (String email, String password) throws Exception {
        try {
            Cliente cliente = clienteRepository.findClientePorCorreoYContraseña(email, password);
            return cliente;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

}



