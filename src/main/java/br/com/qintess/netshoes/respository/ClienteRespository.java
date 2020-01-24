package br.com.qintess.netshoes.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.qintess.netshoes.model.Cliente;

@Repository
public interface ClienteRespository extends JpaRepository<Cliente, Long> {

}
