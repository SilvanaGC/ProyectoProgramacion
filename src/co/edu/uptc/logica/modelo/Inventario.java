package co.edu.uptc.logica.modelo;

public class Inventario {
	
	private int stock;
	private int cantidadPedida;
	private Producto producto;
	
	public Inventario() {
		
	}

	public Inventario(int stock, int cantidadPedida, Producto producto) {
		this.stock = stock;
		this.cantidadPedida = cantidadPedida;
		this.producto = producto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getCantidadPedida() {
		return cantidadPedida;
	}

	public void setCantidadPedida(int cantidadPedida) {
		this.cantidadPedida = cantidadPedida;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
