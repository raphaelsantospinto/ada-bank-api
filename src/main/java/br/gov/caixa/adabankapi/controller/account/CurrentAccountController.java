package br.gov.caixa.adabankapi.controller.account;

import br.gov.caixa.adabankapi.dtoRequest.AccountCreationRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.AccountCreationResponseDto;
import br.gov.caixa.adabankapi.service.account.CurrentAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas/corrente")
public class CurrentAccountController {

    private final CurrentAccountService currentAccountService;

    public CurrentAccountController(CurrentAccountService currentAccountService){
        this.currentAccountService = currentAccountService;
    }

    @PostMapping()
    public ResponseEntity<AccountCreationResponseDto> createAccount (@RequestBody AccountCreationRequestDto accountCreationRequestDto){
        return ResponseEntity.ok(currentAccountService.create(accountCreationRequestDto));
    }
}
