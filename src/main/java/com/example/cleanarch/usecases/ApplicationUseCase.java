package com.example.cleanarch.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.cleanarch.usecases.interfaces.IUseCase;

@Service
public class ApplicationUseCase implements IUseCase {
	
	private AlunoUseCase alunoUseCase;
	
	@Autowired
	public ApplicationUseCase(AlunoUseCase alunoUseCase) {
		this.alunoUseCase = alunoUseCase;
	}

	@Bean
	@Override
	public boolean execute() throws Exception {
		
		this.alunoUseCase.execute();
		
		return true;
	}

	
}
