package br.gov.caixa.adabankapi.dtoResponse;

import br.gov.caixa.adabankapi.enums.StatusClienteEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientPFResponseDto {

    private Long id;
    private String nome;
    private LocalDate dataCadastro;
    private StatusClienteEnum status;
    private String cpf;


}
