package com.example.cleanarch.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cleanarch.entities.Aluno;
import com.example.cleanarch.repositories.AlunoRepository;
import com.example.cleanarch.services.interfaces.IService;

@Service
public class AlunoService implements IService {
	
	private AlunoRepository alunoRepository;
	
	@Autowired
	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Override
	public void execute() throws Exception {
		
		// Selecionar o Maior Id
		long maxId = this.getMaxId();
		
		// Gera novo Id
		long newId = this.generateNewId(maxId);
		
		// Gera Rm
		int rm = this.generateRm();
		
		// Cria novo aluno
		Aluno novoAluno = this.generateAluno(newId, rm, "Aluno " + newId, (short) 18);
		
		// Inserir novo aluno
		this.insert(novoAluno);
		
		// Listar todos os alunos
		List<Aluno> alunos = this.listAll();
		
		// Converter dados para formato CSV
		List<String[]> alunosCsv = this.convertToCsvData(alunos);
		
		// Gravar arquivo CSV
		this.writeCsv(alunosCsv);
	}
	
	public long getMaxId() throws Exception {
		return this.alunoRepository.getMaxId();
	}
	
	public long generateNewId(long maxId) {
		return maxId + 1;
	}
	
	public int generateRm() {
		
		int min = 100000;
		int max = 999999;
		
		return (int) ((Math.random() * ((max - min) + 1)) + min);
	}
	
	public Aluno generateAluno(long id, int rm, String nome, short idade) {
		return new Aluno(id, rm, "Aluno " + id, idade);
	}
	
	public int insert(Aluno novoAluno) throws Exception {
		return this.alunoRepository.insert(novoAluno);
	}
	
	public List<Aluno> listAll() throws Exception {
		return this.alunoRepository.listAll();
	}
	
	public List<String[]> convertToCsvData(List<Aluno> lista) {
		
		List<String[]> csvList = new ArrayList<>();

		String[] header = new String[] {"id", "rm", "nome", "idade"};
		
		csvList.add(header);
		
		for (Aluno aluno : lista) {
			
			String[] strList = {
                    String.valueOf(aluno.getId()),
                    String.valueOf(aluno.getRm()),
                    aluno.getNome(),
                    String.valueOf(aluno.getIdade())
			};
			
			csvList.add(strList);
		}
		
		return csvList;
	}
	
	public void writeCsv(List<String[]> data) throws IOException {
		this.alunoRepository.writeCsv(data);
	}
}
