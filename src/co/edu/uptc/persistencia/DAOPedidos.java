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
	public void registroPersona(Pedido p) {
		
		String productos="";
		
		for (int i = 0; i < p.getListaProductos().size() ; i++) {
			productos = productos +(","+p.getListaProductos().get(i).getCodigo()+","+p.getListaProductos().get(i).getCantidad());
		}

		new Archivo().AgregarContenido(RUTA, p.getIdPedido()+","+p.getCliente().getNit()+","+p.getFecha()+productos);

	}
	
	public ArrayList<Pedido> getPedidos(ArrayList<Cliente> a,ArrayList<Producto> b) {
		
		ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

		ArrayList<Pedido> listadoPedidos = new ArrayList<Pedido>();
		

		for (int i = 0; i < datos.size(); i++) {
			
			if(datos.size()>1) {
			Pedido p = new Pedido();
			ArrayList<Producto> productrray = new ArrayList<Producto>();
			Cliente client = new Cliente();
			Producto product = new Producto();
			String[] Linea = datos.get(i).split(",");
			
			//IdPedido,IdCliente, IDpRODUCTO, FECHA
			
			p.setIdPedido(Linea[0]);
			for(int f=0; f<a.size();f++) {
				
				if(a.get(f).getNit().equals(Linea[1])) {
					client = a.get(f);
				}
			}
			p.setCliente(client);
			
			p.setFecha(Linea[2]);
			int conteo =0;
			for(int j = 0 ; j<Linea.length;j++) {
				conteo= j+3;
			if(conteo < Linea.length) {
					
				
				for(int g=0; g<b.size();g++) {
					
					if(b.get(g).getCodigo().equals(Linea[conteo])) {
						product = b.get(g);
						Linea[conteo+1].replace(";", "");
						product.setCantidad(Integer.parseInt(Linea[conteo+1]));
						productrray.add(product);
					}
				}
				
			}
			p.setListaProductos(productrray);
			listadoPedidos.add(p);
			}
		}
		}
		return listadoPedidos;
	}
	
	public Producto buscarProducto(String codP) {

		SistemaFacturacion sistema = new SistemaFacturacion();
		
		ArrayList<Producto> producto = sistema.getListadoProductos();

		Producto p = new Producto();

		for (int i = 0; i < producto.size(); i++) {

			if (producto.get(i).getCodigo().equals(codP)) {

					p = producto.get(i);

					return p;

			}

		}

		return null;

	}
	 
	
	
	public ArrayList<Producto> listaProductosPedido(String codP) {

		ArrayList<Producto> productos = new ArrayList<Producto>();

		productos.add(buscarProducto(codP));

		return productos;

	}

}
