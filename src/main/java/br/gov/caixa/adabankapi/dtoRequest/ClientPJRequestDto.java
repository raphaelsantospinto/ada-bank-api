package br.gov.caixa.adabankapi.dtoRequest;

import br.gov.caixa.adabankapi.enums.StatusClientEnum;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ClientPJRequestDto{

private String nomeFantasia;
private LocalDate dataCadastro;
private StatusClientEnum status;
private String cnpj;

}
