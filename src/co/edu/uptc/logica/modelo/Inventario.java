package co.edu.uptc.logica.modelo;

public class Inventario {
	
	private String idProducto;
	private int stock;
	
	public Inventario() {
		
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
}
