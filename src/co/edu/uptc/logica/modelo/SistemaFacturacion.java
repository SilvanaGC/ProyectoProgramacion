package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class SistemaFacturacion {
	
	private ArrayList<Producto> listadoProductos;
	private ArrayList<Cliente> listadoClientes;
	private ArrayList<Inventario> listadoInventario;
	
	public ArrayList<Producto> getListadoProductos() {
		return listadoProductos;
	}
	public void setListadoProductos(ArrayList<Producto> listadoProductos) {
		this.listadoProductos = listadoProductos;
	}
	public ArrayList<Cliente> getListadoClientes() {
		return listadoClientes;
	}
	public void setListadoClientes(ArrayList<Cliente> listadoClientes) {
		this.listadoClientes = listadoClientes;
	}
	public ArrayList<Inventario> getListadoInventario() {
		return listadoInventario;
	}
	public void setListadoInventario(ArrayList<Inventario> listadoInventario) {
		this.listadoInventario = listadoInventario;
	}
	
	

}
