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
	CommandLineRunner init(ArticuloInsumoRepository articuloInsumoRepository, ArticuloManufacturadoRepository articuloManufacturadoRepository, ClienteRepository clienteRepository, DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository, DetalleFacturaRepository detalleFacturaRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, RubroArticuloRepository rubroArticuloRepository, UnidadMedidaRepository unidadMedidaRepository, UsuarioRepository usuarioRepository, MPDatosRepository mpDatosRepository, RubroArticuloManufacturadoRepository rubroArticuloManufacturadoRepository) {
		return args -> {
			System.out.println("/-/-/-/--- * ESTOY FUNCIONANDO * ---/-/-/-/");


			// Rubros Articulos (Rubro de Productos)
			RubroArticuloManufacturado rubroArticuloManufacturado = RubroArticuloManufacturado.builder()
					.denominacion("Hamburguesas")
					.fechaAlta(new Date(123, 11, 5))
					.build();


			RubroArticuloManufacturado rubroArticuloManufacturado2 = RubroArticuloManufacturado.builder()
					.denominacion("Pizzas")
					.fechaAlta(new Date(123, 11, 5))
					.build();


// Rubros Articulos (Rubro de Ingredientes)


			RubroArticulo rubroArticulo = RubroArticulo.builder()
					.denominacion("Fiambres")
					.fechaAlta(new Date(123, 11, 5))
					.build();


			rubroArticuloRepository.save(rubroArticulo);


			RubroArticulo rubroArticulo2 = RubroArticulo.builder()
					.denominacion("Verduras")
					.fechaAlta(new Date(123, 11, 5))
					.build();


			rubroArticuloRepository.save(rubroArticulo2);


			RubroArticulo rubroArticulo3 = RubroArticulo.builder()
					.denominacion("Panificados")
					.fechaAlta(new Date(123, 11, 5))
					.build();
			rubroArticuloRepository.save(rubroArticulo3);


			RubroArticulo rubroArticulo4 = RubroArticulo.builder()
					.denominacion("Carnes")
					.fechaAlta(new Date(123, 11, 5))
					.build();
			rubroArticuloRepository.save(rubroArticulo4);


// Unidades de Medida


			UnidadMedida unidadMedida = UnidadMedida.builder()
					.denominacion("kilogramos")
					.abreviatura("kgs")
					.fechaAlta(new Date(123, 11, 5))
					.build();


			UnidadMedida unidadMedida2 = UnidadMedida.builder()
					.denominacion("gramos")
					.abreviatura("grs")
					.fechaAlta(new Date(123, 11, 5))
					.build();


			UnidadMedida unidadMedida3 = UnidadMedida.builder()
					.denominacion("litros")
					.abreviatura("lts")
					.fechaAlta(new Date(123, 11, 5))
					.build();


			UnidadMedida unidadMedida4 = UnidadMedida.builder()
					.denominacion("unidad_por_pack")
					.abreviatura("unid")
					.fechaAlta(new Date(123, 11, 5))
					.build();


			unidadMedidaRepository.save(unidadMedida);
			unidadMedidaRepository.save(unidadMedida2);
			unidadMedidaRepository.save(unidadMedida3);
			unidadMedidaRepository.save(unidadMedida4);


// Mercado Pago Datos


			MPDatos mpDatos = MPDatos.builder()
					.mpPaymentId(241651L)
					.mpMerchantOrderId(415136L)
					.mpPreferenceId("preference_1")
					.mpPaymentType("mercado_credito")
					.fechaAlta(new Date(123, 11, 5))
					.build();
			mpDatosRepository.save(mpDatos);


			MPDatos mpDatos2 = MPDatos.builder()
					.mpPaymentId(2416512L)
					.mpMerchantOrderId(4151362L)
					.mpPreferenceId("preference_1")
					.mpPaymentType("mercado_credito")
					.fechaAlta(new Date(123, 11, 5))
					.build();
			mpDatosRepository.save(mpDatos2);


//Datos de Clientes


			Cliente cliente = Cliente.builder()
					.nombre("Pepe")
					.apellido("Mujica")
					.telefono("2618925543")
					.email("pepemujica@gmail.com")
					.fechaAlta(new Date(123, 11, 5))
					.build();
			Cliente cliente2 = Cliente.builder()
					.nombre("kevin")
					.apellido("navarro")
					.telefono("2618925543")
					.email("kevin@gmail.com")
					.fechaAlta(new Date(123, 11, 5))
					.build();
			Cliente cliente3 = Cliente.builder()
					.nombre("Luis")
					.apellido("Perez")
					.telefono("261833777")
					.email("luis@gmail.com")
					.fechaAlta(new Date(123, 11, 5))
					.build();
			Cliente cliente4 = Cliente.builder()
					.nombre("Albert")
					.apellido("Fernandez")
					.telefono("261789998")
					.email("beto@gmail.com")
					.fechaAlta(new Date(123, 11, 5))
					.build();
			Cliente cliente5 = Cliente.builder()
					.nombre("Juan")
					.apellido("Sanchez")
					.telefono("261657892")
					.email("juan@gmail.com")
					.fechaAlta(new Date(123, 11, 5))
					.build();


//Datos de Domicilio


			Domicilio domicilio = Domicilio.builder()
					.calle("San Martin")
					.numero(978)
					.codigoPostal(5500)
					.localidad("Ciudad")
					.numeroDpto(2)
					.pisoDpto(4)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Domicilio domicilio2 = Domicilio.builder()
					.calle("Sarmiento")
					.numero(777)
					.codigoPostal(5519)
					.localidad("Guaymallen")
					.numeroDpto(4)
					.pisoDpto(20)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Domicilio domicilio3 = Domicilio.builder()
					.calle("Chile")
					.numero(1978)
					.codigoPostal(5500)
					.localidad("Ciudad")
					.numeroDpto(2)
					.pisoDpto(4)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Domicilio domicilio4 = Domicilio.builder()
					.calle("Godoy Cruz y Sarmiento")
					.numero(1978)
					.codigoPostal(5500)
					.localidad("Guaymallen")
					.numeroDpto(1)
					.pisoDpto(3)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Domicilio domicilio5 = Domicilio.builder()
					.calle("Avelleda")
					.numero(1978)
					.codigoPostal(5520)
					.localidad("Las Heras")
					.numeroDpto(1)
					.pisoDpto(3)
					.fechaAlta(new Date(123, 11, 5))
					.build();


//Datos de Usuario


			Usuario usuario = Usuario.builder()
					.auth0Id("1234567890")
					.username("pepeAdmin")
					.contraseña("pasword123")
					.rol(Rol.ADMINISTRADOR)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			cliente.setUsuario(usuario);


			Usuario usuario2 = Usuario.builder()
					.auth0Id("12345670")
					.username("kevinsx")
					.contraseña("asd1232")
					.rol(Rol.CLIENTE)
					.fechaAlta(new Date(123, 6, 5))
					.build();


			cliente2.setUsuario(usuario2);


			Usuario usuario3 = Usuario.builder()
					.auth0Id("455412")
					.username("luis.buensabor")
					.contraseña("contraseña123")
					.rol(Rol.EMPLEADO)
					.fechaAlta(new Date(123, 6, 5))
					.build();
			cliente3.setUsuario(usuario3);


			Usuario usuario4 = Usuario.builder()
					.auth0Id("763434")
					.username("albert_buensabor")
					.contraseña("mypassword")
					.rol(Rol.EMPLEADO)
					.fechaAlta(new Date(123, 6, 5))
					.build();
			cliente4.setUsuario(usuario4);


			Usuario usuario5 = Usuario.builder()
					.auth0Id("56767123")
					.username("juanpi_231")
					.contraseña("welcome123")
					.rol(Rol.CLIENTE)
					.fechaAlta(new Date(123, 6, 5))
					.build();
			cliente5.setUsuario(usuario5);


//Facturaass


			Factura factura = Factura.builder()
					.fechaFacturacion(new Date(123, 4, 4))
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalVenta(BigDecimal.valueOf(15000))
					.fechaAlta(new Date(123, 4, 4))
					.mpDatos(mpDatos)
					.build();


			Factura factura2 = Factura.builder()
					.fechaFacturacion(new Date(123, 5, 3))
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(37000))
					.fechaAlta(new Date(123, 5, 3))
					.build();


			Factura factura3 = Factura.builder()
					.fechaFacturacion(new Date(123, 10, 4))
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(10000))
					.fechaAlta(new Date(123, 10, 4))
					.build();


			Factura factura4 = Factura.builder()
					.fechaFacturacion(new Date(123, 10, 4))
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(27500))
					.fechaAlta(new Date(123, 10, 4))
					.build();


			Factura factura5 = Factura.builder()
					.fechaFacturacion(new Date(123, 10, 4))
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(27500))
					.fechaAlta(new Date(123, 10, 4))
					.build();


			Factura factura6 = Factura.builder()
					.fechaFacturacion(new Date(123, 10, 4))
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(33000))
					.fechaAlta(new Date(123, 10, 4))
					.build();


			Factura factura7 = Factura.builder()
					.fechaFacturacion(new Date(123, 10, 4))
					.formaPago(FormaPago.EFECTIVO)
					.totalVenta(BigDecimal.valueOf(20000))
					.fechaAlta(new Date(123, 10, 4))
					.build();


//Pedidos


			Pedido pedido = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(15000))
					.totalCosto(BigDecimal.valueOf(13000)) /////////q ase este atrib?
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.MERCADO_PAGO)
					.domicilioEntrega(domicilio)
					.cliente(cliente)
					.factura(factura)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Pedido pedido2 = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(37000))
					.totalCosto(BigDecimal.valueOf(13000))
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.EFECTIVO)
					.domicilioEntrega(domicilio2)
					.cliente(cliente2)
					.factura(factura2)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Pedido pedido3 = Pedido.builder()
					.fechaPedido(new Date(123, 10, 4))
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(10000))
					.totalCosto(BigDecimal.valueOf(10000))
					.estado(EstadoPedido.COMPLETADO)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.formaPago(FormaPago.EFECTIVO)
					.domicilioEntrega(domicilio2)
					.cliente(cliente2)
					.factura(factura3)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Pedido pedido4 = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(10000))
					.totalCosto(BigDecimal.valueOf(10000))
					.estado(EstadoPedido.PENDIENTE_ENTREGA)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.EFECTIVO)
					.domicilioEntrega(domicilio)
					.cliente(cliente)
					.factura(factura4)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Pedido pedido5 = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(15000))
					.totalCosto(BigDecimal.valueOf(15000))
					.estado(EstadoPedido.EN_CAMINO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.EFECTIVO)
					.domicilioEntrega(domicilio)
					.cliente(cliente)
					.factura(factura5)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			Pedido pedido6 = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(33000))
					.totalCosto(BigDecimal.valueOf(33000))
					.estado(EstadoPedido.PAGADO)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.formaPago(FormaPago.EFECTIVO)
					.domicilioEntrega(domicilio5)
					.cliente(cliente5)
					.factura(factura6)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			Pedido pedido7 = Pedido.builder()
					.fechaPedido(new Date())
					.horaEstimadaFinalizacion(new Date(123, 11, 8))
					.total(BigDecimal.valueOf(20000))
					.totalCosto(BigDecimal.valueOf(20000))
					.estado(EstadoPedido.PENDIENTE_ENTREGA)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.EFECTIVO)
					.domicilioEntrega(domicilio5)
					.cliente(cliente5)
					.factura(factura7)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			facturaRepository.save(factura);
			facturaRepository.save(factura2);
			facturaRepository.save(factura3);
			facturaRepository.save(factura4);
			facturaRepository.save(factura5);
			facturaRepository.save(factura6);
			facturaRepository.save(factura7);


//Fiambres


			ArticuloInsumo articuloInsumoChedar = ArticuloInsumo.builder()
					.denominacion("Queso Chedar")
					.urlImagen("queso.png")
					.precioCompra(BigDecimal.valueOf(2200))
					.stockActual(BigDecimal.valueOf(4))
					.stockMinimo(BigDecimal.valueOf(2))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			articuloInsumoRepository.save(articuloInsumoChedar);


			ArticuloInsumo articuloInsumoJamon = ArticuloInsumo.builder()
					.denominacion("Jamon Cocido")
					.urlImagen("jamoncocido.png")
					.precioCompra(BigDecimal.valueOf(2000))
					.stockActual(BigDecimal.valueOf(6))
					.stockMinimo(BigDecimal.valueOf(3))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo3)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			articuloInsumoRepository.save(articuloInsumoJamon);


			ArticuloInsumo articuloInsumoMozza = ArticuloInsumo.builder()
					.denominacion("Mozzarella")
					.urlImagen("queso_mozza.png")
					.precioCompra(BigDecimal.valueOf(1900))
					.stockActual(BigDecimal.valueOf(8))
					.stockMinimo(BigDecimal.valueOf(4))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			articuloInsumoRepository.save(articuloInsumoMozza);


			//Carnes


			ArticuloInsumo articuloInsumoHamburg = ArticuloInsumo.builder()
					.denominacion("Hamburgesa de Carne")
					.urlImagen("burgercarne.png")
					.precioCompra(BigDecimal.valueOf(3500))
					.stockActual(BigDecimal.valueOf(10))
					.stockMinimo(BigDecimal.valueOf(5))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo4)
					.fechaAlta(new Date(123, 11, 5))
					.build();


			articuloInsumoRepository.save(articuloInsumoHamburg);


			// Verdurass
			ArticuloInsumo articuloInsumoTomate = ArticuloInsumo.builder()
					.denominacion("Tomate")
					.urlImagen("tomato.png")
					.precioCompra(BigDecimal.valueOf(800))
					.stockActual(BigDecimal.valueOf(10))
					.stockMinimo(BigDecimal.valueOf(5))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo2)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			articuloInsumoRepository.save(articuloInsumoTomate);


			ArticuloInsumo articuloInsumoLechuga = ArticuloInsumo.builder()
					.denominacion("Lechuga")
					.urlImagen("lechuga.png")
					.precioCompra(BigDecimal.valueOf(500))
					.stockActual(BigDecimal.valueOf(7))
					.stockMinimo(BigDecimal.valueOf(3))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo2)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			articuloInsumoRepository.save(articuloInsumoLechuga);


			ArticuloInsumo articuloInsumoCebolla = ArticuloInsumo.builder()
					.denominacion("Cebolla")
					.urlImagen("cebolla.png")
					.precioCompra(BigDecimal.valueOf(700))
					.stockActual(BigDecimal.valueOf(1))
					.stockMinimo(BigDecimal.valueOf(2))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo2)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			articuloInsumoRepository.save(articuloInsumoCebolla);


			ArticuloInsumo articuloInsumoMorrones = ArticuloInsumo.builder()
					.denominacion("Morron")
					.urlImagen("morron.png")
					.precioCompra(BigDecimal.valueOf(1500))
					.stockActual(BigDecimal.valueOf(2))
					.stockMinimo(BigDecimal.valueOf(3))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo2)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			articuloInsumoRepository.save(articuloInsumoMorrones);


			// panificados
			ArticuloInsumo articuloInsumoPan = ArticuloInsumo.builder()
					.denominacion("Pan de Hamburguesas")
					.urlImagen("panhamburguesa.png")
					.precioCompra(BigDecimal.valueOf(1000))
					.stockActual(BigDecimal.valueOf(20))
					.stockMinimo(BigDecimal.valueOf(15))
					.unidadMedida(unidadMedida)
					.rubroArticulo(rubroArticulo3)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			articuloInsumoRepository.save(articuloInsumoPan);


			ArticuloInsumo articuloInsumoPrepizzas = ArticuloInsumo.builder()
					.denominacion("Prepizzas")
					.urlImagen("prepizzas.png")
					.precioCompra(BigDecimal.valueOf(1600))
					.stockActual(BigDecimal.valueOf(10))
					.stockMinimo(BigDecimal.valueOf(7))
					.unidadMedida(unidadMedida4)
					.rubroArticulo(rubroArticulo3)
					.fechaAlta(new Date(123, 11, 5))
					.build();
			articuloInsumoRepository.save(articuloInsumoPrepizzas);


			//Articulos Manufacturados (Productos)


			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
					.denominacion("Pizza especial")
					.descripcion("Pizza de muzzarella con jamon cocido y morrones")
					.tiempoEstimadoCocina(20)
					.precioVenta(BigDecimal.valueOf(5000))
					.costo(BigDecimal.valueOf(3000))
					.urlImagen("pizzaespecial.png")
					.fechaAlta(new Date(123, 11, 5))
					.rubroArticuloManufacturado(rubroArticuloManufacturado2)
					.build();


			ArticuloManufacturado articuloManufacturado1 = ArticuloManufacturado.builder()
					.denominacion("Hamburguesa Simple")
					.descripcion("Hamburguesa simple de carne con chedar, lechuga , tomate y cebolla")
					.tiempoEstimadoCocina(15)
					.precioVenta(BigDecimal.valueOf(5500))
					.costo(BigDecimal.valueOf(4500))
					.urlImagen("hamburguesa.png")
					.fechaAlta(new Date(123, 11, 5))
					.rubroArticuloManufacturado(rubroArticuloManufacturado)
					.build();


			rubroArticuloManufacturadoRepository.save(rubroArticuloManufacturado);
			rubroArticuloManufacturadoRepository.save(rubroArticuloManufacturado2);
			articuloManufacturadoRepository.save(articuloManufacturado);
			articuloManufacturadoRepository.save(articuloManufacturado1);


			ArticuloManufacturado articuloManufacturado2 = ArticuloManufacturado.builder()
					.denominacion("Hamburguesa_triple")
					.descripcion("Hamburguesa triple carne con chedar, lechuga , tomate y cebolla")
					.tiempoEstimadoCocina(25)
					.precioVenta(BigDecimal.valueOf(7500))
					.costo(BigDecimal.valueOf(5500))
					.urlImagen("hamburguesa_triple.png")
					.fechaAlta(new Date(123, 11, 5))
					.rubroArticuloManufacturado(rubroArticuloManufacturado)
					.build();
			articuloManufacturadoRepository.save(articuloManufacturado2);


// Detalles Articulos Manufacturados


// hamburguesa Simple


			DetalleArticuloManufacturado detalleArticuloManufacturado = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado1)
					.articuloInsumo(articuloInsumoPan)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado);


			DetalleArticuloManufacturado detalleArticuloManufacturado2 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado1)
					.articuloInsumo(articuloInsumoHamburg)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado2);


			DetalleArticuloManufacturado detalleArticuloManufacturado3 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado1)
					.articuloInsumo(articuloInsumoTomate)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado3);


			DetalleArticuloManufacturado detalleArticuloManufacturado4 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado1)
					.articuloInsumo(articuloInsumoLechuga)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado4);


			DetalleArticuloManufacturado detalleArticuloManufacturado5 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado1)
					.articuloInsumo(articuloInsumoCebolla)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado5);


			DetalleArticuloManufacturado detalleArticuloManufacturado6 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado1)
					.articuloInsumo(articuloInsumoChedar)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado6);


// hamburguesa triple


			DetalleArticuloManufacturado detalleArticuloManufacturado7 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado2)
					.articuloInsumo(articuloInsumoPan)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado7);


			DetalleArticuloManufacturado detalleArticuloManufacturado8 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(3))
					.articuloManufacturado(articuloManufacturado2)
					.articuloInsumo(articuloInsumoHamburg)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado8);


			DetalleArticuloManufacturado detalleArticuloManufacturado9 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado2)
					.articuloInsumo(articuloInsumoTomate)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado9);


			DetalleArticuloManufacturado detalleArticuloManufacturado10 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado2)
					.articuloInsumo(articuloInsumoLechuga)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado10);


			DetalleArticuloManufacturado detalleArticuloManufacturado11 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado2)
					.articuloInsumo(articuloInsumoCebolla)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado11);


			DetalleArticuloManufacturado detalleArticuloManufacturado12 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado2)
					.articuloInsumo(articuloInsumoChedar)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado12);


//pIZZA


			DetalleArticuloManufacturado detalleArticuloManufacturado13 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(1))
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumoPrepizzas)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado13);


			DetalleArticuloManufacturado detalleArticuloManufacturado14 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(200))
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumoMozza)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado14);


			DetalleArticuloManufacturado detalleArticuloManufacturado15 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(100))
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumoJamon)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado15);


			DetalleArticuloManufacturado detalleArticuloManufacturado16 = DetalleArticuloManufacturado.builder()
					.cantidad(BigDecimal.valueOf(100))
					.articuloManufacturado(articuloManufacturado)
					.articuloInsumo(articuloInsumoMorrones)
					.build();
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado16);


//Detalles Pedidos


			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(3)
					.subtotal(BigDecimal.valueOf(15000))
					.subtotalCosto(BigDecimal.valueOf(15000)) // q ase este atrib?
					.pedido(pedido)
					.articuloManufacturado(articuloManufacturado)
					.build();


			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(BigDecimal.valueOf(22000))
					.subtotalCosto(BigDecimal.valueOf(22000))
					.pedido(pedido2)
					.articuloManufacturado(articuloManufacturado1)
					.build();


			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(15000))
					.subtotalCosto(BigDecimal.valueOf(15000))
					.pedido(pedido2)
					.articuloManufacturado(articuloManufacturado2)
					.build();


			DetallePedido detallePedido4 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(10000))
					.subtotalCosto(BigDecimal.valueOf(10000))
					.pedido(pedido3)
					.articuloManufacturado(articuloManufacturado)
					.build();


			DetallePedido detallePedido5 = DetallePedido.builder()
					.cantidad(5)
					.subtotal(BigDecimal.valueOf(27500))
					.subtotalCosto(BigDecimal.valueOf(27500))
					.pedido(pedido4)
					.articuloManufacturado(articuloManufacturado1)
					.build();


			DetallePedido detallePedido6 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(15000))
					.subtotalCosto(BigDecimal.valueOf(15000))
					.pedido(pedido5)
					.articuloManufacturado(articuloManufacturado2)
					.build();


			DetallePedido detallePedido7 = DetallePedido.builder()
					.cantidad(6)
					.subtotal(BigDecimal.valueOf(33000))
					.subtotalCosto(BigDecimal.valueOf(33000))
					.pedido(pedido6)
					.articuloManufacturado(articuloManufacturado1)
					.build();


			DetallePedido detallePedido8 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(BigDecimal.valueOf(20000))
					.subtotalCosto(BigDecimal.valueOf(20000))
					.pedido(pedido7)
					.articuloManufacturado(articuloManufacturado)
					.build();


//Detalles Facturas


			DetalleFactura detalleFactura = DetalleFactura.builder()
					.cantidad(3)
					.subtotal(BigDecimal.valueOf(15000))
					.articuloManufacturado(articuloManufacturado)
					.factura(factura)
					.build();


			DetalleFactura detalleFactura2 = DetalleFactura.builder()
					.cantidad(4)
					.subtotal(BigDecimal.valueOf(22000))
					.articuloManufacturado(articuloManufacturado1)
					.factura(factura2)
					.build();


			DetalleFactura detalleFactura3 = DetalleFactura.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(15000))
					.articuloManufacturado(articuloManufacturado2)
					.factura(factura2)
					.build();


			DetalleFactura detalleFactura4 = DetalleFactura.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(10000))
					.articuloManufacturado(articuloManufacturado)
					.factura(factura3)
					.build();


			DetalleFactura detalleFactura5 = DetalleFactura.builder()
					.cantidad(5)
					.subtotal(BigDecimal.valueOf(27500))
					.articuloManufacturado(articuloManufacturado1)
					.factura(factura4)
					.build();


			DetalleFactura detalleFactura6 = DetalleFactura.builder()
					.cantidad(2)
					.subtotal(BigDecimal.valueOf(15000))
					.articuloManufacturado(articuloManufacturado2)
					.factura(factura5)
					.build();


			DetalleFactura detalleFactura7 = DetalleFactura.builder()
					.cantidad(6)
					.subtotal(BigDecimal.valueOf(33000))
					.articuloManufacturado(articuloManufacturado1)
					.factura(factura6)
					.build();


			DetalleFactura detalleFactura8 = DetalleFactura.builder()
					.cantidad(4)
					.subtotal(BigDecimal.valueOf(20000))
					.articuloManufacturado(articuloManufacturado)
					.factura(factura7)
					.build();


			cliente.agregarDomicilio(domicilio);
			cliente2.agregarDomicilio(domicilio2);
			cliente3.agregarDomicilio(domicilio3);
			cliente4.agregarDomicilio(domicilio4);
			cliente5.agregarDomicilio(domicilio5);


			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);
			clienteRepository.save(cliente3);
			clienteRepository.save(cliente4);
			clienteRepository.save(cliente5);


			domicilioRepository.save(domicilio);
			domicilioRepository.save(domicilio2);
			domicilioRepository.save(domicilio3);
			domicilioRepository.save(domicilio4);
			domicilioRepository.save(domicilio5);


			pedidoRepository.save(pedido);
			pedidoRepository.save(pedido2);
			pedidoRepository.save(pedido3);
			pedidoRepository.save(pedido4);
			pedidoRepository.save(pedido5);
			pedidoRepository.save(pedido6);
			pedidoRepository.save(pedido7);


			detallePedidoRepository.save(detallePedido);
			detallePedidoRepository.save(detallePedido2);
			detallePedidoRepository.save(detallePedido3);
			detallePedidoRepository.save(detallePedido4);
			detallePedidoRepository.save(detallePedido5);
			detallePedidoRepository.save(detallePedido6);
			detallePedidoRepository.save(detallePedido7);
			detallePedidoRepository.save(detallePedido8);


			usuarioRepository.save(usuario);
			usuarioRepository.save(usuario2);
			usuarioRepository.save(usuario3);
			usuarioRepository.save(usuario4);
			usuarioRepository.save(usuario5);


			detalleFacturaRepository.save(detalleFactura);
			detalleFacturaRepository.save(detalleFactura2);
			detalleFacturaRepository.save(detalleFactura3);
			detalleFacturaRepository.save(detalleFactura4);
			detalleFacturaRepository.save(detalleFactura5);
			detalleFacturaRepository.save(detalleFactura6);
			detalleFacturaRepository.save(detalleFactura7);
			detalleFacturaRepository.save(detalleFactura8);


		};
	}
}