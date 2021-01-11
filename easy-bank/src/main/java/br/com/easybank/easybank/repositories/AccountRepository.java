package br.com.easybank.easybank.repositories;

import br.com.easybank.easybank.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
}
