package br.com.easybank.easybank.services;

import br.com.easybank.easybank.models.AccountModel;
import br.com.easybank.easybank.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository accountRepository;

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

    public AccountModel findAccountByTitularId(Long id) {
        Optional<AccountModel> accountFounded = accountRepository.findByTitularId(id);
        if (accountFounded.isPresent()) {
            AccountModel accountWanted = accountFounded.get();
            return accountWanted;
        } else {
            return null;
        }
    }

    public AccountModel updateAccount(Long id, AccountModel accountModel) {
        Optional<AccountModel> accountFounded = accountRepository.findById(id);
        if (accountFounded.isPresent()) {
            AccountModel record = accountFounded.get();
            record.setBalance(accountModel.getBalance());
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

    public AccountModel transferMoneyBetweenAccounts(Long titularIdOrigin, Long titularIdDestiny, Double quantityToTransfer) {
        AccountModel accountOrigin = this.findAccountByTitularId(titularIdOrigin);
        AccountModel destinyAccount = this.findAccountByTitularId(titularIdDestiny);
        Double accountOriginbalance = accountOrigin.getBalance();

        if (accountOriginbalance >= quantityToTransfer) {
            accountOrigin.setBalance(accountOriginbalance - quantityToTransfer);
            accountOrigin = this.updateAccount(accountOrigin.getId(), accountOrigin);

            destinyAccount.setBalance(destinyAccount.getBalance() + quantityToTransfer);
            destinyAccount = this.updateAccount(destinyAccount.getId(), destinyAccount);

            return accountOrigin;
        } else {
            return null;
        }


    }
}
