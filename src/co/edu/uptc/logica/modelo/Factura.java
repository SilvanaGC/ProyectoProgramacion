package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class Factura {
	
	private int numeroFactura;
	private String fecha;
	private Cliente cliente;
	
	private ArrayList<Producto> productos;
	
	public Factura() {
		productos = new ArrayList<Producto>();
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
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
}
