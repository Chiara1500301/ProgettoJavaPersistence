CREATE TABLE IF NOT EXISTS utente(
nome VARCHAR NOT NULL,
cognome VARCHAR NOT NULL,
data_nascita DATE NOT NULL,
numero_tessera INTEGER PRIMARY KEY
);
CREATE TABLE IF NOT EXISTS elemento (
    codice_isbn VARCHAR PRIMARY KEY,
    titolo VARCHAR NOT NULL,
    anno_pubblicazione INTEGER NOT NULL,
    numero_pagine INTEGER NOT NULL
);
CREATE TABLE IF NOT EXISTS libro (
    codice_isbn VARCHAR PRIMARY KEY,
    autore VARCHAR NOT NULL,
    genere VARCHAR NOT NULL,
    FOREIGN KEY (codice_isbn) REFERENCES elemento(codice_isbn) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS rivista (
    codice_isbn VARCHAR PRIMARY KEY,
    periodicità VARCHAR NOT NULL,
    FOREIGN KEY (codice_isbn) REFERENCES elemento(codice_isbn) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS prestito (
    numero_tessera INTEGER NOT NULL,
    codice_isbn VARCHAR NOT NULL,
    data_inizio_prestito DATE NOT NULL,
    data_restituzione_prevista DATE NOT NULL,
    data_restituzione_effettiva DATE,
    PRIMARY KEY (numero_tessera, codice_isbn, data_inizio_prestito),
    FOREIGN KEY (numero_tessera) REFERENCES utente(numero_tessera) ON DELETE CASCADE,
    FOREIGN KEY (codice_isbn) REFERENCES elemento(codice_isbn) ON DELETE CASCADE
);

INSERT INTO utente (nome, cognome, data_nascita, numero_tessera)
VALUES ('Mario', 'Rossi', '1980-05-15', 123456),
       ('Anna', 'Verdi', '1995-10-20', 987654),
       ('Luca', 'Bianchi', '1975-02-03', 654321);
	   
INSERT INTO elemento (codice_isbn, titolo, anno_pubblicazione, numero_pagine)
VALUES ('9781234567890', 'Il signore degli anelli', 1954, 1178),
       ('9789876543210', '1984', 1949, 328),
       ('1234567890123', 'National Geographic', 2021, 100),
       ('4567890123456', 'Time', 2022, 52);
	   
INSERT INTO libro (codice_isbn, autore, genere)
VALUES ('9781234567890', 'J.R.R. Tolkien', 'Fantasy'),
       ('9789876543210', 'George Orwell', 'Distopia');
	   
INSERT INTO rivista (codice_isbn, periodicità)
VALUES ('1234567890123', 'Mensile'),
       ('4567890123456', 'Settimanale');
	   
INSERT INTO prestito (numero_tessera, codice_isbn, data_inizio_prestito, data_restituzione_prevista, data_restituzione_effettiva)
VALUES (123456, '9781234567890', '2022-01-10', '2022-02-09', '2022-02-08'),
       (987654, '1234567890123', '2022-03-15', '2022-04-14', NULL),
       (654321, '9789876543210', '2022-05-20', '2022-06-19', '2022-06-18');
