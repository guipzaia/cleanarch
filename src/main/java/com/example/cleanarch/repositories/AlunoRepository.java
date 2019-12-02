package com.example.cleanarch.repositories;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.cleanarch.configurations.PropertiesConfiguration;
import com.example.cleanarch.entities.Aluno;
import com.example.cleanarch.mappers.AlunoMapper;
import com.example.cleanarch.providers.CsvProvider;

@Repository
public class AlunoRepository {

	private AlunoMapper alunoMapper;
	private CsvProvider csvProvider;
	private PropertiesConfiguration properties;

	@Autowired	
	public AlunoRepository(AlunoMapper alunoMapper,
			CsvProvider csvProvider, PropertiesConfiguration properties) {
		this.alunoMapper = alunoMapper;
		this.csvProvider = csvProvider;
		this.properties = properties;
	}

	public Aluno findById(long id) throws Exception {
		return this.alunoMapper.findById(id);
	}

	@Transactional
	public int insert(Aluno aluno) throws Exception {
		return this.alunoMapper.insert(aluno);
	}

	public List<Aluno> listAll() throws Exception {
		return this.alunoMapper.listAll();
	}

	public long getMaxId() throws Exception {
		return this.alunoMapper.getMaxId();
	}
	
	public void writeCsv(List<String[]> data) throws IOException {
		String filepath = properties.getFilepath();
		csvProvider.wirteData(filepath, data);
	}
}
