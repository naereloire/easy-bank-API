create TABLE IF NOT EXISTS migrations.conta (
    id SERIAL,
    titular_id INT8 NOT NULL,
    agency INT8 NOT NULL,
    account_number INT8 NOT NULL,
    balance NUMERIC NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY(titular_id) REFERENCES titular(id)
)