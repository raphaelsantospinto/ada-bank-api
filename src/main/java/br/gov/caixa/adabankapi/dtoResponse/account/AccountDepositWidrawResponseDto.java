package br.gov.caixa.adabankapi.dtoResponse.account;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AccountDepositWidrawResponseDto {
    Long id;
    BigDecimal balance;
}
