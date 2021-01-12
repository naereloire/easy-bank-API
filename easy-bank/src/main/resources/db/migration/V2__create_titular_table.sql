create TABLE IF NOT EXISTS migrations.titular (
    id SERIAL,
    name TEXT NOT NULL,
    cadastral_type INT8 NOT NULL,
    email TEXT NOT NULL,
    phone INT8 NOT NULL,
    PRIMARY KEY (id)
)