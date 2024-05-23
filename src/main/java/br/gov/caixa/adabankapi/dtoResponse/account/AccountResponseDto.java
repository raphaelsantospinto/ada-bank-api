package br.gov.caixa.adabankapi.dtoResponse.account;
import br.gov.caixa.adabankapi.dtoResponse.client.ClientResponseDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AccountResponseDto {


    private Long id;
    private BigDecimal balance;
    private LocalDate createdDate;
    private String accountType;
    private ClientResponseDto client;


}
