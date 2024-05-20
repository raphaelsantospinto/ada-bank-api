package br.gov.caixa.adabankapi.entity.Account;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Investment")
public class InvestmentAccount extends Account{

}
