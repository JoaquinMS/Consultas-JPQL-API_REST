package com.tup.buensabor.services;

import com.tup.buensabor.entities.Base;
import com.tup.buensabor.entities.DetallePedido;
import com.tup.buensabor.entities.Pedido;
import com.tup.buensabor.repositories.BaseRepository;
import com.tup.buensabor.repositories.DetallePedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
@Service
    public class DetallePedidoServiceImpl extends BaseServiceImpl<DetallePedido, Long> implements DetallePedidoService{

        @Autowired
        private DetallePedidoRepository detallePedidoRepository;


        public DetallePedidoServiceImpl(BaseRepository<DetallePedido, Long> baseRepository, DetallePedidoRepository detallePedidoRepository) {
            super(baseRepository);
            this.detallePedidoRepository = detallePedidoRepository;
        }

        //Historia 17
        @Override
        public List<DetallePedido> obtenerDetallesPedidosConRecetas() throws Exception {
            try {
                List<DetallePedido> detallePedidos = detallePedidoRepository.obtenerDetallesPedidosConRecetas();
                return detallePedidos;
            } catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }

    }

