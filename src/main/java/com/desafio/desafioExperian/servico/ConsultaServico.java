package com.desafio.desafioExperian.servico;

import java.util.List;
import java.util.Optional;

import com.desafio.desafioExperian.dominio.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.desafioExperian.dto.ConsultaDTO;
import com.desafio.desafioExperian.repositorio.RepositorioConsulta;
import com.desafio.desafioExperian.servico.exception.ObjetoNaoEncontradoException;

@Service
public class ConsultaServico {
	@Autowired // responsavel por instanciar automaticamente o objeto do tipo RepositorioConsulta
	private RepositorioConsulta repo;
	// responsavel por retornar todos os dados do banco:
	public List<Consulta> findAll() {
		return repo.findAll();
	}
	
	// responsavel por retornar dados de acordo com o id inserido:
	
	public Consulta findById(String id) {
		 Optional<Consulta> obj= repo.findById(id);
		 return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Objeto não encontrado"));


	
	}
	// metodo de busca por nome:
	public List<Consulta> buscaNome(String nome) {
		return repo.findByNomeContaining(nome);
	}
	// metodo de inserir dados com o post:
	public Consulta inserir(Consulta obj) {
		return repo.insert(obj);
	}
	
	public void deletar(String id) {
		findById(id);
		repo.deleteById(id);
		
	} public Consulta atualiza(Consulta obj) {
		Consulta novoObj = findById(obj.getId());
		atualizaDados(novoObj, obj);
		return repo.save(novoObj);
	}
	
	private void atualizaDados(Consulta novoObj, Consulta obj) {
		
		novoObj.setNome(obj.getNome());
		novoObj.setCidade(obj.getCidade());
		novoObj.setTelefone(obj.getTelefone());
		novoObj.setEstado(obj.getEstado());
		novoObj.setIdade(obj.getIdade());
		novoObj.setScore(obj.getScore());
	}

	//conversor de objetos dto em objetos Consulta:
	public Consulta fromDTO(ConsultaDTO objdto) {
		return new Consulta(objdto.getId(),objdto.getNome(),objdto.getCidade(), objdto.getTelefone(), objdto.getEstado(),
				objdto.getIdade(), objdto.getScore());
	}
	
	
}
