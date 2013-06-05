package br.com.spark.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="manutencoes")
@NamedQueries({
	@NamedQuery(
	name = "Manutencao.findById",
	query = "FROM Manutencao manut WHERE manut.id=:id"
	),
	@NamedQuery(
	name = "Manutencao.findByDesc",
	query = "FROM Manutencao manut WHERE manut.descricao = :desc"
	)	
})
public class Manutencao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="id")
	private int id;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="idaparelho")
	private Aparelho aparelho;
	
	public Manutencao() {
		super();
	}
	
	public Manutencao(int id, String descricao, Usuario usuario,
			Aparelho aparelho) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.usuario = usuario;
		this.aparelho = aparelho;
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
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Aparelho getAparelho() {
		return aparelho;
	}
	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
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
		Manutencao other = (Manutencao) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
