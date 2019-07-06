package posjavamavenhibernate;

import javax.persistence.EntityManager;

import org.junit.Test;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		
		EntityManager em = HibernateUtil.getEntityManager();
		
	}

}
