package br.gov.caixa.adabankapi.repository;

import br.gov.caixa.adabankapi.entity.Client;
import br.gov.caixa.adabankapi.entity.ClientPF;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientPFRepository extends JpaRepository <ClientPF, Long> {
}
