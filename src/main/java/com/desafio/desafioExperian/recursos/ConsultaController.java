package com.desafio.desafioExperian.recursos;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import com.desafio.desafioExperian.dominio.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.desafio.desafioExperian.dto.ConsultaDTO;
import com.desafio.desafioExperian.recursos.util.URL;
import com.desafio.desafioExperian.servico.ConsultaServico;

@RestController
@RequestMapping(value="/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaServico servico;
	
	// Primeiro endpoint:
	@RequestMapping(method = RequestMethod.GET)
	//ResponseEntity para retornar respostas HTTP com possiveis cabecalhos e mensagens de erros
public ResponseEntity< List<ConsultaDTO>> findAll(){
	
	List<Consulta> lista = servico.findAll();
	// a linha abaixo converte minha lista original para uma lista DTO.
	List<ConsultaDTO> listadto = lista.stream().map(x -> new ConsultaDTO(x)).collect(Collectors.toList());
	return ResponseEntity.ok().body(listadto);
}
	
	// Segundo endpoint: 
	@RequestMapping(value="/nomebusca",method = RequestMethod.GET)
	public ResponseEntity<List<Consulta>> findByNome(@RequestParam(value="nome", defaultValue = " ")String nome) {
		nome = URL.decodeParam(nome);
		List<Consulta> listx = servico.buscaNome(nome);
		return ResponseEntity.ok().body(listx);
	}
		
		
	
		
		
	//METODO PARA RETORNAR DE ACORDO COM O ID:
	@RequestMapping(value="/{id}" ,method = RequestMethod.GET)
	//ResponseEntity para retornar respostas HTTP com possiveis cabecalhos e mensagens de erros
	//@PathVariable para casar o string id com o id da taxa dto e do banco de dados.
public ResponseEntity<ConsultaDTO> findById(@PathVariable  String id){
	Consulta obj = servico.findById(id);
		
	return ResponseEntity.ok().body(new ConsultaDTO(obj));
}
	// METODO PARA INSERIR UM NOVO DADO:
	@RequestMapping(method = RequestMethod.POST)
	
public ResponseEntity<Void> inserir(@RequestBody ConsultaDTO objdto){
	Consulta obj = servico.fromDTO(objdto);
	obj = servico.inserir(obj);
	
	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();	
	return  ResponseEntity.created(uri).build();
	
}
	// METODO PARA DELETAR POR ID:
	@RequestMapping(value="/{id}" ,method = RequestMethod.DELETE)
	
public ResponseEntity<Void> delete( @PathVariable  String id){
	 servico.deletar(id);
		
	return ResponseEntity.noContent().build();
}
	
	//METODO PARA ATUALIZAR OS DADOS:
	
	@RequestMapping(value="/{id}",method = RequestMethod.PUT)
	
	public ResponseEntity<Void> atualizar(@RequestBody ConsultaDTO objdto, @PathVariable String id){
		Consulta obj = servico.fromDTO(objdto);
		obj.setId(id);
		obj = servico.atualiza(obj);	
		return ResponseEntity.noContent().build();
		
	}
	
}
