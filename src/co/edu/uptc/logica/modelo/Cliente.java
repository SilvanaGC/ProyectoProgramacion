package co.edu.uptc.logica.modelo;

public class Cliente {
	
	private String nombreCliente;
	private String nit;
	private String telefono;
	
	public Cliente() {
		
	}
	
	public Cliente(String nombreCliente, String nit, String telefono) {
		this.nombreCliente = nombreCliente;
		this.nit = nit;
		this.telefono = telefono;
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
	
}
