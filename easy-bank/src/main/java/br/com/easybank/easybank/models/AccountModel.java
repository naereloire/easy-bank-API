package br.com.easybank.easybank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conta")
public class AccountModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private TitularModel titular;

    @Column(name = "agencia", nullable = false)
    private Long agencia;

    @Column(name = "numero", nullable = false)
    private Long numero;

    @Column(name = "saldo", nullable = false)
    private double saldo;
}
