package br.gov.caixa.adabankapi.entity.Client;

import jakarta.persistence.Entity;

import lombok.Data;


@Data
@Entity

public class ClientPJ extends Client {
    private String cnpj;
    private String nomeFantasia;
}
