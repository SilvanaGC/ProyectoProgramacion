package co.edu.uptc.persistencia;

import java.util.ArrayList;

import co.edu.uptc.logica.control.ControlSistemaFacturacion;
import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.logica.modelo.Pedido;
import co.edu.uptc.utilidades.Archivo;

public class DAOPedidos {
	
	private String RUTA = "Recursos/Pedidos.txt";

	// Set
	public void guardarPersona(Pedido p) {

		new Archivo().AgregarContenido(RUTA, p.getCliente() + "," + p.getListaProductos() + "," + p.getIdPedido() + "," + p.getFecha());

	}
	
	public ArrayList<Pedido> mostrarDatosPedidos() {
		
		// Obtener contenido de mi archivo plano
		ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

		ArrayList<Pedido> listadoPedidos = new ArrayList<Pedido>();
		
		ControlSistemaFacturacion conSisFac = new ControlSistemaFacturacion();

		for (int i = 0; i < datos.size(); i++) {
			
			Pedido p = new Pedido();

			// Separo cada linea de datos en atributos
			String Linea[] = datos.get(i).split(",");
			
			p.setIdPedido(Linea[0]);
			p.setCliente(conSisFac.buscarCliente(Linea[1]));
			//p.setListaProductos(conSisFac.buscarProducto(Linea[2]));
			p.setFecha(Linea[3]);
			//p.setCantidad(Integer.parseInt(Linea[4].replace(";", "")));
			
			//p.setIdProducto(Linea[0]);
			//p.setStock(Integer.parseInt(Linea[1].replace(";", "")));

			listadoPedidos.add(p);
		}

		return listadoPedidos;
	}

}
