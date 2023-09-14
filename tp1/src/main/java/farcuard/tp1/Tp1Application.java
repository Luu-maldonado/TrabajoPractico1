package farcuard.tp1;

import farcuard.tp1.entidades.*;
import farcuard.tp1.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.Date;

@SpringBootApplication
public class Tp1Application {
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;

	private Instant localDate;


	public static void main(String[] args) {
		SpringApplication.run(Tp1Application.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean
	CommandLineRunner init() {

		return args -> {
			System.out.println("---ESTOY FUNCIONANDO---");
			//domicilios

			Domicilio domicilio1 = Domicilio.builder()
					.calle("calle1")
					.localidad("localidad1")
					.numero(111)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("calle2")
					.numero(222)
					.localidad("localidad2")
					.build();
			//cliente

			Cliente cliente1 = Cliente.builder()
					.nombre("nombre1")
					.apellido("apellido1")
					.telefono(11111111)
					.email("nombre1apellido1@gmail.com")
					.build();

			//pedidos
			Pedido pedido1 = Pedido.builder()
					.fecha(Date.from(localDate.now()))
					.total(235)
					.estado("iniciado")
					.tipoEnvio("Delivery")
					.build();

			//detallePedido
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(111)
					.build();

			//factura
			Factura factura1= Factura.builder()
					.numero(1)
					.total(2526)
					.descuento(12)
					.fecha(Date.from(localDate.now()))
					.build();

			Producto producto1 = Producto.builder()
					.precioCompra(254)
					.tipo("insumo")
					.receta("balba")
					.tiempoEstimadoCcina(25)
					.precioVenta(300)
					.stockActual(25)
					.stockMinimo(10)
					.denominacion("denominacion1")
					.unidadMedida("kg")
					.build();

			Rubro rubro1 = Rubro.builder()
					.denominacion("denominacion1")
					.build();



			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			clienteRepository.save(cliente1);
			pedido1.agregarDetallePedido(detallePedido1);
			pedidoRepository.save(pedido1);
			cliente1.agregarPedido(pedido1);
			pedido1.setFactura(factura1);
			facturaRepository.save(factura1);
			rubro1.agregarProducto(producto1);
			rubroRepository.save(rubro1);
			detallePedido1.setProducto(producto1);

		};



	}







}

















