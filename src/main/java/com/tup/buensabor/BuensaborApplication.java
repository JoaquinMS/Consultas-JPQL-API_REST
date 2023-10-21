package com.tup.buensabor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.tup.buensabor.repositories.*;
import com.tup.buensabor.entities.*;
import com.tup.buensabor.enums.*;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class BuensaborApplication {

	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;

	@Autowired
	ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;

	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;

	@Autowired
	DetallePedidoRepository detallePedidoRepository;

	@Autowired
	DomicilioRepository domicilioRepository;

	@Autowired
	FacturaRepository facturaRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	RubroArticuloRepository rubroArticuloRepository;

	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	MPDatosRepository mpDatosRepository;

	public static void main(String[] args) {
		SpringApplication.run(
				BuensaborApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ArticuloInsumoRepository articuloInsumoRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository, ClienteRepository clienteRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository, DetalleFacturaRepository detalleFacturaRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, RubroArticuloRepository rubroArticuloRepository, UnidadMedidaRepository unidadMedidaRepository, UsuarioRepository usuarioRepository, MPDatosRepository mpDatosRepository) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");




			RubroArticulo rubroArticulo = RubroArticulo.builder()
					.denominacion("Alimentos")
					.fechaAlta(new Date(123,11,5))
					.build();

			rubroArticuloRepository.save(rubroArticulo);

			UnidadMedida unidadMedida = UnidadMedida.builder()
					.denominacion("kilogramos")
					.abreviatura("kgs")
					.fechaAlta(new Date(123,11,5))
					.build();

			unidadMedidaRepository.save(unidadMedida);

			MPDatos mpDatos = MPDatos.builder()
					.mpPaymentId(241651L)
					.mpMerchantOrderId(415136L)
					.mpPreferenceId("preference_1")
					.mpPaymentType("mercado_credito")
					.fechaAlta(new Date(123,11,5))
					.build();
			mpDatosRepository.save(mpDatos);






			Cliente cliente = Cliente.builder()
					.nombre("Pepe")
					.apellido("Mujica")
					.telefono("2618925543")
					.email("pepemujica@gmail.com")
					.fechaAlta(new Date(123,11,5))
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("San Martin")
					.numero(978)
					.codigoPostal(5500)
					.localidad("Ciudad")
					.numeroDpto(2)
					.pisoDpto(4)
					.fechaAlta(new Date(123,11,5))
					.build();


			Usuario usuario = Usuario.builder()
					.auth0Id("1234567890")
					.username("Agustyn")
					.fechaAlta(new Date(123,11,5))
					.build();
			cliente.setUsuario(usuario);











			Factura factura = Factura.builder()
					.fechaFacturacion(new Date(123, 11, 4))
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalVenta(BigDecimal.valueOf(12500))
					.fechaAlta(new Date(123,11,5))
					.mpDatos(mpDatos)
					.build();


			Pedido pedido = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(12500))
					.totalCosto(BigDecimal.valueOf(13000))
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.MERCADO_PAGO)
					.domicilioEntrega(domicilio)
					.cliente(cliente)
					.factura(factura)
					.fechaAlta(new Date(123,11,5))
					.build();

			facturaRepository.save(factura);

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
					.denominacion("Queso")
					.urlImagen("queso.png")
					.precioCompra(BigDecimal.valueOf(2500))
					.stockActual(BigDecimal.valueOf(25))
					.stockMinimo(BigDecimal.valueOf(5))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo)
					.fechaAlta(new Date(123,11,5))
					.build();

				articuloInsumoRepository.save(articuloInsumo);

			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
					.denominacion("Pizza especial")
					.descripcion("Pizza de muzzarella con jamon cocido y morrones")
					.tiempoEstimadoCocina(10)
					.precioVenta(BigDecimal.valueOf(2000))
					.costo(BigDecimal.valueOf(1000))
					.urlImagen("pizzaespecial.png")
					.fechaAlta(new Date(123,11,5))
					.build();

			articuloManufacturadoRepository.save(articuloManufacturado);

			DetalleArticuloManufacturado detalleArticuloManufacturado = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(5))
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumo)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado);


			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(5)
					.subtotal(BigDecimal.valueOf(13000))
					.subtotalCosto(BigDecimal.valueOf(6500))
					.pedido(pedido)
					.articuloInsumo(articuloInsumo)
					.articuloManufacturado(articuloManufacturado)
					.build();


			DetalleFactura detalleFactura = DetalleFactura.builder()
					.cantidad(5)
					.subtotal(BigDecimal.valueOf(13000))
					.articuloInsumo(articuloInsumo)
					.articuloManufacturado(articuloManufacturado)
					.factura(factura)
					.build();
			cliente.agregarDomicilio(domicilio);
			clienteRepository.save(cliente);


			domicilioRepository.save(domicilio);



			pedidoRepository.save(pedido);

			detallePedidoRepository.save(detallePedido);

			usuarioRepository.save(usuario);

			facturaRepository.save(factura);


			detalleFacturaRepository.save(detalleFactura);

		};

	}

}
