package br.gov.caixa.adabankapi.entity.Account;

import br.gov.caixa.adabankapi.entity.Client.Client;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @NotNull
    private BigDecimal balance;

    private LocalDate createdDate;
    @ManyToOne
    private Client client;

}
