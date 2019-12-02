package com.example.cleanarch.entities;

public class Aluno {

	private long id;
	private int rm;
	private String nome;
	private short idade;
	
	public Aluno(long id, int rm, String nome, short idade) {
		this.id = id;
		this.rm = rm;
		this.nome = nome;
		this.idade = idade;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getRm() {
		return rm;
	}
	
	public void setRm(int rm) {
		this.rm = rm;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public short getIdade() {
		return idade;
	}

	public void setIdade(short idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {		
		return new StringBuilder(
					this.id + ";" +
					this.rm + ";" +
					this.nome + ";" +
					this.idade
				).toString();
	}
}
