package br.gov.caixa.adabankapi.repository;

import br.gov.caixa.adabankapi.entity.Account.Account;
import br.gov.caixa.adabankapi.entity.Account.CurrentAccount;
import br.gov.caixa.adabankapi.entity.Account.SavingsAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("select a from CurrentAccount a")
    public List<CurrentAccount> findAllCurrentAccount();

    @Query("select a from SavingsAccount a")
    public List<SavingsAccount> findAllSavingsAccount();


}
