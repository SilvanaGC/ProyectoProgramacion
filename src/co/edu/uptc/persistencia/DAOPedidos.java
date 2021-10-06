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

		new Archivo().AgregarContenido(RUTA, p.getIdPedido() + "," + p.getListaProductos() + "," + p.getIdPedido() + "," + p.getFecha());

	}
	
	public ArrayList<Pedido> mostrarDatosPedidos() {
		
		ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

		ArrayList<Pedido> listadoPedidos = new ArrayList<Pedido>();
		
		ControlSistemaFacturacion conSisFac = new ControlSistemaFacturacion();

		for (int i = 0; i < datos.size(); i++) {
			
			Pedido p = new Pedido();

			String Linea[] = datos.get(i).split(",");
			
			//IdPedido,IdCliente, IDpRODUCTO, FECHA
			
			p.setIdPedido(Linea[0]);
			//p.setListaProductos(null);
			p.setFecha(Linea[3].replace(";", ""));
			

			listadoPedidos.add(p);
		}

		return listadoPedidos;
	}

}
