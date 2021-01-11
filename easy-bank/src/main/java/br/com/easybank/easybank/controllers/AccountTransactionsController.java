package br.com.easybank.easybank.controllers;

import br.com.easybank.easybank.models.AccountModel;
import br.com.easybank.easybank.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AccountTransactionsController {
    AccountService accountService;

    public AccountTransactionsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping(value = "/id/{id}")
    public ResponseEntity transferMoney(@PathVariable("id") Long originId, Long destinyId, Double money ) {
        AccountModel updated = accountService.transferMoneyBetweenAccounts(originId, destinyId,money);
        if (updated != null) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
