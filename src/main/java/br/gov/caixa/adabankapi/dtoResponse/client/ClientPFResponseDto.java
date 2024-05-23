package br.gov.caixa.adabankapi.dtoResponse.client;

import br.gov.caixa.adabankapi.enums.StatusClientEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientPFResponseDto {

    private Long id;
    private String nome;
    private LocalDate dataCadastro;
    private StatusClientEnum status;
    private String cpf;


}
