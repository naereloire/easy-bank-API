package br.com.easybank.easybank.repositories;

import br.com.easybank.easybank.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountModel, Long> {
    @Query(
            value = "SELECT * FROM conta u WHERE u.titular_id = :titularId",
            nativeQuery = true)
    Optional<AccountModel> findByTitularId(@Param("titularId") Long titularId);
}