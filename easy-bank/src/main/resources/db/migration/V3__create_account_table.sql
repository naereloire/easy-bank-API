create TABLE IF NOT EXISTS migrations.conta (
    id INT2,
    titular_id INT2 NOT NULL,
    agencia INT2 NOT NULL,
    numero INT2 NOT NULL,
    saldo INT2 NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(titular_id) REFERENCES titular(id)
);