package app.proyecto.SistemaBancario.ser;


import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import app.proyecto.SistemaBancario.Utils.Respuesta;
import app.proyecto.SistemaBancario.Utils.Trans;
import app.proyecto.SistemaBancario.negocio.TransaccionON;
import ec.edu.ups.appdis.g1.negocio.ProductoON;
@Path("serv")
public class ClienteServiceRest {

	@Inject
	ProductoON on;
	
	@POST
	@Path("/actualizar")
	@Produces("application/json")
	@Consumes("application/json")
	
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
	
	@POST
	@Path("/deposito")
	@Produces("application/json")
	@Consumes("application/json")
	
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
	
	
	@POST
	@Path("/retiro")
	@Produces("application/json")
	@Consumes("application/json")
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
