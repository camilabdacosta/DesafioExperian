package com.desafio.desafioExperian.repositorio;

import java.util.List;

import com.desafio.desafioExperian.dominio.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface RepositorioConsulta extends MongoRepository<Consulta,String>{
	 
	List<Consulta> findByNomeContaining(String nome);

}

