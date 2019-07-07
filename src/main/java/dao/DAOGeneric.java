package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

public class DAOGeneric<E> { //Pode ser qualquer letra

	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void salvar(E entidade) {
		
		EntityTransaction transation = entityManager.getTransaction();
		transation.begin();
		entityManager.persist(entidade);
		transation.commit();
	}
	
}
