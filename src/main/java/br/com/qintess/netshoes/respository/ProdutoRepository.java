package br.com.qintess.netshoes.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.qintess.netshoes.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
