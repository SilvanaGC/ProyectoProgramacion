package co.edu.uptc.persistencia;

import java.util.ArrayList;

import co.edu.uptc.logica.control.ControlSistemaFacturacion;
import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.utilidades.Archivo;

public class DAOInventario {
	
	private String RUTA = "Recursos/Inventario.txt";
	
	// Set
		public void guardarProductoInventario(Inventario inventario) {

			new Archivo().AgregarContenido(RUTA, inventario.getProducto().getCodigo() + "," + inventario.getStock());

		}
		
		public ArrayList<Inventario> mostrarDatosInventario() {
			
			// Obtener contenido de mi archivo plano
			ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

			ArrayList<Inventario> listadoInventario = new ArrayList<Inventario>();
			
			ControlSistemaFacturacion control = new ControlSistemaFacturacion();

			for (int i = 0; i < datos.size(); i++) {
				
				Inventario n = new Inventario();

				String Linea[] = datos.get(i).split(",");
				
				//idProducto, stock
				
				n.setProducto(control.buscarProducto(Linea[0]));
				n.setStock(Integer.parseInt(Linea[1].replace(";", "")));

				listadoInventario.add(n);
			}

			return listadoInventario;
		}
		
		

}
