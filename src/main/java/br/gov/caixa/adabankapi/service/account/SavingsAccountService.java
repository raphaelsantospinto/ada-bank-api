package br.gov.caixa.adabankapi.service.account;

import br.gov.caixa.adabankapi.dtoRequest.account.AccountIdRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.account.AccountCreationResponseDto;
import br.gov.caixa.adabankapi.entity.Account.SavingsAccount;
import br.gov.caixa.adabankapi.exceptions.ValidationException;
import br.gov.caixa.adabankapi.repository.AccountRepository;
import br.gov.caixa.adabankapi.repository.ClientRepository;
import jakarta.persistence.DiscriminatorValue;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class SavingsAccountService {

    final private AccountRepository accountRepository;
    final private ClientRepository clientRepository;
    final private ModelMapper modelMapper;

    public SavingsAccountService(AccountRepository accountRepository, ClientRepository clientRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }
    @Transactional
    public AccountCreationResponseDto create (AccountIdRequestDto accountIdRequestDto) {
       SavingsAccount savingsAccount = new SavingsAccount();
       savingsAccount.setBalance(BigDecimal.ZERO);
       savingsAccount.setCreatedDate(LocalDate.now());
       savingsAccount.setClient(clientRepository
               .findById(accountIdRequestDto.getId())
               .orElseThrow(()-> new ValidationException("Erro na criação da Conta: Cliente nao localizado")));
       accountRepository.save(savingsAccount);

       AccountCreationResponseDto accountCreationResponseDto = modelMapper.map(savingsAccount, AccountCreationResponseDto.class);
       accountCreationResponseDto.setType(savingsAccount.getClass().getAnnotation(DiscriminatorValue.class).value());
       return accountCreationResponseDto;
    }
}
