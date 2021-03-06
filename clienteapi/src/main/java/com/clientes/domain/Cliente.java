package com.clientes.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Cliente {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "AVISO: O campo não pode ser vazio.")
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonInclude(Include.NON_NULL)
	private Date data_nascimento;
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "cliente")
	private List<Endereco> enderecos;
	
	@JsonInclude(Include.NON_NULL)
	private String telefone;
	
	@JsonInclude(Include.NON_NULL)
	private String sexo;
	
	public Long getId() {
		return id;
	}
	
	//construtor
	public Cliente() {
		
	}
	
	//construtor alternativo
	public Cliente(String nome) {
		this.nome = nome;
	}
	
	//gets and sets
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
