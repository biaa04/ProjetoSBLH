package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@Table(name = "banda")
@SequenceGenerator(name = "banda_seq", sequenceName = "banda_seq", allocationSize = 1, initialValue = 1)
public class Banda {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="banda_seq")
	private Long idbanda;
	@Column
	private String nome;
	@Column
	private String genero;
	
	public Long getIdbanda() {
		return idbanda;
	}
	public void setIdbanda(Long idbanda) {
		this.idbanda = idbanda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

}
