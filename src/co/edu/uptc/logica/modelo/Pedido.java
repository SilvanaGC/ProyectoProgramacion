package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class Pedido {
	
	private Cliente cliente;
	private String fecha;
	private String telefono;
	private int cantidad;
	
	private ArrayList<Inventario> listaProductos;
	
	public Pedido() {
		
	}
	
	public Pedido(Cliente cliente, String fecha, String telefono, int cantidad, ArrayList<Inventario> listaProductos) {
		this.cliente = cliente;
		this.fecha = fecha;
		this.telefono = telefono;
		this.cantidad = cantidad;
		this.listaProductos = listaProductos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ArrayList<Inventario> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Inventario> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	
}
