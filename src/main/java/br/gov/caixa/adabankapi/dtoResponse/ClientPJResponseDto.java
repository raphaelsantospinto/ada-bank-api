package br.gov.caixa.adabankapi.dtoResponse;

import br.gov.caixa.adabankapi.enums.StatusClienteEnum;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientPJResponseDto {

    private Long id;
    private String cnpj;
    private String nomeFantasia;
    private LocalDate dataCadastro;
    private StatusClienteEnum status;

}
