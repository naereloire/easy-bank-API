package br.com.easybank.easybank.services;

import br.com.easybank.easybank.models.TitularModel;
import br.com.easybank.easybank.repositories.TitularRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TitularService {
    private TitularRepository titularRepository;

    public TitularService(TitularRepository titularRepository) {

        this.titularRepository = titularRepository;
    }

    public TitularModel saveTitular(TitularModel titular) {

        return titularRepository.save(titular);
    }

    public List<TitularModel> findAllTitulars() {
        return titularRepository.findAll();

    }

    public Optional<TitularModel> findTitularById(Long id) {

        return titularRepository.findById(id);
    }

    public TitularModel findByCadastralType(Long cadastralType) {
        Optional<TitularModel> titularFounded = titularRepository.
                findByCadastralType(cadastralType);
        if (titularFounded.isPresent()) {
            TitularModel wanted = titularFounded.get();
            return wanted;
        } else {
            return null;
        }
    }

    public TitularModel updateTitular(Long id, TitularModel titularModel) {

        Optional<TitularModel> titularFounded = titularRepository.findById(id);
        if (titularFounded.isPresent()) {
            TitularModel record = titularFounded.get();
            record.setTitularName(titularModel.getTitularName());
            record.setEmail(titularModel.getEmail());
            record.setPhone(titularModel.getPhone());
            TitularModel updated = titularRepository.save(record);
            return updated;
        } else {
            return null;
        }
    }

}

