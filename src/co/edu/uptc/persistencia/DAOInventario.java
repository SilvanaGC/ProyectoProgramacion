package co.edu.uptc.persistencia;

import java.util.ArrayList;

import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.utilidades.Archivo;

public class DAOInventario {
	
	private String RUTA = "Recursos/Inventario.txt";
	
	// Set
		public void guardarProductoInventario(Producto p,int stock) {

			new Archivo().AgregarContenido(RUTA, p.getCodigo() + "," + stock);

		}
		
		public ArrayList<Inventario> mostrarDatosInventario() {
			
			// Obtener contenido de mi archivo plano
			ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

			ArrayList<Inventario> listadoInventario = new ArrayList<Inventario>();

			for (int i = 0; i < datos.size(); i++) {
				
				Inventario n = new Inventario();

				String Linea[] = datos.get(i).split(",");
				
				// idProducto, stock

				n.setIdProducto(Linea[0]);
				//n.setStock(Integer.parseInt(Linea[1]));

				listadoInventario.add(n);
			}

			return listadoInventario;
		}


	}
