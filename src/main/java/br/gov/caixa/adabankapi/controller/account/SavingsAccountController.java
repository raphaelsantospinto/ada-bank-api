package br.gov.caixa.adabankapi.controller.account;

import br.gov.caixa.adabankapi.dtoRequest.account.AccountIdRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.account.AccountCreationResponseDto;
import br.gov.caixa.adabankapi.service.account.SavingsAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas/poupanca")
public class SavingsAccountController {
    final private SavingsAccountService savingsAccountService;

    public SavingsAccountController(SavingsAccountService savingsAccountService) {
        this.savingsAccountService = savingsAccountService;
    }


    @PostMapping()
    public ResponseEntity<AccountCreationResponseDto> createAccount (@RequestBody AccountIdRequestDto accountIdRequestDto){
        return ResponseEntity.ok(savingsAccountService.create(accountIdRequestDto));

    }
}
