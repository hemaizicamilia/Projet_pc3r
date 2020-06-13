CREATE TABLE  bd_pcr.User (
 id INT( 11 ) NOT NULL AUTO_INCREMENT ,
 nom VARCHAR( 20 ) NOT NULL ,
 prenom VARCHAR( 20 ) NOT NULL ,
 email VARCHAR( 60 ) NOT NULL ,
 mdps VARCHAR( 32 ) NOT NULL ,
 tel VARCHAR( 20 ) NOT NULL ,
 PRIMARY KEY ( id ),
 UNIQUE ( email )
) ENGINE = INNODB;

CREATE TABLE  bd_pcr.Reservation (
 id INT( 11 ) NOT NULL AUTO_INCREMENT ,
 aeroport_depart VARCHAR( 20 ) NOT NULL ,
 aeroport_arr VARCHAR( 20 ) NOT NULL ,
 date_depart VARCHAR( 60 ) NOT NULL ,
 date_arr VARCHAR( 32 ) NOT NULL ,
 company VARCHAR( 20 ) NOT NULL ,
 utilisateur INT( 11 ) NOT NULL ,
 PRIMARY KEY ( id ),
 FOREIGN KEY (utilisateur) REFERENCES User(id)
) ENGINE = INNODB;

INSERT INTO User (nom, prenom, email, mdps,tel) VALUES ('camilia','hemaizi', 'camilia@gmail.com', '123','0663680169');

INSERT INTO Reservation (aeroport_depart, aeroport_arr, date_depart, date_arr, company,utilisateur) VALUES ('Samratulangi','Jefman', '2020-06-11T06:00:00+00:00', '2020-06-11T08:30:00+00:00','Sriwijaya Air', 1);


