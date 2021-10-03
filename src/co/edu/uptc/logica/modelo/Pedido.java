package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class Pedido {
	
	private Cliente cliente;
	private ArrayList<Producto> listaProductos;
	private String fecha;
	private String idPedido;
	
	public Pedido() {
		listaProductos = new ArrayList<>();
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
	
	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void adicionarProductos(Producto p) {
		 listaProductos.add(p);
	}
	
	
}
