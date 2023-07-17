/* DDL - Data Definition Language (definizione della struttura) = 
(CREATE) permette di creare, 
(DROP) eliminare oggetti dal database, 
(ALTER) alterare la struttura degli oggetti, 
(TRUNCATE) utilizzato per rimuovere tutti gli elementi contenuti in un database senza eliminare il database, 
(COMMENT) per commentare, 
(RENAME) per rinominare.
*/

-- Crea un database di nome dbtest
-- CREATE DATABASE dbtest; 

-- Cancella un database di nome dbtest
-- DROP DATABASE dbtest;

 CREATE TABLE utente (
	 /*id è un valore univoco che gestisce in automatico il database*/
	id SERIAL,
 	/*Dopo aver definito il tipo si può mettere un vincolo NULL, Se l'utente non definisce nessun valore si possono 
	 mettere valori di default*/
	nome VARCHAR  NOT NULL DEFAULT '---',
	cognome VARCHAR NOT NULL DEFAULT '---', 
	anni INTEGER NOT NULL,
	 /*La email deve essere univoca, UNIQUE è un vincolo che applica valori univoci*/
	email VARCHAR NOT NULL UNIQUE,
	/*Per mettere in relazione le due tabelle*/
	citta INTEGER NOT NULL,
	 /*Si definisce la PrimaryKey*/
	CONSTRAINT utente_PK PRIMARY KEY (id),
	/*Devi assegnare una relazione tra il campo citta e la tabella citta creando un vincolo
	 di FOREIGN tra il campo citta della tabella utenti(la tabella in cui mi trovo) 
	 che si referenzia con la tabella citta sul campo univoco id*/
	CONSTRAINT utente_citta_FK FOREIGN KEY (citta) REFERENCES citta (id)
 );
 
 CREATE TABLE citta (
 	/*La primarykey si pu; definire anche velocemente in questo modo*/
	id SERIAL PRIMARY KEY, -- 1, 2, 3, 4 ...
	nome VARCHAR NOT NULL, -- 'Roma', 'Milano', 'Napoli', 'Torino' ...
	provincia VARCHAR NOT NULL,
	regione VARCHAR NOT NULL
 );
 
 /*Per cancellare una tabella*/
-- DROP TABLE utente;
-- DROP TABLE citta;

/*Per alterare gli elementi all'interno della tabella senza perdere dati andando ad aggiungere, togliere o 
modificare campo*/
ALTER TABLE utente ADD cf VARCHAR NOT NULL UNIQUE;
ALTER TABLE utente DROP cf;
/*Rinomino la tabella*/
ALTER TABLE utente RENAME COLUMN cf TO codice_fiscale;
/*Posso aggiungere e rimuovere un vincolo*/
ALTER TABLE utente DROP CONSTRAINT utente_citta_FK;
ALTER TABLE utente ADD CONSTRAINT utente_citta_FK FOREIGN KEY (citta) REFERENCES citta (id);

/*
(COMMENT) per mettere commenti in una tabella
*/

-------------------------------------------------------------------------------------------------------

/* DML - Data Manipulation Language (modifica dei dati all'interno della tabella) =
(INSERT)
(UPDATE)
(DELETE)
*/

/*Inserire dati*/
INSERT INTO citta (nome, provincia, regione) VALUES ('San Cesareo', 'Roma', 'Lazio');
INSERT INTO citta (nome, provincia, regione) VALUES ('Milano', 'Milano', 'Lombardia');
INSERT INTO citta (nome, provincia, regione) VALUES ('Rozzano', 'Milano', 'Lombardia');
INSERT INTO citta (nome, provincia, regione) VALUES ('Napoli', 'Napoli', 'Campania');
INSERT INTO citta (nome, provincia, regione) VALUES ('Pompei', 'Napoli', 'Campania');
INSERT INTO citta (nome, provincia, regione) VALUES ('Torino', 'Torino', 'Piemonte');

INSERT INTO utente (nome, cognome, anni, email, citta) VALUES ('Mario', 'Rossi', 25, 'm.rossi@example.com', 2);
INSERT INTO utente (nome, cognome, anni, email, citta) VALUES ('Giuseppe', 'Verdi', 49, 'g.verdi@example.com', 3);
INSERT INTO utente (nome, cognome, anni, email, citta) VALUES ('Francesca', 'Neri', 37, 'f.neri@example.com', 5);
INSERT INTO utente (nome, cognome, anni, email, citta) VALUES ('Antonio', 'Bianchi', 19, 'a.bianchi@example.com', 1);

DELETE FROM utente WHERE id = 3;
-- DELETE FORM utente; cencella tutti i dati nella tabella utente

--Modifico il valore citta solo per la riga con l'id 9
UPDATE utente SET citta = 4 WHERE id = 9;
-- UPDATE utente SET citta = 4; Modifico tutti i dati del campo citta nella tabella utente

-------------------------------------------------------------------------------------------------------

/* DQL - Data Query Languange */

/*Per leggere tutti i dati nelle tabelle SELECT * FROM (l'asterisco sta per ALL) */
SELECT * FROM utente;
SELECT * FROM citta;

SELECT nome, cognome FROM utente;

SELECT * FROM utente WHERE citta = 1;
SELECT * FROM citta WHERE provincia = 'Milano';
SELECT * FROM citta WHERE provincia = 'Milano' AND nome = 'Rozzano';
/*Oltre a = si può usare LIKE, 
% che comincia con qualunque cosa, 
all'interno ci sia mba, 
% che finisce con qualunque cosa*/
SELECT * FROM citta WHERE regione LIKE '%mba%';
SELECT * FROM citta WHERE regione LIKE 'L%';
SELECT * FROM citta WHERE regione LIKE 'L_z%';
SELECT * FROM utente WHERE email LIKE '_.%@%.com';
SELECT * FROM utente WHERE anni > 30;

/*I JOIN unisce due tabelle e prende i dati 
INNER JOIN - LEFT JOIN - RIGHT JOIN - FULL JOIN*/

/*Inner join prende dati che sono in relazione tra la tabella A e la tabella B*/
SELECT * FROM utente INNER JOIN citta ON utente.citta = citta.id;
SELECT * FROM utente LEFT JOIN citta ON utente.citta = citta.id;
SELECT * FROM utente RIGHT JOIN citta ON utente.citta = citta.id;
SELECT * FROM utente FULL JOIN citta ON utente.citta = citta.id;

SELECT * FROM utente ORDER BY anni ASC;
SELECT * FROM utente ORDER BY nome DESC;

/*Selezionare solo una volte le province*/
SELECT DISTINCT provincia FROM citta;

/* DCL - Data Control Language (ci interessa meno perché lavoreremo in locale) */