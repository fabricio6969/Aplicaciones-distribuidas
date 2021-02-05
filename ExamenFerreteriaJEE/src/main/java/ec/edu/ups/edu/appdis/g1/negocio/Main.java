package ec.edu.ups.edu.appdis.g1.negocio;

import java.util.List;

import ec.edu.ups.edu.appdis.g1.modelo.Trans;


public class Main {

	public static void main(String args[]) {
		
		Trans trans = new Trans();
		trans.setMonto(2);
		trans.setTipoProducto;(30.0);
		trans.setTipo("transferencia");
		
		Trans deposito = new Trans();
		deposito.setCuentadestino(1);
		deposito.setMonto(10.0);
		deposito.setTipo("deposito");
		
		Trans retiro = new Trans();
		retiro.setCuentadestino(2);
		retiro.setMonto(50.0);
		retiro.setTipo("retiro");	
		
		TransCli cli = new TransCli();
		
		Respuesta respuesta = cli.saveCategogira(trans);
		Respuesta respuesta1 = cli.saveDeposito(deposito);
		Respuesta respuesta2 = cli.saveRetiro(retiro);
		System.out.println(trans.toString());
		System.out.println(respuesta);
		System.out.println(deposito.toString());
		System.out.println(respuesta1);
		System.out.println(retiro.toString());
		System.out.println(respuesta2);
	}
}
