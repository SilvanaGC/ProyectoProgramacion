package co.edu.uptc.persistencia;

import java.util.ArrayList;
import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.utilidades.Archivo;

public class DAOInventario {
	
	private String RUTA = "Recursos/Inventario.txt";
	
	// Set
		public void guardarProducto(Inventario inventario) {

			new Archivo().AgregarContenido(RUTA, inventario.getCantidadPedida()  + "," + inventario.getStock() + "," + inventario.getProducto() + "," + inventario.getProducto());

		}
		
		public ArrayList<Inventario> mostrarDatosProducto() {
			
			// Obtener contenido de mi archivo plano
			ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

			ArrayList<Inventario> listadoInventario = new ArrayList<Inventario>();

			for (int i = 0; i < datos.size(); i++) {
				
				Producto p = new Producto();
				Inventario n = new Inventario();

				// Separo cada linea de datos en atributos
				String Linea[] = datos.get(i).split(",");
				
				p.setNombre(Linea[0]);
				p.setCodigo(Linea[1]);
				p.setTamano(Linea[2]);
				//p.setPrecio(Integer.parseInt(Linea[3]));
				n.setProducto(p);
				//n.setStock(Integer.parseInt(Linea[4]));
				//n.setCantidadPedida(Integer.parseInt(Linea[5].replace(";", "")));

				listadoInventario.add(n);
			}

			return listadoInventario;
		}

}
