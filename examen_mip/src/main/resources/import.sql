
CREATE TABLE carte (
                       id SERIAL PRIMARY KEY,
                       nume VARCHAR(255) NOT NULL,
                       pret DOUBLE PRECISION NOT NULL
);


CREATE TABLE vanzari_efectuate (
                                   id SERIAL PRIMARY KEY,
                                   carte_id INTEGER REFERENCES carte(id),
                                   data_vanzarii TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


INSERT INTO carte (nume, pret) VALUES ('Poezii - Eminescu', 45.0);
INSERT INTO carte (nume, pret) VALUES ('Baltagul - Sadoveanu', 30.0);
INSERT INTO carte (nume, pret) VALUES ('Java Programming', 150.0);
INSERT INTO carte (nume, pret) VALUES ('Clean Code', 120.0);

INSERT INTO carte (id, nume, pret) VALUES (9, 'The Pragmatic Programmer', 130.0);
INSERT INTO carte (id, nume, pret) VALUES (10, 'Design Patterns', 140.0);
INSERT INTO carte (id, nume, pret) VALUES (11, 'Introduction to Algorithms', 200.0);
INSERT INTO carte (id, nume, pret) VALUES (12, 'Refactoring', 110.0);

INSERT INTO vanzari_efectuate (id) VALUES (9);
INSERT INTO vanzari_efectuate (id) VALUES (10);
INSERT INTO vanzari_efectuate (id) VALUES (11);
INSERT INTO vanzari_efectuate (id) VALUES (12);