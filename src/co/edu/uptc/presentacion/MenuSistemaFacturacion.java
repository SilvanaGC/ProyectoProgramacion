package co.edu.uptc.presentacion;

import java.util.Scanner;

import co.edu.uptc.logica.control.ControlSistemaFacturacion;
import co.edu.uptc.logica.modelo.SistemaFacturacion;

public class MenuSistemaFacturacion {

	private ControlSistemaFacturacion sistemaFac;

	public MenuSistemaFacturacion() {
		sistemaFac = new ControlSistemaFacturacion();
	}

	public void MenuConsola() {

		int opc = 0, op = 0;
		Scanner sc = new Scanner(System.in);

		while (opc != 7) {
			encabezado();
			opc = sc.nextInt();

			// Menu principal
			switch (opc) {
			
			//Opcion 1 de Pedidos
			case 1:
				
				System.out.println("1. Pedidos");
				
				encabezadoPedidos();
				op = sc.nextInt();
				
				// Menu opciones de pedidos
				
				switch (op) {
				
				case 1:
					
					System.out.println("1. Nuevo pedido");
					
					break;

				case 2:
					
					System.out.println("2. Buscar pedido");
					
					break;
					
				case 3:
					
					break;
					
				default:
					
					break;
				}
				
				break;

			// Opcion 2 de Facturacion		
			case 2:
				
				System.out.println("2. Facturacion");
				
				encabezadoFacturacion();
				op = sc.nextInt();
				
				// Menu de facturacion 
				switch (op) {
				
				case 1:
					
					System.out.println("1. Buscar factura");
					
					break;

				case 2:
					
					break;
					
				default:
					
					break;
				}
				
				break;

			//Opcion 3 de inventraio
			case 3:
				
				System.out.println("3. Inventario");
				
				encabezadoInventario();
				op = sc.nextInt();
				
				// Menu de inventario
				switch (op) {
				
				case 1:
					
					System.out.println("1. Listar productos");
					
					break;

				case 2:
					
					System.out.println("2. Crear producto");
					
					break;
					
				case 3:
					
					break;
					
				default:
					
					break;
				}
				
				break;

			case 4:
				
				System.out.println("4. Fabricacion");
				
				encabezadoFabricacion();
				op = sc.nextInt();
				
				// Menu de fabircacion 
				switch (op) {
				
				case 1:
					
					System.out.println("1. Listar pedidos ");
					
					break;

				case 2:
					
					System.out.println("2. Nuevo pedido para fabricar");
					
					break;
					
				case 3:
					
					break;
					
				default:
					
					break;
				}
				
				break;

			case 5:
				
				System.out.println("------ Listado Productos ------");
				mostrarListadoProductos();
				
				break;
				
			case 6:
				
				System.out.println("-------- Listado Clientes ------");
				mostrarListadoClientes();
				
				break;
			case 7:
				
				System.out.println("Gracias por usar nuestro sofware");
				
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
	
	private void datosProductoPedido() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Ingrese el codigo del producto");
		String codigoProducto = sc.next();
			
		System.out.println("Ingrese cantidad del producto");
		int cantidad = sc.nextInt();
		
		
	}
	
	private void mostrarListadoProductos() {
		
		for (int i = 0; i < sistemaFac.ListadoProductos().size(); i++) {
			System.out.println("Nombre producto: "+ sistemaFac.ListadoProductos().get(i).getNombre() + "Tamano producto: " + sistemaFac.ListadoProductos().get(i).getTamano());
		} 
		
	}
	
	private void mostrarListadoClientes() {
		System.out.println("Nombre clientes ");
		for (int i = 0; i < sistemaFac.ListadoClientes().size(); i++) {
			System.out.println(sistemaFac.ListadoClientes().get(i).getNombreCliente());
		} 
		
	}
	
		
}
