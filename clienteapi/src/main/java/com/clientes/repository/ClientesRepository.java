package com.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clientes.domain.Cliente;

public interface ClientesRepository extends JpaRepository<Cliente, Long>{

}
