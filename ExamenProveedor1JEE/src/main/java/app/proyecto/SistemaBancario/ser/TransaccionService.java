package app.proyecto.SistemaBancario.ser;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import app.proyecto.SistemaBancario.Utils.Respuesta;
import app.proyecto.SistemaBancario.Utils.Trans;
import app.proyecto.SistemaBancario.negocio.TransaccionON;

@WebService
public class TransaccionService {
	@Inject
	TransaccionON on;
	
	@WebMethod
	public Respuesta transacciones( Trans trx) {
		Respuesta r = new Respuesta();
		try {
			r = on.transaccionSoap(trx);
		} catch (Exception e) {
		e.printStackTrace();
		r.setCodigo(99);
		r.setMensaje(e.getMessage());
		}
		return r;
	}
	@WebMethod
	public Respuesta deposito( Trans trx) {
		Respuesta r = new Respuesta();
		try {
			r = on.depositoSoap(trx);
		} catch (Exception e) {
		e.printStackTrace();
		r.setCodigo(99);
		r.setMensaje(e.getMessage());
		}
		return r;
	}
	@WebMethod
	public Respuesta retiro( Trans trx) {
		Respuesta r = new Respuesta();
		try {
			r = on.retiroSoap(trx);
		} catch (Exception e) {
		e.printStackTrace();
		r.setCodigo(99);
		r.setMensaje(e.getMessage());
		}
		return r;
	}
}
