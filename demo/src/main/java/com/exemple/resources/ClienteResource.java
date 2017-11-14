package com.exemple.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteResource{
	
    @RequestMapping(value = "/livros", method = RequestMethod.GET)
	public String listar() {
		return "Ana, João";
	}
}
