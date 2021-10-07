package co.edu.uptc.persistencia;

import java.util.ArrayList;

import co.edu.uptc.logica.modelo.Fabrica;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.logica.modelo.SistemaFacturacion;
import co.edu.uptc.utilidades.Archivo;

public class DAOPedidoFabrica {
	
	private String RUTA = "Recursos/PedidosFabricacion.txt";
	
	// Set
		public void guardarProductoPedidoFab(Producto p, Fabrica f) {

			new Archivo().AgregarContenido(RUTA, p.getCodigo() + "," + f.getCantidad() + "," + f.getComentarios() );

		}
		
		public ArrayList<Fabrica> mostrarDatosPedidoFab() {
			
			// Obtener contenido de mi archivo plano
			ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

			ArrayList<Fabrica> listadoPedidosFabricar = new ArrayList<Fabrica>();

			for (int i = 0; i < datos.size(); i++) {
				
				Fabrica f = new Fabrica();

				String Linea[] = datos.get(i).split(",");
				
				f.setProducto(buscarProducto(Linea[0]));
				//f.setCantidad(Integer.parseInt(Linea[1]));
				f.setComentarios(Linea[2]);

				listadoPedidosFabricar.add(f);
			}

			return listadoPedidosFabricar;
		}
		
		public Producto buscarProducto(String codP) {
			
			SistemaFacturacion s = new SistemaFacturacion();
			
			ArrayList<Producto> productos =  s.getListadoProductos();
			Producto p = new Producto();

			for (int i = 0; i < productos.size(); i++) {

				if (productos.get(i).getCodigo().equals(codP)) {

					p = productos.get(i);

					return p;

				}

			}
			return null;

		}
		

}
