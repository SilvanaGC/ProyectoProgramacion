package co.edu.uptc.logica.control;

import java.util.ArrayList;
import co.edu.uptc.logica.modelo.Cliente;
import co.edu.uptc.logica.modelo.Fabrica;
import co.edu.uptc.logica.modelo.Pedido;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.persistencia.DAOClientes;
import co.edu.uptc.persistencia.DAOPedidoFabrica;
import co.edu.uptc.persistencia.DAOPedidos;
import co.edu.uptc.persistencia.DAOProductos;

public class ControlSistemaFacturacion {

	private ArrayList<Pedido> pedidos;
	private ArrayList<Cliente> cl;
	private ArrayList<Producto> pr;
	private ArrayList<Fabrica> pedidoFabrica;
	
	private String fecha;

	public ControlSistemaFacturacion() {

		pedidos = new ArrayList<Pedido>();
		cl = new ArrayList<Cliente>();
		pr = new ArrayList<Producto>();
		pedidoFabrica = new ArrayList<Fabrica>();
		inicializarDatosProductos();
		inicializarDatosClientes();
		inicializarDatosPedidosFab();
		inicializarDatosPedido();
	}

	private void inicializarDatosClientes() {
		cl.addAll(new DAOClientes().mostrarDatosCliente());

	}

	private void inicializarDatosProductos() {
		pr.addAll(new DAOProductos().mostrarDatosProducto());
	}
	
	private void inicializarDatosPedidosFab() {
		pedidoFabrica.addAll(new DAOPedidoFabrica().mostrarDatosPedidoFab());
	}

	private void inicializarDatosPedido() {
		pedidos.addAll(new DAOPedidos().getPedidos(cl, pr));
	}

	public ArrayList<Producto> ListadoProductos() {

		return pr;

	}

	public ArrayList<Cliente> ListadoClientes() {

		return cl;

	}
	
	public ArrayList<Fabrica> ListadoPedidosFab(){
		
		return pedidoFabrica;
		
	}

	public ArrayList<Pedido> ListadoPedidos() {

		return pedidos;

	}

	public void crearProducto(String nombre, String codigo, String tamano, int precio, int stock) {

		Producto producto = new Producto();

		producto.setCodigo(codigo);
		producto.setNombre(nombre);
		producto.setTamano(tamano);
		producto.setPrecio(precio);

		ListadoProductos().add(producto);

		new DAOProductos().guardarProducto(producto);

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

		for (int i = 0; i < pedidos.size(); i++) {

			if (pedidos.get(i).getIdPedido().equals(idPedido)) {

				p = pedidos.get(i);

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

	public void adicionarPedido(Cliente a, ArrayList<Producto> b, String c, String d) {

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

	private int indiceProducto(String cod) {

		int indice = 0;
		for (int i = 0; i < ListadoProductos().size(); i++) {

			if (ListadoProductos().get(i).getCodigo().equalsIgnoreCase(cod)) {
				indice = i;
			}

		}

		return indice;

	}

	/*public void updateTXT(String cod) {

		for (int i = 0; i < ListadoProductos().size(); i++) {

			if (ListadoProductos().get(i).getCodigo().equalsIgnoreCase(cod)) {

				ListadoProductos().remove(indiceProducto(cod));

				for (int j = 0; j < ListadoProductos().size(); j++) {

					Producto p = new Producto();

					p = ListadoProductos().get(j);

					new DAOProductos().guardarProducto(p);
					// 125, Portarretrato, 30x45, 0;
				}

			}

		}

	}*/
	
	public void updateTXT(String cod) {

		for (int i = 0; i < ListadoProductos().size(); i++) {

			if (ListadoProductos().get(i).getCodigo().equalsIgnoreCase(cod)) {

				//ListadoProductos().remove(indiceProducto(cod));

				eliminarTXT();

				for (int j = 0; j < ListadoProductos().size(); j++) {

					Producto p = new Producto();

					p = ListadoProductos().get(j);

					new DAOProductos().guardarProducto(p);
					// 125, Portarretrato, 30x45, 0;
				}

			}

		}

	}

	private void eliminarTXT() {

		new DAOProductos().resetArchivo();

	}
	
	
	public int nuevoStock(int cantidad, int stock) {
		
		int newStock = 0;
		
		if(stock >= cantidad) {
			newStock = stock - cantidad;
			return newStock;
		}
		return newStock;
		
	}
	
	public void pedidoFabrica(String IdProducto, String comentarios, int cantidad) {
		
		Fabrica f = new Fabrica();
		
		f.setProducto(buscarProducto(IdProducto));
		f.setComentarios(comentarios);
		
		pedidoFabrica.add(f);
		
		new DAOPedidoFabrica().guardarProductoPedidoFab(buscarProducto(IdProducto), f);
		
		
	}
	
}
