package co.edu.uptc.persistencia;

import java.util.ArrayList;

import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.utilidades.Archivo;

public class DAOProductos {
	
	private String RUTA = "Recursos/Productos.txt";
	
	// Set
		public void guardarProducto(Producto producto) {

			new Archivo().AgregarContenido(RUTA, producto.getCodigo() + "," + producto.getNombre() + "," + producto.getTamano() + "," + producto.getPrecio());

		}
		
		public ArrayList<Producto> mostrarDatosProducto() {
			
			// Obtener contenido de mi archivo plano
			ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

			ArrayList<Producto> listadoProductos = new ArrayList<Producto>();

			for (int i = 0; i < datos.size(); i++) {
				
				Producto p = new Producto();

				// Separo cada linea de datos en atributos
				String Linea[] = datos.get(i).split(",");
				
				p.setCodigo(Linea[0]);
				p.setNombre(Linea[1]);
				p.setTamano(Linea[2]);
				p.setPrecio(Integer.parseInt(Linea[3].replace(";", "")));

				listadoProductos.add(p);
			}

			return listadoProductos;
		}

		
}
