package br.com.spark.model;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="prevencoes")
@NamedQueries({
	@NamedQuery(
	name = "Prevencao.findById",
	query = "FROM Prevencao prev WHERE prev.id=:id"
	)
})
public class Prevencao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=AUTO)
	@Column(name="id")
	private int id;
	
    @Temporal( TemporalType.TIMESTAMP)
	Date inicio;
	
    @Temporal( TemporalType.TIMESTAMP)
	Date fim;
    
	@ManyToOne
	@JoinColumn(name="idaparelho")
	private Aparelho aparelho;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getInicio() {
		return inicio;
	}
	
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	
	public Date getFim() {
		return fim;
	}
	
	public void setFim(Date fim) {
		this.fim = fim;
	}
	
	public Aparelho getAparelho() {
		return aparelho;
	}
	
	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}
	
	public Integer duracaoTotal(){
		if(this.fim == null){
			return null;
		}
		
		Calendar gcInicio = GregorianCalendar.getInstance();
		gcInicio.setTime(this.inicio);
		
		Calendar gcFim = GregorianCalendar.getInstance();
		gcFim.setTime(this.fim);
		
		int duracao = 0;
		while (gcInicio.before(gcFim)){
			gcInicio.add(Calendar.HOUR, 1);
			duracao++;
		}
		
		return duracao;
	}
}
