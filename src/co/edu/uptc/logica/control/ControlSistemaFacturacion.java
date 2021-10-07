package co.edu.uptc.logica.control;

import java.util.ArrayList;
import co.edu.uptc.logica.modelo.Cliente;
import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.logica.modelo.Pedido;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.logica.modelo.SistemaFacturacion;
import co.edu.uptc.persistencia.DAOClientes;
import co.edu.uptc.persistencia.DAOInventario;
import co.edu.uptc.persistencia.DAOPedidos;
import co.edu.uptc.persistencia.DAOProductos;

public class ControlSistemaFacturacion {

	private ArrayList<Pedido> pedidos;
	private ArrayList<Cliente> cl;
	private ArrayList<Producto> pr;
	
	private String fecha;

	

	public ControlSistemaFacturacion() {
		
		pedidos = new ArrayList<Pedido>();
		cl = new ArrayList<Cliente>();
		pr = new ArrayList<Producto>();
		inicializarDatosProductos();
		inicializarDatosClientes();
		//inicializarDatosInventarios();
		inicializarDatosPedido();
	}
	
	private void inicializarDatosClientes() {
		cl.addAll(new DAOClientes().mostrarDatosCliente());
		
	}
	
	private void inicializarDatosProductos() {
		pr.addAll(new DAOProductos().mostrarDatosProducto());
	}
	
	/*private void inicializarDatosInventarios() {
		sistemaFac.setListadoInventario(new DAOInventario().mostrarDatosInventario());
	}*/
	
	private void inicializarDatosPedido() {
		pedidos.addAll(new DAOPedidos().getPedidos(cl, pr));
	}
	
	public ArrayList<Producto> ListadoProductos() {

		return pr;

	}
	
	public ArrayList<Cliente> ListadoClientes() {

		return cl;

	}
	
	/*public ArrayList<Inventario> ListadoInventario() {

		return sistemaFac.getListadoInventario();

	}*/
	
	public ArrayList<Pedido> ListadoPedidos() {

		return pedidos;

	}

	private int indicePedido(String IdPedido) {
		int indice = 0;
		for (int i = 0; i < ListadoPedidos().size(); i++) {

			if (ListadoPedidos().get(i).getIdPedido().equals(IdPedido)) {
				indice = i;
			}

		}
		return indice;
	}

	private int indiceCliente(String nit) {

		int indice = 0;
		for (int i = 0; i < ListadoClientes().size(); i++) {

			if (ListadoClientes().get(i).getNit().equals(nit)) {
				indice = i;
			}

		}
		return indice;
	}

	public void crearProducto(String nombre, String codigo, String tamano, int precio, int stock) {
		
		Producto producto = new Producto();
		
		producto.setCodigo(codigo);
		producto.setNombre(nombre);
		producto.setTamano(tamano);
		producto.setPrecio(precio);
		
		ListadoProductos().add(producto);
		
		
		new DAOProductos().guardarProducto(producto);
		new DAOInventario().guardarProductoInventario(producto, stock);
	
	}
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
				
				return p;

			}

		}
		return null;

	}
	
public Producto buscarProducto(String codP, int cantidad) {
		
		Producto p = new Producto();

		
		return null;

	}

	public ArrayList<Producto> listaProductosPedido(String codP, int cantidad) {

		ArrayList<Producto> productos = new ArrayList<Producto>();

		productos.add(buscarProducto(codP, cantidad));

		return productos;

	}
	
	public Pedido crearPedido(String fecha, String IdPedido, String codP, int cantidad, ArrayList<Producto> productos) {
		
		Pedido p = new Pedido();
		
		p.setFecha(fecha);
		p.setListaProductos(productos);
		p.setIdPedido(IdPedido);
		
		return p;
		
	}
	
	public void adicionarPedido(Cliente a, ArrayList<Producto> b, String c, String d){
		
		Pedido p = new Pedido();
		
		p.setCliente(a);
		p.setListaProductos(b);
		p.setFecha(c);
		p.setIdPedido(d);
		
		pedidos.add(p);
		
		
		UpdatePedidos(p);
		
		
	}
	
	public void UpdatePedidos(Pedido p) {
		new DAOPedidos().registroPersona(p);
		
		inicializarDatosPedido();
	}
}
