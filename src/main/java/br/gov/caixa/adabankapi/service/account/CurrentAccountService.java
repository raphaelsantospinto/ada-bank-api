package br.gov.caixa.adabankapi.service.account;


import br.gov.caixa.adabankapi.dtoRequest.account.AccountIdRequestDto;
import br.gov.caixa.adabankapi.dtoResponse.account.AccountCreationResponseDto;
import br.gov.caixa.adabankapi.entity.Account.CurrentAccount;
import br.gov.caixa.adabankapi.exceptions.ValidationException;
import br.gov.caixa.adabankapi.repository.AccountRepository;
import br.gov.caixa.adabankapi.repository.ClientRepository;
import jakarta.persistence.DiscriminatorValue;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
@Service
public class CurrentAccountService {

    final private AccountRepository accountRepository;
    final private ClientRepository clientRepository;
    final private ModelMapper modelMapper;

    public CurrentAccountService(AccountRepository accountRepository, ClientRepository clientRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    public AccountCreationResponseDto create(AccountIdRequestDto accountCreationRequestDto) {
        CurrentAccount cc = new CurrentAccount();
        cc.setBalance(BigDecimal.ZERO);
        cc.setCreatedDate(LocalDate.now());
        cc.setClient(clientRepository.findById(accountCreationRequestDto.getId())
                .orElseThrow(() -> new ValidationException("Impossivel Criar conta com ID passado")));
       accountRepository.save(cc);
       AccountCreationResponseDto ac = modelMapper.map(cc, AccountCreationResponseDto.class);
       ac.setType(cc.getClass().getAnnotation(DiscriminatorValue.class).value());
       return ac;
    }


}
