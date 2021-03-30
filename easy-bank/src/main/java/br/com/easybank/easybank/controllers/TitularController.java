package br.com.easybank.easybank.controllers;

import br.com.easybank.easybank.models.TitularModel;
import br.com.easybank.easybank.services.TitularService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/titular")
public class TitularController {

    private TitularService titularService;

    public TitularController(TitularService titularService) {
        this.titularService = titularService;
    }

    @CrossOrigin
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public TitularModel createTitular(@RequestBody TitularModel titularModel) {

        return titularService.saveTitular(titularModel);
    }

    @CrossOrigin
    @RequestMapping(value = "/loggeduser", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public ResponseEntity getByEmailAndPassword (@RequestBody TitularModel titularModel) {
      TitularModel  loggedUserFounded = titularService.findTitularByEmailAndPassword(titularModel.getEmail(),
              titularModel.getPassword());
        if (loggedUserFounded != null) {
            return ResponseEntity.ok().body(loggedUserFounded);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<TitularModel> getAll() {
        List<TitularModel> listOffTitulars = titularService.findAllTitulars();
        return listOffTitulars;
    }

    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") Long id) {

        return titularService.findTitularById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @RequestMapping(value = "/cpf/{cpf}", method = RequestMethod.GET)
    public ResponseEntity getByCpf(@PathVariable("cpf") Long cpf) {

        TitularModel titularFounded = titularService.findByCadastralType(cpf);
        if (titularFounded != null) {
            return ResponseEntity.ok().body(titularFounded);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping(value = "/id/{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody TitularModel titularModel) {
        TitularModel updated = titularService.updateTitular(id, titularModel);
        if (updated != null) {
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
