package co.edu.uptc.persistencia;

import java.util.ArrayList;
import co.edu.uptc.logica.modelo.Cliente;
import co.edu.uptc.utilidades.Archivo;

public class DAOClientes {

	private String RUTA = "Recursos/Clientes.txt";

	// Set
	public void guardarCliente(Cliente cliente) {

		new Archivo().AgregarContenido(RUTA,
				cliente.getNombreCliente() + "," + cliente.getNit() + "," + cliente.getTelefono());

	}

	public ArrayList<Cliente> mostrarDatosCliente() {

		// Obtener contenido de mi archivo plano
		ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

		ArrayList<Cliente> listadoClientes = new ArrayList<Cliente>();

		for (int i = 0; i < datos.size(); i++) {

			Cliente c = new Cliente();

			// Separo cada linea de datos en atributos
			String Linea[] = datos.get(i).split(",");

			c.setNombreCliente(Linea[0]);
			c.setNit(Linea[1]);
			//c.setTelefono(Linea[2]);  

			listadoClientes.add(c);
		}

		return listadoClientes;
	}

}
