package br.com.easybank.easybank.repositories;

import br.com.easybank.easybank.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    Optional<AccountModel> findByTitularId(Long titularId);
}
