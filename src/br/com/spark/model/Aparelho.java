package br.com.spark.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="aparelhos")
@NamedQueries({
	@NamedQuery(
	name = "Aparelho.findById",
	query = "FROM Aparelho apar WHERE apar.id=:id"
	),
	@NamedQuery(
	name = "Aparelho.findByNome",
	query = "FROM Aparelho apar WHERE apar.nome = :nome"
	)	
})
public class Aparelho implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="id")
	private int id;
	
	private String nome;
	
    @Column(name="num_chassi")
	private String numChassi;
	
	private String marca;
	
	private String modelo;
	
    @Temporal( TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern="dd/MM/yyyy HH:mm")
    @Column(name="dt_inclusao")
	private Date dtInclusao;
    
    @Column(name="situacao_atual")
	private String situacaoAtual;
	
	@ManyToOne
	@JoinColumn(name="idusuario")
	private Usuario usuario;
	
	@OneToMany(mappedBy="aparelho")
	@Cascade({CascadeType.ALL})
	private Set<Manutencao> manutencoes;
	
	@OneToMany(mappedBy="aparelho")
	@Cascade({CascadeType.ALL})
	private Set<Prevencao> prevencoes;

	public Aparelho() {
		super();
	}
	
	public Aparelho(int id, String nome, String numChassi, String marca,
			String modelo, Date dtInclusão, String situacaoAtual) {
		super();
		this.id = id;
		this.nome = nome;
		this.numChassi = numChassi;
		this.marca = marca;
		this.modelo = modelo;
		this.dtInclusao = dtInclusão;
		this.situacaoAtual = situacaoAtual;
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
	public String getNumChassi() {
		return numChassi;
	}
	public void setNumChassi(String numChassi) {
		this.numChassi = numChassi;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getDtInclusao() {
		return dtInclusao;
	}
	public void setDtInclusao(Date dtInclusão) {
		this.dtInclusao = dtInclusão;
	}
	public String getSituacaoAtual() {
		return situacaoAtual;
	}
	public void setSituacaoAtual(String situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Manutencao> getManutencoes() {
		return manutencoes;
	}

	public void setManutencoes(Set<Manutencao> manutencoes) {
		this.manutencoes = manutencoes;
	}

	public Set<Prevencao> getPrevencoes() {
		return prevencoes;
	}

	public void setPrevencoes(Set<Prevencao> prevencoes) {
		this.prevencoes = prevencoes;
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
		Aparelho other = (Aparelho) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}
