package br.gov.caixa.adabankapi.dtoRequest;

import br.gov.caixa.adabankapi.enums.StatusClienteEnum;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ClientPJRequestDto{

private String nomeFantasia;
private LocalDate dataCadastro;
private StatusClienteEnum status;
private String cnpj;

}
