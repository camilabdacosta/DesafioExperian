package com.desafio.desafioExperian.recursos.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.desafio.desafioExperian.servico.exception.ObjetoNaoEncontradoException;

// Essa classe é o manipulador de excessoes(erros).
@ControllerAdvice
public class RessourceExceptionHandler {
		
	@ExceptionHandler(ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandartError> objetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError erro = new StandartError(System.currentTimeMillis(),404, "Não encontrado",e.getMessage(),request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}
}
