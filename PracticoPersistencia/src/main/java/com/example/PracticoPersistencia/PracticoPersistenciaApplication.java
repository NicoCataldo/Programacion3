package com.example.PracticoPersistencia;

import com.example.PracticoPersistencia.Entidades.*;
import com.example.PracticoPersistencia.Enums.Estado;
import com.example.PracticoPersistencia.Enums.FormasDePago;
import com.example.PracticoPersistencia.Enums.Tipo;
import com.example.PracticoPersistencia.Enums.TipoEnvio;
import com.example.PracticoPersistencia.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class PracticoPersistenciaApplication {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	FacturaRepository facturaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PracticoPersistenciaApplication.class, args);
		System.out.println("Estoy funcionando por ahora");

	}
	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, PedidoRepository pedidoRepository,
						   DetallePedidoRepository detallePedidoRepository,DomicilioRepository domicilioRepository,
						   UsuarioRepository usuarioRepository, RubroRepository rubroRepository,
						   ProductoRepository productoRepository, FacturaRepository facturaRepository) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
//Creo un Rubro
			Rubro rubro = Rubro.builder()
					.denominacion("ComidasRapidas")
					.build();
//Creo dos productos y los asigno a cada rubro
			Producto producto1 = Producto.builder()
					.tipo(Tipo.MANOFACTURADO)
					.tiempoEstimado(20)
					.denominacion("Hambuguesa")
					.precioVenta(2800)
					.precioCompra(1800)
					.stockActual(20)
					.stoclMinimo(5)
					.unidadMedida("unidad")
					.build();
			Producto producto2 = Producto.builder()
					.tipo(Tipo.MANOFACTURADO)
					.tiempoEstimado(20)
					.denominacion("Pizza")
					.precioVenta(2500)
					.precioCompra(2000)
					.stockActual(30)
					.stoclMinimo(10)
					.unidadMedida("cm")
					.build();
			rubro.agregarProductos(producto1);
			rubro.agregarProductos(producto2);
//Creo dos usarios que son empleados del local
			Usuario usuario1 = Usuario.builder()
					.rol("Cocinero")
					.password("cocinero123")
					.nombre("PedroElCocinero")
					.build();

			Usuario usuario2 = Usuario.builder()
					.rol("Recepcionista")
					.password("recepcion123")
					.nombre("JuanElRecepcionista")
					.build();
//Creo dos Clientes y dos domicilios y le asigno un domicilio a cada uno
			Cliente cliente1 = Cliente.builder()
					.nombre("Oscar")
					.apellido("Perez")
					.email("oscarperez@gamil.com")
					.telefono("2617384772")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Carlos")
					.apellido("Paz")
					.email("CarlosPaz@gamil.com")
					.telefono("26173632")
					.build();

			Domicilio domicilio1 = Domicilio.builder()
					.calle("España")
					.numero("222")
					.localidad("Lujan")
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Serpa")
					.numero("234")
					.localidad("Maipu")
					.build();

			cliente1.agregarDomicilio(domicilio1);
			cliente2.agregarDomicilio(domicilio2);
//Creo un pedido, la factura de este pedido y el detalle del pedido. Le asigno el pedido a un cliente
//Le asigno el pedido a un detalle y a un usuario que lo prepara
			Pedido pedido1 = Pedido.builder()
					.fecha(LocalDate.now())
					.estado(Estado.INICIADO)
					.horaEstimadaEntrega(LocalTime.now())
					.total(22.5)
					.tipoEnvio(TipoEnvio.DELIVERI)
					.build();
			Factura factura1 = Factura.builder()
					.fecha(LocalDate.now())
					.total(pedido1.getTotal())
					.numero(2)
					.formasDePago(FormasDePago.EFECTIVO)
					.descuento(0)
					.build();
			pedido1.agregarFactura(factura1);
			DetallePedido detalle1 = DetallePedido.builder()
					.cant(3)
					.subtotal(5.4)
					.subtotal(2)
					.build();
			detalle1.agregarProducto(producto1);
			pedido1.agregarDetalle(detalle1);
			cliente1.agregarPedido(pedido1);
			domicilio1.agregarPedidos(pedido1);
			usuario1.agregarPedido(pedido1);
////Creo un pedido, la factura de este pedido y el detalle del pedido. Le asigno el pedido a un cliente
////Le asigno el pedido a un detalle y a un usuario que lo prepara
			Pedido pedido2 = Pedido.builder()
					.fecha(LocalDate.now())
					.estado(Estado.INICIADO)
					.horaEstimadaEntrega(LocalTime.now())
					.total(30.5)
					.tipoEnvio(TipoEnvio.DELIVERI)
					.build();
			Factura factura2 = Factura.builder()
					.fecha(LocalDate.now())
					.total(pedido1.getTotal())
					.numero(3)
					.formasDePago(FormasDePago.EFECTIVO)
					.descuento(0)
					.build();
			pedido2.agregarFactura(factura2);
			DetallePedido detalle2 = DetallePedido.builder()
					.cant(2)
					.subtotal(10.2)
					.subtotal(3)
					.build();
			detalle2.agregarProducto(producto2);
			pedido2.agregarDetalle(detalle2);
			cliente2.agregarPedido(pedido2);
			domicilio2.agregarPedidos(pedido2);
			usuario2.agregarPedido(pedido2);

//Guardo cada repositorio
			usuarioRepository.save(usuario1);
			usuarioRepository.save(usuario2);
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);
			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			pedidoRepository.save(pedido1);
			rubroRepository.save(rubro);

//A continuacion se muestan los datos de cada tabla
			System.out.println("Datos de los usuarios");
			Usuario usuarioRecuperado = usuarioRepository.findById(usuario1.getId()).orElse(null);
			if (usuarioRecuperado != null) {
				System.out.println(usuarioRecuperado.toString());
			}
			Usuario usuarioRecuperado2 = usuarioRepository.findById(usuario2.getId()).orElse(null);
			if (usuarioRecuperado2 != null) {
				System.out.println(usuarioRecuperado2.toString());
			}
			System.out.printf("Datos de los clientes");
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println(clienteRecuperado.toString());
			}
			Cliente clienteRecuperado2 = clienteRepository.findById(cliente2.getId()).orElse(null);
			if (clienteRecuperado2 != null) {
				System.out.println(clienteRecuperado2.toString());
			}

		};
	}
}