package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Producto;

public class FrmManteProd {

	 void listado() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		EntityManager em = fabrica.createEntityManager();
		
		String sql="Select p from Producto p";
		TypedQuery<Producto> query = em.createQuery(sql, Producto.class);
		
		List<Producto> lstProductos = query.getResultList();
		System.out.println("Cantidad de productos:" + lstProductos.size());
		
		if(lstProductos.size()==0) {
			System.out.println("Listado vacio");
		}else {
			System.out.println("Listado de usuarios tipo 1--");
			for(Producto p:lstProductos) {
				System.out.println(">>>" + p);
			}
		}
				
	}
	
}
