package co.edu.uptc.presentacion;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import co.edu.uptc.logica.control.ControlSistemaFacturacion;
import co.edu.uptc.logica.modelo.Cliente;
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

		while (op != 7) {

			encabezado();
			op = sc.nextInt();

			switch (op) {

			case 1:

				int opc = 0;

				do {
					encabezadoPedidos();
					opc = sc.nextInt();

					switch (opc) {

					case 1:
						System.out.println("1. Nuevo pedido");
						nuevoPedido();
						break;

					case 2:
						System.out.println("2. Busqueda de pedidos");
						mostrarPedido();
						break;

					case 3:
						System.out.println("3. Atras");
						break;

					default:
						break;
					}

				} while (opc != 3);

				break;

			case 2:
				// mostrarListadoProductos();
				break;

			case 3:

				int opcion = 0;

				do {

					encabezadoInventario();
					opcion = sc.nextInt();

					switch (opcion) {

					case 1:
						System.out.println("1. Listar productos del inventario");
						//mostrarInventario();
						break;

					case 2:
						System.out.println("2. Nuevo producto para el inventario");
						nuevoProducto();
						break;

					case 3:
						System.out.println("3. Atras");
						break;

					default:
						break;
					}

				} while (opcion != 3);

				break;

			case 4:
				
				int opcion2 = 0;

				do {
					encabezadoFabricacion();
					opcion2 = sc.nextInt();

					switch (opcion2) {

					case 1:
						System.out.println("1. Listar pedidos ");
						//mostrarListadoPedidos();
						break;

					case 2:
						System.out.println("2. Nuevo pedido para fabricar");
						
						break;

					case 3:
						System.out.println("3. Atras");
						break;

					default:
						break;
					}

				} while (opcion2 != 3);
				
				break;

			case 5:
				System.out.println("Productos");
				mostrarListadoProductos();
				break;

			case 6:
				System.out.println("Mostrar pedidos");
				mostrarListadoPedidos();
				break;

			case 7:
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
		System.out.println("1. Listar inventario");
		System.out.println("2. Ingresar nuevo producto");
		System.out.println("3. Atras");

	}

	private void encabezadoFabricacion() {

		System.out.println("------------ Fabricacion productos ------------");
		System.out.println("1. Listar pedidos ");
		System.out.println("2. Nuevo pedido para fabricar");
		System.out.println("3. Atras");

	}

	private void nuevoPedido() {

		Scanner sc = new Scanner(System.in);
		String nit = "", numPedido = "", fecha = "", codP = "";
		int op = 0, cantidad = 0;
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Cliente client = new Cliente();
		Producto product = new Producto();
		
		boolean answ=false;
		do {
			System.out.println("Ingrese el nit del cliente");
			nit = sc.next();
			for(int i=0; i<sistemaFac.ListadoClientes().size();i++) {
				if(sistemaFac.ListadoClientes().get(i).getNit().equals(nit)) {
					answ = false;
					client = sistemaFac.ListadoClientes().get(i);
				}
				else {
					//System.out.println("CLIENTE NO EN LA DATABASE");
					
				}
			}
		}
		while(answ);
		answ=false;
		System.out.println("Numero de pedido");
		numPedido = sc.next();

		System.out.println("Fecha");
		fecha = sc.next();
	
		do {

			System.out.println("1. Agregar producto 2. Cancelar");
			op = sc.nextInt();

			if (op == 1) {

				
				
				do {
					System.out.println("Ingrese codigo del producto");
					codP = sc.next();
					System.out.println("Ingrese cantidad del producto");
					cantidad = sc.nextInt();
					for(int i=0; i<sistemaFac.ListadoProductos().size();i++) {
						if(sistemaFac.ListadoProductos().get(i).getCodigo().equals(codP)) {
							answ = false;
							product = sistemaFac.ListadoProductos().get(i);
							product.setCantidad(cantidad);
							productos.add(product);
							
						}
						else {
							//System.out.println("CODIGO NO EN LA DATABASE");
							
						}
					}
				}while(answ);

				
				
				

			}

		} while (op != 2);

		//SISTEMA DE AUTENTICIDAD DE DATOS
		sistemaFac.adicionarPedido(client, productos, fecha, numPedido);
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
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 10; j++) {
			
						
			}
		}

	}

	/*private void mostrarInventario() {

		System.out.println("Condigo producto ");
		for (int i = 0; i < sistemaFac.ListadoInventario().size(); i++) {
			System.out.println("Condigo producto: " + sistemaFac.ListadoInventario().get(i).getIdProducto()
					+ "                       |     Stock: " + sistemaFac.ListadoInventario().get(i).getStock());
		}

	}*/
	
	private void mostrarListadoPedidos() {
		System.out.println("LISTADO DE PEDIDOS GONORREA OME");
		for (int i = 0; i < sistemaFac.ListadoPedidos().size(); i++) {
			System.out.println("Id pedido: " + sistemaFac.ListadoPedidos().get(i).getIdPedido()
					+"\n Nombre del cliente: " + sistemaFac.ListadoPedidos().get(i).getCliente().getNombreCliente() 
					+"\n Fecha pedido: " + sistemaFac.ListadoPedidos().get(i).getFecha());
			
			
			for(int j = 0; j<sistemaFac.ListadoPedidos().get(i).getListaProductos().size();j++) {
				System.out.println("PRODUCTOS PEDIDOS POR CLIENTE");
				System.out.println(sistemaFac.ListadoPedidos().get(i).getListaProductos().size());
				System.out.println("PRODUCTO : "+sistemaFac.ListadoPedidos().get(i).getListaProductos().get(j).getNombre());
				System.out.println("CANTIDAD : "+sistemaFac.ListadoPedidos().get(i).getListaProductos().get(j).getCantidad());
			}
			
		}

	}

	private void mostrarPedido() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Ingrese codigo del pedido");
		String codPedido = sc.next();

		System.out.println(sistemaFac.buscarPedido(codPedido));

	}

	private void nuevoProducto() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Condigo del producto");
		String codProducto = sc.next();

		System.out.println("Nombre del nuevo producto");
		String nombre = sc.next();

		System.out.println("Tamaño del producto");
		String tamano = sc.next();

		System.out.println("Precio del producto");
		int precio = sc.nextInt();

		System.out.println("Stock del producto");
		int stock = sc.nextInt();

		sistemaFac.crearProducto(nombre, codProducto, tamano, precio, stock);

	}

}
