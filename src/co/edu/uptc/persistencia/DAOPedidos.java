package co.edu.uptc.persistencia;

import java.util.ArrayList;

import co.edu.uptc.logica.modelo.Cliente;
import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.logica.modelo.Pedido;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.logica.modelo.SistemaFacturacion;
import co.edu.uptc.utilidades.Archivo;

public class DAOPedidos {
	
	private String RUTA = "Recursos/Pedidos.txt";

	// Set
	public void registroPersona(Pedido p, Cliente c) {
		
		/*String idProducto = "" ;
		String cantidad = "";
		
		for (int i = 0; i < p.getListaProductos().size(); i++) {
			idProducto = p.getListaProductos().get(i).getCodigo();
			cantidad = String.valueOf(p.getListaProductos().get(i).getCantidad());
		}*/

		new Archivo().AgregarContenido(RUTA, p.getIdPedido() + "," + 
												c.getNit() + "," + 
												p.getFecha() + "," + 
												p.getListaProductos());

	}
	
	public ArrayList<Pedido> getPedidos(int cantidad) {
		
		ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

		ArrayList<Pedido> listadoPedidos = new ArrayList<Pedido>();
		

		for (int i = 0; i < datos.size(); i++) {
			
			Pedido p = new Pedido();

			String Linea[] = datos.get(i).split(",");
			
			//IdPedido,IdCliente, IDpRODUCTO, FECHA
			
			p.setIdPedido(Linea[0]);
			p.setListaProductos(listaProductosPedido(Linea[1], cantidad));
			p.setFecha(Linea[3].replace(";", ""));
			

			listadoPedidos.add(p);
		}

		return listadoPedidos;
	}
	
	public Producto buscarProducto(String codP, int cantidad) {

		SistemaFacturacion sistema = new SistemaFacturacion();
		
		ArrayList<Producto> producto = sistema.getListadoProductos();
		ArrayList<Inventario> inventario = sistema.getListadoInventario();

		Producto p = new Producto();

		for (int i = 0; i < inventario.size(); i++) {

			if (inventario.get(i).getIdProducto().equals(codP)) {

				if (inventario.get(i).getStock() >= cantidad) {

					p = producto.get(i);

					return p;

				}

			}

		}

		return null;

	}
	
	
	public ArrayList<Producto> listaProductosPedido(String codP, int cantidad) {

		ArrayList<Producto> productos = new ArrayList<Producto>();

		productos.add(buscarProducto(codP, cantidad));

		return productos;

	}

}
