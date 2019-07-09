package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.junit.Test;

import model.UsuarioPessoa;
import posjavamavenhibernate.HibernateUtil;

public class DAOGeneric<E> { // Pode ser qualquer letra

	private EntityManager entityManager = HibernateUtil.getEntityManager();

	public void salvar(E entidade) {

		EntityTransaction transation = entityManager.getTransaction();
		transation.begin();
		entityManager.persist(entidade);
		transation.commit();
	}

	public E pesquisar(E entidade) {

		Object id = HibernateUtil.getPrimaryKey(entidade);
		E e = (E) entityManager.find(entidade.getClass(), id);
		return e;

	}

	public E updateMerge(E entidade) {

		EntityTransaction transation = entityManager.getTransaction();
		transation.begin();
		E entidadeSalva = entityManager.merge(entidade);
		transation.commit();
		
		return entidadeSalva;
	}
	
	public void deletarPorId(E entidade) {
		Object id = HibernateUtil.getPrimaryKey(entidade);
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		entityManager.createNativeQuery("delete from " 
		+ entidade.getClass().getSimpleName().toLowerCase() + " where id=" + id).executeUpdate(); 
		transaction.commit(); //Grava a alteração
		
	}
	
	
	public List<E> listar(Class<E> entidade) {
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		List<E> lista = entityManager.createQuery("from " + entidade.getName()).getResultList();
		
//		Seria o mesmo de "from UsuarioPesssoa"
		
		transaction.commit();
		
		return lista;
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	

}

