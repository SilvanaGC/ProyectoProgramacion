package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class SistemaFacturacion {
	
	private ArrayList<Producto> listadoProductos;
	private ArrayList<Cliente> listadoClientes;
	private ArrayList<Pedido> listadoPedidos;
	private ArrayList<Factura> listadoFacturas;
	
	public SistemaFacturacion() {
		listadoProductos = new ArrayList<Producto>();
		listadoClientes = new ArrayList<Cliente>();
		listadoPedidos = new ArrayList<Pedido>();
		listadoFacturas = new ArrayList<Factura>();
	}
	
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
	public ArrayList<Pedido> getListadoPedidos() {
		return listadoPedidos;
	}
	public void setListadoPedidos(ArrayList<Pedido> listadoPedidos) {
		this.listadoPedidos = listadoPedidos;
	}
	public ArrayList<Factura> getListadoFacturas() {
		return listadoFacturas;
	}
	public void setListadoFacturas(ArrayList<Factura> listadoFacturas) {
		this.listadoFacturas = listadoFacturas;
	}
	
	

}
