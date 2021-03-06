package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity

@NamedQueries ({
	@NamedQuery(name = "UsuarioPessoa.todos", query = "select u from UsuarioPessoa u"),
	@NamedQuery(name = "UsuarioPessoa.buscarPorNome", query = "select c from UsuarioPessoa c where c.none = :nome")
})

public class UsuarioPessoa {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private Long id;
	
	private String none;
	private String sobrenome;
	private String email;
	private String login;
	private String senha;
	private String idade;
	
	@OneToMany(mappedBy = "usuarioPessoa")
	private List<TelefoneUser> telefones;
	
	
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNone() {
		return none;
	}
	public void setNone(String none) {
		this.none = none;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<TelefoneUser> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneUser> telefones) {
		this.telefones = telefones;
	}
	@Override
	public String toString() {
		return "UsuarioPessoa [id=" + id + ", none=" + none + ", sobrenome=" + sobrenome + ", email=" + email
				+ ", login=" + login + ", senha=" + senha + ", idade=" + idade + "]";
	}
	
}
