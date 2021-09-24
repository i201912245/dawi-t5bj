package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Usuario;

public class Demo09 {

	public static void main(String[] args) {
		// 1. especificar la conexión de BD - DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// 2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();

		//-- validar usando el usuario y clave
		String sql="{call usp_validaAcceso (:xusr, :xcla)}";
		
		Query query3 = em.createNativeQuery(sql, Usuario.class);
		query3.setParameter("xusr", "U002@gmail.com");
		query3.setParameter("xcla", "10002");
		
		Usuario u = null;
		try {
			u = (Usuario) query3.getSingleResult();
		}catch(NoResultException e){
			
		}
		
		if (u == null) {
			System.out.println("Usuario NO existe");
		} else {
			System.out.println("Usuario encontrado : " + u.getNombre());
			System.out.println(u);
		}
		
		em.close();

	}
}
