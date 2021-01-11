package br.com.easybank.easybank.repositories;

import br.com.easybank.easybank.models.TitularModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TitularRepository extends JpaRepository<TitularModel, Long> {
    Optional<TitularModel> findByCadastralType(Long cadastralType);
}

