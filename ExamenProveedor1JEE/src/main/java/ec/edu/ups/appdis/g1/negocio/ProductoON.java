package ec.edu.ups.appdis.g1.negocio;

import java.util.Date;

import javax.ejb.Stateless;
import javax.inject.Inject;

import app.proyecto.SistemaBancario.Entidades.Cuenta;
import app.proyecto.SistemaBancario.Entidades.Transaccion;
import app.proyecto.SistemaBancario.Utils.Respuesta;
import app.proyecto.SistemaBancario.Utils.Trans;
import ec.edu.ups.appdis.g1.DAO.ProductoDAO;
import ec.edu.ups.appdis.g1.entidad.Producto;

@Stateless
public class ProductoON {
	
	@Inject
	private  ProductoDAO producto;
	

	public Respuesta actualizar(Trans trx) throws Exception {

		Respuesta res = null;
	   Producto origen = producto.buscarProductoID(trx.getId()) ;

		if (trx.getTipo().equals("transferencia")) {
			if (destino == null)
				throw new Exception("La cuentas no existe");
			if (trx.getCuentaorigen() !=0 && trx.getCuentadestino() != 0) {			
				Double saldoOri = origen.getSaldo() - trx.getMonto();
				Double saldoDes = destino.getSaldo() + trx.getMonto();
				origen.setSaldo(saldoOri);
				destino.setSaldo(saldoDes);

				Transaccion tOri = new Transaccion();
				tOri.setCuent(trx.getCuentaorigen());
				tOri.setFechaRegistro(new Date());
				tOri.setTipo("transferencia");
				tOri.setMonto(trx.getMonto());

				Transaccion tDes = new Transaccion();

				tDes.setCuent(trx.getCuentadestino());
				tDes.setFechaRegistro(new Date());
				tDes.setTipo("transferencia");
				tDes.setMonto(trx.getMonto());

				origen.addTransaccion(tOri);
				destino.addTransaccion(tDes);
				
				transacciondao.crearTransaccion(tOri);
				transacciondao.crearTransaccion(tDes);
				cuentaDao.actualizarCuenta(origen);
				cuentaDao.actualizarCuenta(destino);

				/*List<CuentaAhorro> cuentas = cuentaDao.getCuentas(origen.getNumeroCuenta(), destino.getNumeroCuenta());

				for (CuentaAhorro cs : cuentas) {
					System.out.println(cs.toString());
				}*/
				res = new Respuesta();
				res.setCodigo(1);
				res.setMensaje("Ok");
				System.out.println(res.getMensaje());
				//res.setCuentasafectadas(cuentas);
			}
		}
		return res;
	}

}
