package br.gov.caixa.adabankapi.entity;

import br.gov.caixa.adabankapi.enums.StatusClienteEnum;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@MappedSuperclass
@Data
public abstract class Client {
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Id
    @jakarta.persistence.Id
    private Long id;

    private String nome;
    private LocalDate dataCadastro;
    private StatusClienteEnum status;


}
