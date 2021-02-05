package app.proyecto.SistemaBancario.Utils;

import java.io.Serializable;

public class Trans implements Serializable {
	private int id;
	private Double cantidad;
	private String tipoProducto;
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Trans [id=" + id + ", cantidad=" + cantidad + ", tipoProducto=" + tipoProducto + "]";
	}

	
	
}
