package br.gov.caixa.adabankapi.controller.account;

import br.gov.caixa.adabankapi.dtoResponse.account.AccountResponseDto;
import br.gov.caixa.adabankapi.service.account.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>removeById(@PathVariable Long id){
        accountService.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
