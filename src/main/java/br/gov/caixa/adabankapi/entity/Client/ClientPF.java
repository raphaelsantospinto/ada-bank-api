package br.gov.caixa.adabankapi.entity.Client;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class ClientPF extends Client {

    private String cpf;
    private String nome;

}
