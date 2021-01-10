package br.com.easybank.easybank.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

public class TitularRepository {
    public interface TitularModels extends JpaRepository<TitularModels, Long> {}
}
