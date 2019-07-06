package posjavamavenhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	
	public static EntityManagerFactory factory = null;
	
	static { //Será chamado automaticamente 
		init();
	}
	
	private static void init() {
		
		try {
			
			if(factory == null) { //Executa somente uma vez
				
//				Será passado a unidade de pesistência
				factory = Persistence.createEntityManagerFactory("pos-java-maven-hibernate");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static EntityManager getEntityManager() { //Será retornado o gerenciador de entidades
//	Que será usado pra fazer as operações no banco de dados
		return factory.createEntityManager();
	}

}
