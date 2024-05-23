package br.gov.caixa.adabankapi.service.account;

import br.gov.caixa.adabankapi.dtoRequest.account.AccountIdRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.account.AccountCreationResponseDto;
import br.gov.caixa.adabankapi.entity.Account.InvestmentAccount;
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
public class InvestmentAccountService {

    final private AccountRepository accountRepository;
    final private ClientRepository clientRepository;
    final private ModelMapper modelMapper;

    public InvestmentAccountService(AccountRepository accountRepository, ClientRepository clientRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }
    @Transactional
    public AccountCreationResponseDto create (AccountIdRequestDto accountCreationRequestDto) {
       InvestmentAccount investmentAccount = new InvestmentAccount();
       investmentAccount.setBalance(BigDecimal.ZERO);
       investmentAccount.setCreatedDate(LocalDate.now());
       investmentAccount.setClient(clientRepository
               .findById(accountCreationRequestDto.getId())
               .orElseThrow(()-> new ValidationException("Erro na criação da Conta: Cliente nao localizado")));
       accountRepository.save(investmentAccount);

       AccountCreationResponseDto accountCreationResponseDto = modelMapper.map(investmentAccount, AccountCreationResponseDto.class);
       accountCreationResponseDto.setType(investmentAccount.getClass().getAnnotation(DiscriminatorValue.class).value());
       return accountCreationResponseDto;
    }
}
