package com.example.cleanarch.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cleanarch.entities.Aluno;
import com.example.cleanarch.repositories.AlunoRepository;
import com.example.cleanarch.usecases.interfaces.IUseCase;

@Service
public class AlunoUseCase implements IUseCase {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public AlunoUseCase(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public boolean execute() throws Exception {
		
		// Selecionar o Maior Id
		long maxId = this.getMaxId();
		
		// Inserir novo aluno
		if (this.insert(maxId) < 1) return false;
		
		// Listar todos os alunos
		List<Aluno> alunos = this.listAll();
		
		// Imprimir alunos
		this.printList(alunos);
		
		return true;
	}
	
	public long getMaxId() {
		return this.alunoRepository.getMaxId();
	}
	
	public int insert(long maxId) {
		Aluno novoAluno = new Aluno(maxId + 1, 555555, "Fulano de Tal", (short) 30);		
		return this.alunoRepository.insert(novoAluno);
	}
	
	public List<Aluno> listAll() {
		return this.alunoRepository.listAll();
	}
	
	public void printList(List<Aluno> alunos) {
		for (Aluno aluno : alunos) {
			System.out.println(aluno.toString());
		}
	}

}
