package br.gov.caixa.adabankapi.repository;

import br.gov.caixa.adabankapi.entity.Client.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository <Client, Long>{
}
