package br.com.easybank.easybank.services;

import br.com.easybank.easybank.models.AccountModel;
import br.com.easybank.easybank.repositories.AccountRepository;

import java.util.List;
import java.util.Optional;

public class AccountService {
    AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountModel saveAccount(AccountModel account) {

        return accountRepository.save(account);
    }

    public List<AccountModel> findAllAccounts() {
        return accountRepository.findAll();

    }

    public Optional<AccountModel> findAccountById(Long id) {

        return accountRepository.findById(id);
    }

    public AccountModel findByTitularId(Long id) {
        Optional<AccountModel> accountFounded = accountRepository.findByTitularId(id);
        if(accountFounded.isPresent()){
            AccountModel accountWanted=accountFounded.get();
            return  accountWanted;
        }else {return null;}
    }

    public AccountModel updateAccount(Long id, AccountModel accountModel) {
        Optional<AccountModel> accountFounded = accountRepository.findById(id);
        if (accountFounded.isPresent()) {
            AccountModel record = accountFounded.get();
            record.setSaldo(accountModel.getSaldo());
            AccountModel updated = accountRepository.save(record);
            return updated;
        } else {
            return null;
        }
    }

    public boolean deleteAccount(Long id) {
        Optional<AccountModel> accountFounded = accountRepository.findById(id);
        if (accountFounded.isPresent()) {
            accountRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
