package br.gov.caixa.adabankapi.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contas")
public class AccountController {
    @PostMapping("/corrente")
    public void createCurrentAccount (){
        //TODO
    }

    @PostMapping("/poupanca")
    public void createSavingsAccount (){
        //TODO
    }
    @PostMapping("/investimento")
    public void createInvestmentAccount (){
        //TODO
    }



}
