package br.gov.caixa.adabankapi.dtoResponse;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class AccountCreationResponseDto {
    private Long id;
    private BigDecimal balance;
    private LocalDate createdDate;
    private Long clientId;
    private String type;
}
