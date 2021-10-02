package co.edu.uptc.logica.control;

import java.util.ArrayList;

import co.edu.uptc.logica.modelo.Cliente;
import co.edu.uptc.logica.modelo.Inventario;
import co.edu.uptc.logica.modelo.Producto;
import co.edu.uptc.logica.modelo.SistemaFacturacion;
import co.edu.uptc.persistencia.DAOClientes;
import co.edu.uptc.persistencia.DAOInventario;
import co.edu.uptc.persistencia.DAOProductos;

public class ControlSistemaFacturacion {

	private SistemaFacturacion sistemaFac;

	public ControlSistemaFacturacion() {
		sistemaFac = new SistemaFacturacion();
		inicializarDatosClientes();
		inicializarDatosProductos();
		inicializarDatosInventarios();
	}
	
	private void inicializarDatosClientes() {
		sistemaFac.setListadoClientes(new DAOClientes().mostrarDatosCliente());
	}
	
	private void inicializarDatosProductos() {
		sistemaFac.setListadoProductos(new DAOProductos().mostrarDatosProducto());
	}
	
	private void inicializarDatosInventarios() {
		sistemaFac.setListadoInventario(new DAOInventario().mostrarDatosProducto());
	}
	
	public ArrayList<Producto> ListadoProductos() {

		return sistemaFac.getListadoProductos();

	}
	
	public ArrayList<Cliente> ListadoClientes() {

		return sistemaFac.getListadoClientes();

	}
	
	public ArrayList<Inventario> ListadoInventario() {

		return sistemaFac.getListadoInventario();

	}

	private void crearProducto(String nombre, String codigo, String tamano, int precio) {
		
		Producto producto = new Producto(nombre,codigo,tamano,precio);
		sistemaFac.getListadoProductos().add(producto);  
		
	}

	private void crearFactura() {

	}
	
	
}
