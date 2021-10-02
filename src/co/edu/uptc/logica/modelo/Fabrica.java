package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class Fabrica {
	
	private String IDProducto;
	private String nombreProducto; 
	private int cantidad;
	private String comentarios;
	
	private ArrayList<Producto> productos;
	
	public Fabrica() {
		
	}
	
	public Fabrica(String iDProducto, String nombreProducto, int cantidad, String comentarios,
			ArrayList<Producto> productos) {
		IDProducto = iDProducto;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.comentarios = comentarios;
		this.productos = productos;
	}
	
	public String getIDProducto() {
		return IDProducto;
	}

	public void setIDProducto(String iDProducto) {
		IDProducto = iDProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
