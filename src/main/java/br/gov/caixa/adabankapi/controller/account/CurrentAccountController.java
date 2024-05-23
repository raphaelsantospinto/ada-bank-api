package br.gov.caixa.adabankapi.controller.account;

import br.gov.caixa.adabankapi.dtoRequest.account.AccountDepositWidrawRequestDto;
import br.gov.caixa.adabankapi.dtoRequest.account.AccountIdRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.account.AccountCreationResponseDto;
import br.gov.caixa.adabankapi.dtoResponse.account.AccountDepositWidrawResponseDto;
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
    public ResponseEntity<AccountCreationResponseDto> createAccount (@RequestBody AccountIdRequestDto accountIdRequestDto){
        return ResponseEntity.ok(currentAccountService.create(accountIdRequestDto));
    }

    @PostMapping("/depositar")
    public ResponseEntity<AccountDepositWidrawResponseDto>deposit(@RequestBody AccountDepositWidrawRequestDto accountDepositWidrawRequestDto){
        return null; //TODO
    }
}
