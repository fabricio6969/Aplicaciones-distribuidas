package ec.edu.ups.appdis.g1.DAO;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.appdis.g1.entidad.Producto;

@Stateless
public class ProductoDAO {
	
	
	@PersistenceContext
	private EntityManager em;
	
	
	public void crearCuenta(Producto producto) {
		this.em.persist(producto);
		
	}
	
	
	public void actualizarProducto(Producto producto) {
		em.merge(producto);
	}
	
	
	public List<Producto> mostrarProducto() {
		String jpql = "SELECT a FROM Cuenta a";
		Query query = em.createQuery(jpql, Producto.class);
		List<Producto> producto = query.getResultList();
		
		return producto;
	}
	
	
	public Producto buscarProductoID(int id) {
		Producto prod= new Producto();
		try {
			String jpql = "SELECT l FROM Cuenta l where l.id = :id";
			Query query = em.createQuery(jpql, Producto.class);
			query.setParameter("id", id);
			prod = (Producto) query.getSingleResult();
		} catch (Exception e) {
			prod=null;
		}
		
		return prod;
	}
	
	
	public Producto buscarProducto(int id) {
		Producto prod = em.find(Producto.class, id);
		System.out.println(prod.getId());
		return em.find(Producto.class, id);
	}

}
