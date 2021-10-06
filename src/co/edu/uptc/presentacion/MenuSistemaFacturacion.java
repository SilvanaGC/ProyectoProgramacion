package co.edu.uptc.presentacion;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.uptc.logica.control.ControlSistemaFacturacion;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.logica.modelo.SistemaFacturacion;

public class MenuSistemaFacturacion {

	private ControlSistemaFacturacion sistemaFac;

	public MenuSistemaFacturacion() {
		sistemaFac = new ControlSistemaFacturacion();
	}

	public void MenuConsola() {

		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		while (op != 5) {
			
			encabezado();
			op = sc.nextInt();
			
			switch (op) {
			
			case 1:
				System.out.println("Hacer pedidos");
				nuevoPedido();
				break;
				
			case 2:
				mostrarListadoProductos(); 
				break;
				
			case 3:
				mostrarListadoClientes();
				break;
				
			case 4:
				mostrarInventario();
				break;
				
			case 5:
				System.out.println("Gracias por utilizar el software");
				break;
				
			default:
				
				break;
			}
			
		}

	}

	private void encabezado() {

		System.out.println("------------ Menu incial ------------");
		System.out.println("1. Pedidos");
		System.out.println("2. Facturacion");
		System.out.println("3. Inventario");
		System.out.println("4. Fabricacion");
		System.out.println("5. Mostrar Listado de productos");
		System.out.println("6. Mostrar Listado de clientes");
		System.out.println("7. Salida");

	}
	
	private void encabezadoPedidos() {

		System.out.println("------------ Pedidos ------------");
		System.out.println("1. Nuevo pedido");
		System.out.println("2. Buscar pedido");
		System.out.println("3. Atras");

	}

	private void encabezadoFacturacion() {

		System.out.println("------------Menu Facturacion------------");
		System.out.println("1. Busqueda facturas");
		System.out.println("2. Atras");

	}

	private void encabezadoInventario() {

		System.out.println("------------Menu inventario------------");
		System.out.println("1. Listar productos");
		System.out.println("2. Crear producto");
		System.out.println("3. Atras");

	}
	
	private void encabezadoFabricacion() {

		System.out.println("------------ Fabricacion productos ------------");
		System.out.println("1. Listar pedidos ");
		System.out.println("2. Nuevo pedido para fabricar");
		System.out.println("3. Atras");

	}
	
	private void datosPedidos() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el codigo del cliente");
		String codigoCliente = sc.next();

		System.out.println("Ingrese fecha ");
		String fecha = sc.next();
		
		
		
	}
	
private void nuevoPedido() {
		
		Scanner sc = new Scanner(System.in);
		String nit="", numPedido="", fecha="", codP="";
		int op = 0,cantidad = 0;
		ArrayList<Producto> productos = new ArrayList<>();
		
		System.out.println("Ingrese el nit del cliente");
		nit = sc.next();
		
		System.out.println("Numero de pedido");
		numPedido = sc.next();
		
		System.out.println("Fecha");
		fecha = sc.next();
		
		System.out.println("1. Agregar pedido 2. Cancelar");
		op = sc.nextInt();
		
		while(op != 2) {
			
			if (op == 1) {
				
				System.out.println("Ingrese codigo del producto");
				codP = sc.next();
				
				System.out.println("Ingrese cantidad del producto");
				cantidad = sc.nextInt();
				
				productos = sistemaFac.listaProductosPedido(codP, cantidad);
				
				
			}
			
		}
		
		sistemaFac.crearPedido(fecha, numPedido, codP, cantidad, nit, productos ); 
	}
	
	private void mostrarListadoProductos() {

		for (int i = 0; i < sistemaFac.ListadoProductos().size(); i++) {
			System.out.println("Nombre producto: " + sistemaFac.ListadoProductos().get(i).getNombre()
					+ "      |   Tamano producto: " + sistemaFac.ListadoProductos().get(i).getTamano()
					+ "      |   Codigo producto: " + sistemaFac.ListadoProductos().get(i).getCodigo());
		}

	}
	
	private void mostrarListadoClientes() {
		
		System.out.println("Nombre clientes ");
		for (int i = 0; i < sistemaFac.ListadoClientes().size(); i++) {
			System.out.println("Nombre cliente: " + sistemaFac.ListadoClientes().get(i).getNombreCliente()
					+ "                       |  Nit: " + sistemaFac.ListadoClientes().get(i).getNit());
		} 
		
	}
	
	private void mostrarInventario() {
		
		System.out.println("Condigo producto ");
		for (int i = 0; i < sistemaFac.ListadoInventario().size(); i++) {
			System.out.println("Condigo producto: " + sistemaFac.ListadoInventario().get(i).getProducto().getCodigo()
					+ "                       |     Stock: " + sistemaFac.ListadoInventario().get(i).getStock());
		} 
		
	}
	
		
}
