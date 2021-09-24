package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {

	public static void main(String[] args) {
		// 1. especificar la conexi�n de BD - DAOFactory
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// 2. Obtener el DAO
		EntityManager em = fabrica.createEntityManager();

		//-- validar usando el usuario y clave
		String sql="Select u from Usuario u where u.usuario = :xusr and u.clave = :xcla";
		TypedQuery<Usuario>query3=em.createQuery(sql,Usuario.class);
		query3.setParameter("xusr", "U002@gmail.com");
		query3.setParameter("xcla", "10002");
		
		Usuario u = null;
		try {
			u=query3.getSingleResult();
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
