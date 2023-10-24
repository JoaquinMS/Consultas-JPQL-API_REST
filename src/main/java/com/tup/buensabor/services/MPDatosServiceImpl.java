package com.tup.buensabor.services;
import com.tup.buensabor.entities.MPDatos;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.MPDatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MPDatosServiceImpl extends BaseServiceImpl<MPDatos, Long> implements MPDatosService{
    @Autowired
    private MPDatosRepository mpDatosRepository;


    public MPDatosServiceImpl(BaseRepository<MPDatos, Long> baseRepository, MPDatosRepository mpDatosRepository) {
        super(baseRepository);
        this.mpDatosRepository = mpDatosRepository;
    }
}
