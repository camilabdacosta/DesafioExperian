package com.desafio.desafioExperian.config;

import java.util.Arrays;

import com.desafio.desafioExperian.dominio.Consulta;
import com.desafio.desafioExperian.repositorio.RepositorioConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

	// injecao do RepositorioConsulta para fazer operacoes com o  banco de dados
	@Autowired
	private RepositorioConsulta repoTaxa;
	
	@Override
	public void run(String... args) throws Exception {

		Consulta teste1 = new Consulta(null, "Pedro","Sao Paulo", "(xx) xxxxx-xxxx","SP",20,100);
		Consulta teste2 = new Consulta(null, "Joao","Sao Paulo", "(xx) xxxxx-xxxx","SP",20,100);
		Consulta teste3 = new Consulta(null, "Maria","Sao Paulo", "(xx) xxxxx-xxxx","SP",20,100);

		repoTaxa.saveAll(Arrays.asList(teste1,teste2,teste3));
	}

}
