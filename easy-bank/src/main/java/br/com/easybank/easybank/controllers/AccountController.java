package br.com.easybank.easybank.controllers;

import br.com.easybank.easybank.models.AccountModel;
import br.com.easybank.easybank.services.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/account")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public AccountModel createAccount(@RequestBody AccountModel accountModel) {
        return accountService.saveAccount(accountModel);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<AccountModel> getAll() {
        List<AccountModel> listOffAccounts = accountService.findAllAccounts();
        return listOffAccounts;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {

        return accountService.findAccountById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/titular_id/{id}", method = RequestMethod.GET)
    public ResponseEntity getTitularId(@PathVariable("id") Long id) {

        AccountModel titularFounded = accountService.findAccountByTitularId(id);
        if (titularFounded != null) {
            return ResponseEntity.ok().body(titularFounded);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping(value = "/id/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody AccountModel accountModel) {
        AccountModel updated = accountService.updateAccount(id, accountModel);
        if (updated != null) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = {"/id/{id}"})
    public ResponseEntity delete(@PathVariable Long id) {
        boolean deleted = accountService.deleteAccount(id);
        if (deleted) {
            return ResponseEntity.ok().body("deletado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}