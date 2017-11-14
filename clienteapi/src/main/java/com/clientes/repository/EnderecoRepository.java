package com.clientes.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.clientes.domain.Endereco;
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

}
