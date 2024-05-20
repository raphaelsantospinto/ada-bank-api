package br.gov.caixa.adabankapi.entity.Client;

import br.gov.caixa.adabankapi.entity.Account.Account;
import br.gov.caixa.adabankapi.enums.StatusClienteEnum;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Client {
    @GeneratedValue(strategy= GenerationType.AUTO)

    @Id
    private Long id;

    private LocalDate dataCadastro;

    @Enumerated(EnumType.STRING)
    private StatusClienteEnum status;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Account> accounts;


}
