package br.gov.caixa.adabankapi.dtoRequest;

import br.gov.caixa.adabankapi.enums.StatusClientEnum;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ClientPFRequestDto {

    private String nome;
    private LocalDate dataCadastro;
    private StatusClientEnum status;
    private String cpf;
}
