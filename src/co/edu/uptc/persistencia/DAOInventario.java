package co.edu.uptc.persistencia;

import java.util.ArrayList;
import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.utilidades.Archivo;

public class DAOInventario {
	
	private String RUTA = "Recursos/Inventario.txt";
	
	// Set
		public void guardarProductoInventario(Inventario inventario) {

			new Archivo().AgregarContenido(RUTA, inventario.getIdProducto() + "," + inventario.getStock());

		}
		
		public ArrayList<Inventario> mostrarDatosInventario() {
			
			// Obtener contenido de mi archivo plano
			ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

			ArrayList<Inventario> listadoInventario = new ArrayList<Inventario>();

			for (int i = 0; i < datos.size(); i++) {
				
				Inventario n = new Inventario();

				// Separo cada linea de datos en atributos
				String Linea[] = datos.get(i).split(",");
				
				n.setIdProducto(Linea[0]);
				//n.setStock(Integer.parseInt(Linea[1].replace(";", "")));

				listadoInventario.add(n);
			}

			return listadoInventario;
		}
		
		

}
