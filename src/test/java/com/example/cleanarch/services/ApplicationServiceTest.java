package com.example.cleanarch.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ApplicationServiceTest {
	
	@MockBean
	AlunoService alunoService;

	@Test
	public void execute() throws Exception {
		
		// Arrange
		ApplicationService appService = new ApplicationService(alunoService);
		//Mockito.when(alunoService.execute()).thenReturn(true);
		
		// Act
		appService.execute();
		
		// Assert
		//assertTrue(retorno, "service deve retornar TRUE");
	}

}
