package ec.edu.ups.edu.appdis.g1.negocio;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import model.Respuesta;
import model.Trans;

public class TransCli {
	
	private String WS_SAVE_CATEGORIA = "http://localhost:8080/SistemaBancario/ws/serv/transferir";
	private String WS_SAVE_DEPOSITO = "http://localhost:8080/SistemaBancario/ws/serv/deposito";
	private String WS_SAVE_RETIRO = "http://localhost:8080/SistemaBancario/ws/serv/retiro";
	
	public Respuesta saveCategogira(Trans trans) {
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_SAVE_CATEGORIA);
		Respuesta respuesta = target.request().post(Entity.json(trans), Respuesta.class);
			
		return respuesta;
	}
	
	public Respuesta saveDeposito(Trans trans) {
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_SAVE_DEPOSITO);
		Respuesta respuesta = target.request().post(Entity.json(trans), Respuesta.class);
			
		return respuesta;
	}
	public Respuesta saveRetiro(Trans trans) {	
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_SAVE_RETIRO);
		Respuesta respuesta = target.request().post(Entity.json(trans), Respuesta.class);
			
		return respuesta;
	}
	
	
	
}
