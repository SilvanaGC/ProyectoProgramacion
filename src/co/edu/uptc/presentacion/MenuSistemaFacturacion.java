package co.edu.uptc.presentacion;

import java.util.Scanner;

import co.edu.uptc.logica.control.ControlSistemaFacturacion;

public class MenuSistemaFacturacion {

	private ControlSistemaFacturacion sistemaFac;

	public MenuSistemaFacturacion() {
		sistemaFac = new ControlSistemaFacturacion();
	}

	public void MenuConsola() {

		int opc = 0;
		Scanner sc = new Scanner(System.in);

		while (opc != 5) {
			encabezado();
			opc = sc.nextInt();

			// Menu principal
			switch (opc) {

			case 1:
				System.out.println("1. Clientes");
				mostrarListadoClientes();
				break;

			case 2:
				System.out.println("2. Facturacion");

				encabezadoFacturacion();

				int opc1 = sc.nextInt();

				// Menu de facturacion
				switch (opc1) {

				case 1:
					System.out.println("1. Crear factura");
					break;

				default:

					break;
				}

				break;

			case 3:

				System.out.println("3. Inventario");
				encabezadoInventario();
				int opc2 = sc.nextInt();
				
				//Menu Inventario
				switch (opc2) {

				case 1:
					System.out.println("1. Listado productos");
					mostrarListadoProductos();
					break;

				case 2:
					System.out.println("2. Listado Inventario");
					mostrarListadoInventario();
					break;

				default:

					break;
				}

				break;

			case 4:
				System.out.println("4. Fabricacion");
				break;

			case 5:
				System.out.println("Gracias por usar nuestro sofware");
				break;
			default:
				break;
			}

		}

	}

	private void encabezado() {

		System.out.println("Menu incial");
		System.out.println("1. Pedidos");
		System.out.println("2. Facturacion");
		System.out.println("3. Inventario");
		System.out.println("4. Fabricacion");
		System.out.println("5. Salida");

	}

	private void encabezadoFacturacion() {

		System.out.println("Menu Facturacion");
		System.out.println("1. Crear factura");
		System.out.println("2. Editar factura");
		System.out.println("3. Busqueda facturas");
		System.out.println("4. Atras");

	}

	private void encabezadoInventario() {

		System.out.println("Menu inventario");
		System.out.println("1. Listar productos");
		System.out.println("2. Crear producto");
		System.out.println("3. Atras");

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
	
	private void mostrarListadoInventario() {

		for (int i = 0; i < sistemaFac.ListadoInventario().size(); i++) {
			System.out.println(sistemaFac.ListadoInventario().get(i).getProducto().getNombre());

		}
	}
		
}
