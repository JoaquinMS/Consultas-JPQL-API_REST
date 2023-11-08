package com.tup.buensabor.repositories;

import com.tup.buensabor.entities.Cliente;
import com.tup.buensabor.entities.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long>{
}
