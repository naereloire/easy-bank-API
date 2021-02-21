package br.com.easybank.easybank.controllers;

import br.com.easybank.easybank.models.AccountModel;
import br.com.easybank.easybank.models.TransferForm;
import br.com.easybank.easybank.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/account")
public class AccountTransactionsController {
    AccountService accountService;

    public AccountTransactionsController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping(value = "/transfer", produces = "application/json; charset=UTF-8")
    public ResponseEntity transferMoney(@RequestBody TransferForm transferForm) {
        AccountModel updated = accountService.transferMoneyBetweenAccounts(transferForm.getOriginId(), transferForm.getDestinyId(),
                transferForm.getMoney());
        if (updated != null) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
