package co.edu.uptc.logica.modelo;

import java.util.ArrayList;

public class Cliente {
	
	private String nombreCliente;
	private String nit;
	private String telefono;
	private ArrayList<Pedido> pedidos;
	
	public Cliente(){
		pedidos = new ArrayList<>();
	}
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public ArrayList<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public void adicionarPedido(Pedido p) {
		pedidos.add(p);
	}
	
}
