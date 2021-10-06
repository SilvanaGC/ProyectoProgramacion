package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class Fabrica {
	
	private String IDProducto;
	private int cantidad;
	private String comentarios;
	private ArrayList<Producto> productos;
	
	public String getIDProducto() {
		return IDProducto;
	}

	public void setIDProducto(String iDProducto) {
		IDProducto = iDProducto;
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
