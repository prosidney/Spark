package br.com.spark.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name="perfis_acesso")
@NamedQueries({
	@NamedQuery(
	name = "Perfil.findById",
	query = "FROM Perfil per WHERE per.id=:id"
	),
	@NamedQuery(
	name = "Perfil.findByDesc",
	query = "FROM Perfil per WHERE per.descricao = :desc"
	)	
})
public class Perfil implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="id")
	private int id;
	
	private String descricao;
	
	@OneToMany(mappedBy="perfil")
	@Cascade({CascadeType.REMOVE})
	private Set<Usuario> usuarios;

	public Perfil() {
		super();
	}
	
	public Perfil(int id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
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
		Perfil other = (Perfil) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
