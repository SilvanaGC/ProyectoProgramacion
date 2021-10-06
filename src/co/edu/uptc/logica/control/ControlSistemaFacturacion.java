package co.edu.uptc.logica.control;

import java.util.ArrayList;
import co.edu.uptc.logica.modelo.Cliente;
import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.logica.modelo.Pedido;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.logica.modelo.SistemaFacturacion;
import co.edu.uptc.persistencia.DAOClientes;
import co.edu.uptc.persistencia.DAOInventario;
import co.edu.uptc.persistencia.DAOProductos;

public class ControlSistemaFacturacion {

	private SistemaFacturacion sistemaFac;

	public ControlSistemaFacturacion() {
		
		sistemaFac = new SistemaFacturacion();
		inicializarDatosClientes();
		inicializarDatosProductos();
		inicializarDatosInventarios();
	}
	
	private void inicializarDatosClientes() {
		sistemaFac.setListadoClientes(new DAOClientes().mostrarDatosCliente());
	}
	
	private void inicializarDatosProductos() {
		sistemaFac.setListadoProductos(new DAOProductos().mostrarDatosProducto());
	}
	
	private void inicializarDatosInventarios() {
		sistemaFac.setListadoInventario(new DAOInventario().mostrarDatosInventario());
	}
	
	public ArrayList<Producto> ListadoProductos() {

		return sistemaFac.getListadoProductos();

	}
	
	public ArrayList<Cliente> ListadoClientes() {

		return sistemaFac.getListadoClientes();

	}
	
	public ArrayList<Inventario> ListadoInventario() {

		return sistemaFac.getListadoInventario();

	}
	
	public ArrayList<Pedido> ListadoPedidos() {

		return sistemaFac.getListadoPedidos();

	}

	/*private void crearProducto(String nombre, String codigo, String tamano, int precio) {
		
		Producto producto = new Producto(nombre,codigo,tamano,precio);
		sistemaFac.getListadoProductos().add(producto);  
		
	}*/
	
	
	public Cliente buscarCliente(String nit) {
		
		Cliente c = new Cliente();
		
		for (int i = 0; i < ListadoClientes().size(); i++) {
			
			if (ListadoClientes().get(i).getNit().equals(nit)) {
				
				c = ListadoClientes().get(i);
				
				return c;
				
			}
			
		}
		return null;
		
		
	}
	
	public Producto buscarProducto(String codP) {
		
		Producto p = new Producto();
		
		for (int i = 0; i < ListadoProductos().size(); i++) {
			
			if (ListadoProductos().get(i).getCodigo().equals(codP)) {
				
				p = ListadoProductos().get(i);
				
				return p;
				
			}
			
		}
		return null;

	}

	public Pedido buscarPedido(String idPedido) {

		Pedido p = new Pedido();

		for (int i = 0; i < ListadoPedidos().size(); i++) {

			if (ListadoPedidos().get(i).getIdPedido().equals(idPedido)) {

				p = ListadoPedidos().get(i);

			}

		}
		return p;

	}
	
public Producto buscarProducto(String codP, int cantidad) {
		
		Producto p = new Producto();

		for (int i = 0; i < ListadoInventario().size(); i++) {
			
			if (ListadoInventario().get(i).getProducto().getCodigo().equals(codP)) {
				
				if (ListadoInventario().get(i).getStock() >= cantidad) {
					
					p = ListadoInventario().get(i).getProducto();
					
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
	
	public void crearPedido(String fecha, String IdPedido, String codP, int cantidad, String nit, ArrayList<Producto> productos) {
		
		Pedido p = new Pedido();
		
		p.setFecha(fecha);
		p.setListaProductos(productos);
		p.setIdPedido(IdPedido);
		
		Cliente c = buscarCliente(nit);
		
		c.adicionarPedido(buscarPedido(codP));
		
	}
}
