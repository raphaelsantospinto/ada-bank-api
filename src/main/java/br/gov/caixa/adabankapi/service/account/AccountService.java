package br.gov.caixa.adabankapi.service.account;

import br.gov.caixa.adabankapi.dtoRequest.account.AccountDepositWidrawRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.account.AccountDepositWidrawResponseDto;
import br.gov.caixa.adabankapi.dtoResponse.account.AccountResponseDto;

import br.gov.caixa.adabankapi.exceptions.ValidationException;
import br.gov.caixa.adabankapi.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    final private ModelMapper modelMapper ;
    final private AccountRepository accountRepository;

    public AccountService( ModelMapper modelMapper, AccountRepository accountRepository ){
        this.modelMapper = modelMapper;
        this.accountRepository = accountRepository;
    }

    public AccountResponseDto findById(Long id){
        return (AccountResponseDto) accountRepository.findById(id)
                .map( account -> modelMapper.map(account, AccountResponseDto.class))
                .orElseThrow(() -> new ValidationException( "Conta nao localizada"));
    }


    public void remove(Long id) {accountRepository.deleteById(id);

    }

    public List<AccountResponseDto> findAll() {
       return accountRepository.findAll().stream()
                .map(account -> modelMapper.map(account, AccountResponseDto.class))
                .collect(Collectors.toList());
    }

    public AccountDepositWidrawResponseDto deposit (AccountDepositWidrawRequestDto accountDepositWidrawRequestDto){
       return accountRepository.findById(accountDepositWidrawRequestDto.getClientId())
                .map(account -> {
                    if (account.getBalance().compareTo(accountDepositWidrawRequestDto.getValue()) > 0) {
                        account.getBalance().subtract(accountDepositWidrawRequestDto.getValue());
                    } else throw new ValidationException("Saldo Insuficiente!");
                    return account;
                })
                .map(accountRepository::save)
                .map(account -> modelMapper.map(account, AccountDepositWidrawResponseDto.class))
                .orElseThrow(()-> new ValidationException("Erro na hora de gravar o deposito!"));

    }

    public AccountDepositWidrawResponseDto widraw (AccountDepositWidrawRequestDto accountDepositWidrawRequestDto){
        return null; //todo
    }
}
