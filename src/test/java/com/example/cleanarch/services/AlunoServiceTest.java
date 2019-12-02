package com.example.cleanarch.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.cleanarch.entities.Aluno;
import com.example.cleanarch.repositories.AlunoRepository;

@RunWith(SpringRunner.class)
public class AlunoServiceTest {
	
	@MockBean
	AlunoRepository alunoRepository;
	
	AlunoService alunoService;
	
	@Before
	public void configure() {
		this.alunoService = new AlunoService(alunoRepository);
	}

	@Test
	public void getMaxId() throws Exception {
		
		// Arrange		
		long arragedMaxId = 100;		
		Mockito.when(alunoRepository.getMaxId()).thenReturn(arragedMaxId);
		
		// Act
		long maxId = alunoService.getMaxId();
		
		// Assert
		assertEquals(arragedMaxId, maxId);
	}
	
	@Test
	public void insert() throws Exception {
		
		// Arrange
		int arrangedInsertedRows = 1;
		Aluno aluno1 = new Aluno((long) 101, 555555, "Fulano de Tal", (short) 30);
		
		Mockito.when(alunoRepository.insert(aluno1)).thenReturn(arrangedInsertedRows);
		
		// Act
		int insertedRows = alunoService.insert(aluno1);
		
		// Assert
		assertEquals(arrangedInsertedRows, insertedRows);
	}
	
	@Test
	public void listAll() throws Exception {
		
		// Arrange
		Aluno aluno1 = new Aluno((long) 1, 123456, "Aluno 1", (short) 20);
		Aluno aluno2 = new Aluno((long) 2, 654321, "Aluno 2", (short) 25);
		
		List<Aluno> arragedAlunos = new ArrayList<>();
		arragedAlunos.add(aluno1);
		arragedAlunos.add(aluno2);
		
		Mockito.when(alunoRepository.listAll()).thenReturn(arragedAlunos);
		
		// Act
		List<Aluno> alunos = alunoService.listAll();
		
		// Assert
		assertEquals(arragedAlunos, alunos);
	}
}
