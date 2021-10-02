package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class Factura {
	
	private int numeroFactura;
	private String fecha;
	private Cliente cliente;
	
	private ArrayList<Inventario> productos;
	
	public Factura() {
		
	}
	
	public Factura(int numeroFactura, String fecha, Cliente cliente, ArrayList<Inventario> productos) {
		this.numeroFactura = numeroFactura;
		this.fecha = fecha;
		this.cliente = cliente;
		this.productos = productos;
	}
	
	public int getNumeroFactura() {
		return numeroFactura;
	}
	public void setNumeroFactura(int numeroFactura) {
		this.numeroFactura = numeroFactura;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public ArrayList<Inventario> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Inventario> productos) {
		this.productos = productos;
	}
	
	
}
