package br.com.spark.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="usuarios")
@NamedQueries({
	@NamedQuery(
	name = "Usuario.findById",
	query = "FROM Usuario us WHERE us.id=:id"
	),
	@NamedQuery(
	name = "Usuario.findByNome",
	query = "FROM Usuario us WHERE us.nome = :nome"
	),
	@NamedQuery(
	name = "Usuario.findByUsuario",
	query = "FROM Usuario us WHERE us.usuario = :usuario"
	)
})
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="id")
	private int id;
	
	private String nome;
	
	private String cargo;
	
	private String usuario;
	
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="idperfil")
	private Perfil perfil;
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	@Cascade({CascadeType.REMOVE})
	private Set<Aparelho> aparelhos;
	
	@OneToMany(mappedBy="usuario", fetch=FetchType.LAZY)
	@Cascade({CascadeType.REMOVE})
	private Set<Manutencao> manutencoes;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int id, String nome, String cargo, Perfil perfil) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargo = cargo;
		this.perfil = perfil;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Set<Aparelho> getAparelhos() {
		return aparelhos;
	}

	public void setAparelhos(Set<Aparelho> aparelhos) {
		this.aparelhos = aparelhos;
	}
	
	public Set<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(Set<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
