package posjavamavenhibernate;

import org.junit.Test;

import dao.DAOGeneric;
import model.UsuarioPessoa;

public class TesteHibernate {
	
	@Test
	public void testeHibernateUtil() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setNone("Matheus Santos");
		pessoa.setSobrenome("Sousa");
		pessoa.setIdade("12");
		pessoa.setEmail("matheus@hotmail.com");
		pessoa.setLogin("login");
		pessoa.setSenha("senha");
		
		
		dg.salvar(pessoa);
	}

}
