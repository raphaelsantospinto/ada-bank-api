package br.gov.caixa.adabankapi.dtoRequest.account;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AccountDepositWidrawRequestDto {

    Long clientId;
    BigDecimal value;
}
