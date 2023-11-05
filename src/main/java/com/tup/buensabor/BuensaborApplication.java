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

	@Autowired
	RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(
				BuensaborApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ArticuloInsumoRepository articuloInsumoRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository, ClienteRepository clienteRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository, DetalleFacturaRepository detalleFacturaRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, RubroArticuloRepository rubroArticuloRepository, UnidadMedidaRepository unidadMedidaRepository, UsuarioRepository usuarioRepository, MPDatosRepository mpDatosRepository, RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository) {
		return args -> {
			System.out.println("/-/-/-/-/---ESTOY FUNCIONANDO---/-/-/-/-/");




			RubroArticuloManufacturado rubroArticuloManufacturado = RubroArticuloManufacturado.builder()
					.denominacion("Pizzas")
					.fechaAlta(new Date(123,11,5))
					.build();

			rubroArticuloManufacturadoRepository.save(rubroArticuloManufacturado);

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

			MPDatos mpDatos2 = MPDatos.builder()
					.mpPaymentId(2416512L)
					.mpMerchantOrderId(4151362L)
					.mpPreferenceId("preference_1")
					.mpPaymentType("mercado_credito")
					.fechaAlta(new Date(123,11,5))
					.build();

			mpDatosRepository.save(mpDatos2);




			Cliente cliente = Cliente.builder()
					.nombre("Pepe")
					.apellido("Mujica")
					.telefono("2618925543")
					.email("pepemujica@gmail.com")
					.fechaAlta(new Date(123,11,5))
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("kevin")
					.apellido("navarro")
					.telefono("2618925543")
					.email("kevin@gmail.com")
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

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Sarmiento")
					.numero(777)
					.codigoPostal(5519)
					.localidad("Guaymallen")
					.numeroDpto(4)
					.pisoDpto(20)
					.fechaAlta(new Date(123,11,5))
					.build();

			Usuario usuario = Usuario.builder()
					.auth0Id("1234567890")
					.username("Agustyn")
					.fechaAlta(new Date(123,11,5))
					.build();
			cliente.setUsuario(usuario);

			Usuario usuario2 = Usuario.builder()
					.auth0Id("12345670")
					.username("kevinsx")
					.fechaAlta(new Date(123,6,5))
					.build();

			cliente2.setUsuario(usuario2);

			Factura factura = Factura.builder()
					.fechaFacturacion(new Date(123, 11, 4))
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalVenta(BigDecimal.valueOf(12500))
					.fechaAlta(new Date(123,11,5))
					.mpDatos(mpDatos)
					.build();

			Factura factura2 = Factura.builder()
					.fechaFacturacion(new Date(123, 10, 4))
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(12500))
					.fechaAlta(new Date(123,11,5))
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

			Pedido pedido2 = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(12500))
					.totalCosto(BigDecimal.valueOf(13000))
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.EFECTIVO)
					.domicilioEntrega(domicilio2)
					.cliente(cliente2)
					.factura(factura2)
					.fechaAlta(new Date(123,11,5))
					.build();


			facturaRepository.save(factura);
			facturaRepository.save(factura2);

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


				ArticuloInsumo articuloInsumo2 = ArticuloInsumo.builder()
					.denominacion("Carne")
					.urlImagen("carne.png")
					.precioCompra(BigDecimal.valueOf(4500))
					.stockActual(BigDecimal.valueOf(25))
					.stockMinimo(BigDecimal.valueOf(5))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo)
					.fechaAlta(new Date(123,11,5))
					.build();

				articuloInsumoRepository.save(articuloInsumo2);


			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
					.denominacion("Pizza especial")
					.descripcion("Pizza de muzzarella con jamon cocido y morrones")
					.tiempoEstimadoCocina(10)
					.precioVenta(BigDecimal.valueOf(2000))
					.costo(BigDecimal.valueOf(1000))
					.urlImagen("pizzaespecial.png")
					.fechaAlta(new Date(123,11,5))
					.rubroArticuloManufacturado(rubroArticuloManufacturado)
					.build();

			articuloManufacturadoRepository.save(articuloManufacturado);


			ArticuloManufacturado articuloManufacturado1 = ArticuloManufacturado.builder()
					.denominacion("Hamburguesa")
					.descripcion("Hamburguesa de carne")
					.tiempoEstimadoCocina(15)
					.precioVenta(BigDecimal.valueOf(3000))
					.costo(BigDecimal.valueOf(2500))
					.urlImagen("hamburguesa.png")
					.fechaAlta(new Date(123,11,5))
					.rubroArticuloManufacturado(rubroArticuloManufacturado)
					.build();
			articuloManufacturadoRepository.save(articuloManufacturado1);


			ArticuloManufacturado articuloManufacturado2 = ArticuloManufacturado.builder()
					.denominacion("Hamburguesa_triple")
					.descripcion("Hamburguesa triple carne")
					.tiempoEstimadoCocina(25)
					.precioVenta(BigDecimal.valueOf(6000))
					.costo(BigDecimal.valueOf(4500))
					.urlImagen("hamburguesa_triple.png")
					.fechaAlta(new Date(123,11,5))
					.rubroArticuloManufacturado(rubroArticuloManufacturado)
					.build();
			articuloManufacturadoRepository.save(articuloManufacturado2);

			DetalleArticuloManufacturado detalleArticuloManufacturado = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(5))
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumo)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado);


			DetalleArticuloManufacturado detalleArticuloManufacturado2 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(8))
					.articuloManufacturado(articuloManufacturado1)
					.articuloInsumo(articuloInsumo2)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado2);


			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(5)
					.subtotal(BigDecimal.valueOf(13000))
					.subtotalCosto(BigDecimal.valueOf(6500))
					.pedido(pedido)
					.articuloManufacturado(articuloManufacturado)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(13000))
					.subtotalCosto(BigDecimal.valueOf(6500))
					.pedido(pedido2)
					.articuloManufacturado(articuloManufacturado1)
					.build();

			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(3)
					.subtotal(BigDecimal.valueOf(23000))
					.subtotalCosto(BigDecimal.valueOf(11500))
					.pedido(pedido2)
					.articuloManufacturado(articuloManufacturado2)
					.build();


			DetalleFactura detalleFactura = DetalleFactura.builder()
					.cantidad(5)
					.subtotal(BigDecimal.valueOf(13000))
					.articuloManufacturado(articuloManufacturado)
					.factura(factura)
					.build();
			DetalleFactura detalleFactura2 = DetalleFactura.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(13000))
					.articuloManufacturado(articuloManufacturado1)
					.factura(factura2)
					.build();

			DetalleFactura detalleFactura3 = DetalleFactura.builder()
					.cantidad(3)
					.subtotal(BigDecimal.valueOf(23000))
					.articuloManufacturado(articuloManufacturado2)
					.factura(factura2)
					.build();



			cliente.agregarDomicilio(domicilio);
			cliente.agregarDomicilio(domicilio2);
			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);


			domicilioRepository.save(domicilio);
			domicilioRepository.save(domicilio2);



			pedidoRepository.save(pedido);
			pedidoRepository.save(pedido2);

			detallePedidoRepository.save(detallePedido);
			detallePedidoRepository.save(detallePedido2);
			detallePedidoRepository.save(detallePedido3);

			usuarioRepository.save(usuario);
			usuarioRepository.save(usuario2);

			facturaRepository.save(factura);
			facturaRepository.save(factura2);


			detalleFacturaRepository.save(detalleFactura);
			detalleFacturaRepository.save(detalleFactura2);
			detalleFacturaRepository.save(detalleFactura3);

		};

	}

}
