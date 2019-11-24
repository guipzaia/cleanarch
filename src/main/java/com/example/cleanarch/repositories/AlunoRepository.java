package com.example.cleanarch.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.cleanarch.entities.Aluno;
import com.example.cleanarch.mappers.AlunoMapper;

@Repository
public class AlunoRepository {

	@Autowired
	private AlunoMapper alunoMapper;
	
	public AlunoRepository(AlunoMapper alunoMapper) {
		this.alunoMapper = alunoMapper;
	}

	public Aluno findById(long id) {
		return this.alunoMapper.findById(id);
	}

	@Transactional
	public int insert(Aluno aluno) {		
		return this.alunoMapper.insert(aluno);
	}

	public List<Aluno> listAll() {
		return this.alunoMapper.listAll();
	}

	public long getMaxId() {
		return this.alunoMapper.getMaxId();
	}
}
