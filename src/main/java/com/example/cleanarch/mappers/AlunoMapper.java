package com.example.cleanarch.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.cleanarch.entities.Aluno;

@Mapper
public interface AlunoMapper {

	@Select("SELECT ID, RM, NOME, IDADE FROM ALUNO WHERE ID = #{id}")
	public Aluno findById(long id);
	
	@Select("SELECT ID, RM, NOME, IDADE FROM ALUNO")
	public List<Aluno> listAll();
	
	@Select("SELECT MAX(ID) FROM ALUNO")
	public long getMaxId();
	
	@Insert("INSERT INTO ALUNO(ID, RM, NOME, IDADE) VALUES(#{id}, #{rm}, #{nome}, #{idade})")
	public int insert(Aluno aluno);
}
