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

	private void crearProducto(String nombre, String codigo, String tamano, int precio) {
		
		Producto producto = new Producto(nombre,codigo,tamano,precio);
		sistemaFac.getListadoProductos().add(producto);  
		
	}
	
	private Producto buscarProducto(String codProducto, int cantidad){
		
		Producto p = new Producto();
		
		for (int i = 0; i < ListadoProductos().size(); i++) {
			
			if(ListadoProductos().get(i).getCodigo().equals(codProducto)){ 
					
				revisionInventario(codProducto,cantidad);
				
					p = ListadoProductos().get(i);
					
					return p;
				
			}
			
		}
		return null;
		
	}
	
	private void revisionInventario(String codProducto,int cantidad) {
		
		for (int i = 0; i < ListadoInventario().size(); i++) {
			
			if (ListadoInventario().get(i).getIdProducto().equalsIgnoreCase(codProducto)) {
				
				if (ListadoInventario().get(i).getStock() >= cantidad) {
					
					int stock = ListadoInventario().get(i).getStock();
					stock = stock - cantidad;
				}
				
			}
			
		}
		
	}
	
	public Cliente buscarCliente(String nit) {
		
		Cliente c = new Cliente();
		
		for (int i = 0; i < ListadoClientes().size(); i++) {
			
			if (ListadoClientes().get(i).getNit().equals(nit)) {
				
				c = ListadoClientes().get(i);
				
			}
			
		}
		return c;
		
		
	}
	
	public Producto buscarProducto(String idProducto) {
		
		Producto p = new Producto();
		
		for (int i = 0; i < ListadoProductos().size(); i++) {
			
			if (ListadoProductos().get(i).getCodigo().equals(idProducto)) {
				
				p = ListadoProductos().get(i);
				
			}
			
		}
		return p;
		
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
	
	public int indicePedido(String id) {
		
		int indice = 0;
		
		for (int i = 0; i < ListadoPedidos().size() ; i++) {
			
			if (ListadoPedidos().get(i).getIdPedido().equals(id)) {
				indice = i; 
			}
			
		}
		
		return indice;
		
	}
	
	public void adicionarProducto(String idPedido, String idProducto) {
		
		Pedido p = buscarPedido(idPedido);
		
		p.adicionarProductos(buscarProducto(idProducto));
		ListadoPedidos().set(indicePedido(idPedido), p);
		
		
		
	}
	
	private void crearPedido(String Idcliente, String fecha) {
		
		ArrayList<Producto> listaProductos;
		int idPedido; 
		
	}
	
	
}
