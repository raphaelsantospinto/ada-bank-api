package br.gov.caixa.adabankapi.repository;

import br.gov.caixa.adabankapi.entity.Client.Client;
import br.gov.caixa.adabankapi.entity.Client.ClientPF;
import br.gov.caixa.adabankapi.entity.Client.ClientPJ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface ClientRepository extends JpaRepository <Client, Long>{

    @Query(" select cpf from ClientPF cpf")
    List<ClientPF> findAllPF();

    @Query("select cpj from ClientPJ cpj")
    List<ClientPJ> findAllPJ();
}
