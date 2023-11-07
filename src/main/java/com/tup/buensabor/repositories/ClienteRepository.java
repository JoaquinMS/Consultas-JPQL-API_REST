package com.tup.buensabor.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.tup.buensabor.entities.Cliente;


import java.util.Date;
import java.util.List;

@Repository
public interface ClienteRepository extends BaseRepository<Cliente, Long>{
    @Query("SELECT p.cliente FROM Pedido p WHERE p.fechaPedido BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY p.cliente " +
            "ORDER BY COUNT(p) DESC")
    List<Cliente> findClientesConMasPedidosEnRangoFechas(
            @Param("fechaInicio") Date fechaInicio,
            @Param("fechaFin") Date fechaFin
    );

    //Historia 2
    @Query("SELECT c FROM Cliente c " +
            "WHERE c.email = :email " +
            "AND c.usuario.contraseña = :password")
    Cliente findClientePorCorreoYContraseña(
            @Param("email") String email,
            @Param("password") String password);

}

