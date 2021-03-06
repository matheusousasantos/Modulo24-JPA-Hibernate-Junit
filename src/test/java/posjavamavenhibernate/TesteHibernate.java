package posjavamavenhibernate;

import java.util.List;

import org.junit.Test;

import dao.DAOGeneric;
import model.TelefoneUser;
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
	
	@Test
	public void testeBuscar() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(2L);
		
		pessoa = dg.pesquisar(pessoa);
		
		System.out.println(pessoa);

	}
	
	
	@Test
	public void testeUpdate() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(2L);
		
		pessoa = dg.pesquisar(pessoa);
		
		System.out.println(pessoa);
		
		pessoa.setNone("Matheus Sousa Atualizado!");
		
		pessoa = dg.updateMerge(pessoa);
		
		System.out.println(pessoa);

	}
	
	@Test
	public void testeDelete() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		
		UsuarioPessoa pessoa = new UsuarioPessoa();
		
		pessoa.setId(1L);
		
		pessoa = dg.pesquisar(pessoa);
	
		dg.deletarPorId(pessoa);
		
	}
	
	@Test
	public void testeConsultar() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		
		List<UsuarioPessoa> lista = dg.listar(UsuarioPessoa.class);
		
		for (UsuarioPessoa usuarioPessoa : lista) {
			
			System.out.println(usuarioPessoa);
			System.out.println("---------------------------------");
		}
		
	}
	
	@Test
	public void testeQueryList() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> pessoas = dg.getEntityManager().createQuery("from UsuarioPessoa where none = 'Matheus Santos'").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : pessoas) {
			
			System.out.println(usuarioPessoa);
			System.out.println("-----------------------");
			
		}
		
	}
	
	@Test
	public void testeQueryListMaxResult() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> pessoas = dg.getEntityManager().createQuery("from UsuarioPessoa order by none")
				.setMaxResults(2)
				.getResultList();
		
		for (UsuarioPessoa usuarioPessoa : pessoas) {
			
			System.out.println(usuarioPessoa);
			System.out.println("-----------------------");
			
		}
		
	}
	
	@Test
	public void testQueryListParameter() {
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> lista =  dg.getEntityManager().createQuery("from UsuarioPessoa where none =:nome")
				.setParameter("nome", "Matheus Santos")
				.setParameter("sobrenome", "Sousa")
				.setMaxResults(1).getResultList();
		
		for (UsuarioPessoa usuarioPessoa : lista) {
			System.out.println(usuarioPessoa);
		}
		
	}
	
	@Test
	public void testeQuerySomaIdade() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		
		String somaIdade = (String) dg.getEntityManager()
				.createQuery("select sum(u.idade) from UsuarioPessoa u ").getSingleResult();
		
		System.out.println("Soma de todas as idades:" + somaIdade);
	}
	
	@Test
	public void testeNamedQuery1() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> pessoas = dg.getEntityManager().createNamedQuery("UsuarioPessoa.todos").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : pessoas) {
			
			System.out.println(usuarioPessoa);
			
		}
		
	}
	
	@Test
	public void testeNamedQuery2() {
		
		DAOGeneric<UsuarioPessoa> dg = new DAOGeneric<UsuarioPessoa>();
		List<UsuarioPessoa> pessoas = dg.getEntityManager().createNamedQuery("UsuarioPessoa.buscarPorNome")
				.setParameter("nome", "Matheus Santos").getResultList();
		
		for (UsuarioPessoa usuarioPessoa : pessoas) {
			
			System.out.println(usuarioPessoa);
			
		}
		
	}
	
	@Test
	public void testeGravaTelefone() {
		
		DAOGeneric dg = new DAOGeneric();
		UsuarioPessoa pessoa = (UsuarioPessoa) dg.pesquisarId(3L, UsuarioPessoa.class);
		
		TelefoneUser telefone = new TelefoneUser();
		telefone.setTipo("Casa");
		telefone.setNumero("32241645");
		telefone.setUsuarioPessoa(pessoa);
		
		dg.salvar(telefone);
		
	}
	
	@Test
	public void testeConsultarTelefones() {
		
		DAOGeneric dg = new DAOGeneric();
		UsuarioPessoa pessoa = (UsuarioPessoa) dg.pesquisarId(3L, UsuarioPessoa.class);
		
		for (TelefoneUser telefone : pessoa.getTelefones()) {
			
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
			System.out.println(telefone.getUsuarioPessoa().getNone());
			System.out.println("----------------------------------------------");

		}
		
	}

}

















