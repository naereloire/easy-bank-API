create TABLE IF NOT EXISTS migrations.titular (
    id INT2,
    name TEXT NOT NULL,
    cadastralType INT2 NOT NULL,
    email TEXT NOT NULL,
    phone INT2 NOT NULL,
    PRIMARY KEY (id)
);