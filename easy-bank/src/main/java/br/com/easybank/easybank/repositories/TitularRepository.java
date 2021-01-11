package br.com.easybank.easybank.repositories;
import br.com.easybank.easybank.models.TitularModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitularRepository extends JpaRepository<TitularModel, Long> {
}

