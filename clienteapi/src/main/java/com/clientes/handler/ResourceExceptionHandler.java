package com.clientes.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.clientes.domain.DetalhesErro;
import com.services.exceptions.ClienteNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
    
	@ExceptionHandler(ClienteNotFoundException.class)
	public ResponseEntity<DetalhesErro> handleClienteNotFoundException(ClienteNotFoundException e, HttpServletRequest request){
		
		DetalhesErro erro = new DetalhesErro();
		erro.setStatus(404l);
		erro.setTitulo("AVISO: Livro não encontrado.");
		erro.setTimestamp(System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);	
	}
}