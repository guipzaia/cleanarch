package com.example.cleanarch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.example.cleanarch.services.interfaces.IService;

@Service
public class ApplicationService implements IService {
	
	private AlunoService alunoService;
	
	@Autowired
	public ApplicationService(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@Override
	public void execute() throws Exception {
		
		this.alunoService.execute();
	}

	
}
