package com.animais.apianimais.model;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table(name="LT_ANIMAIS")
public class Animais  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	@Column(nullable = false)
	private String especie;
	@Column(nullable = false)
	private String raca;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private Double peso;
	@Column(nullable = false)
	private Integer idade;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private Dono dono;

	public Animais(String especie, String raca, String nome, Double peso, Integer idade) {
		this.especie = especie;
		this.raca = raca;
		this.nome = nome;
		this.peso = peso;
		this.idade = idade;
	}
	public Animais(){}

	public String getEspecie() {
		return especie;
	}

	public String getRaca() {
		return raca;
	}

	public String getNome() {
		return nome;
	}

	public Double getPeso() {
		return peso;
	}

	public Integer getIdade() {
		return idade;
	}

	public Dono getDono() {
		return dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}
}
