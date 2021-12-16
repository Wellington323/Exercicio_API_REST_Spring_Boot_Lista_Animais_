package com.animais.apianimais.model;

import java.util.List; 

import javax.persistence.*;

@Entity
@Table(name="TB_DONOS")
public class Dono {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String apelido;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String cpf;
	@Column(nullable = false)
	private Integer idade;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private String endereco;
	@Column(nullable = false)
	private String bairro;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private String estado;

	@OneToMany(mappedBy = "dono", cascade = CascadeType.ALL)
	private List<Animais> animais;

	public Dono(String nome, String apelido, String email, String cpf, Integer idade, String telefone, String endereco, String bairro, String cidade, String estado) {
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.cpf = cpf;
		this.idade = idade;
		this.telefone = telefone;
		this.endereco = endereco;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Dono(){}

	public Long getId() {
		return Id;
	}

	public String getNome() {
		return nome;
	}

	public String getApelido() {
		return apelido;
	}

	public String getEmail() {
		return email;
	}

	public String getCpf() {
		return cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public List<Animais> getAnimais() {
		return animais;
	}
}
