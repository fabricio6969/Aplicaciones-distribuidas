package ec.edu.ups.edu.appdis.g1.modelo;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Trans implements Serializable {
	private static final long serialVersionUID = 1L;
	private Double monto;
	private String tipoProducto;
	private int codigoProducto;
	
	public Double getMonto() {
		return monto;
	}


	public int getCodigoProducto() {
		return codigoProducto;
	}


	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}


	public void setMonto(Double monto) {
		this.monto = monto;
	}


	public String getTipoProducto() {
		return tipoProducto;
	}


	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	@Override
	public String toString() {
		return "Trans [monto=" + monto + ", tipoProducto=" + tipoProducto + ", codigoProducto=" + codigoProducto + "]";
	}
}
