package br.gov.caixa.adabankapi.entity.Account;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Savings")
public class SavingsAccount extends Account{
}
