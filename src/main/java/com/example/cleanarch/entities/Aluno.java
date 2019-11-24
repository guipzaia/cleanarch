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

	@Override
	public String toString() {		
		return new StringBuilder(
					this.id + ", " +
					this.rm + ", " +
					this.nome + ", " +
					this.idade
				).toString();
	}
}
