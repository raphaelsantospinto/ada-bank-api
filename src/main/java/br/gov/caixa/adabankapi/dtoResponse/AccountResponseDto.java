package br.gov.caixa.adabankapi.dtoResponse;



import br.gov.caixa.adabankapi.entity.Client.Client;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
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
    private Long clientId;
    private String accountType;



}
