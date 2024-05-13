package br.gov.caixa.adabankapi.controller;

import br.gov.caixa.adabankapi.dtoRequest.AccountPFRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.AccountPFResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contas")



public class AccountController {
    @PostMapping
    public ResponseEntity<AccountPFResponseDto> createAccountPF (@RequestBody AccountPFRequestDto account){
        //TODO

        return null;
    }

}
