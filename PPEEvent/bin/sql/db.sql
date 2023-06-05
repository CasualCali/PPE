drop DATABASE if exists travelin_Event;

create DATABASE travelin_Event;

use travelin_Event;

CREATE TABLE users (
  id_client int(11) NOT NULL AUTO_INCREMENT,
  nom varchar(255) NOT NULL,
  prenom varchar(255) NOT NULL,
  email varchar(255) NOT NULL,
  telephone int(20) NOT NULL,
  mdp varchar(255) NOT NULL,
  role_client varchar(255) NOT NULL,
  statut varchar(255) NOT NULL,
  siret varchar(255) NOT NULL,
  PRIMARY KEY (id_client),
  UNIQUE KEY id_client (id_client)
);

CREATE TABLE destinations (
    destination_id INT(11) NOT NULL AUTO_INCREMENT,
    destination_name VARCHAR(255) NOT NULL,
    destination_description TEXT NOT NULL,
    destination_image VARCHAR(255) NOT NULL,
    PRIMARY KEY (destination_id),
    UNIQUE KEY destination_id (destination_id)
);

CREATE TABLE logements (
    logement_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    logement_name VARCHAR(255) NOT NULL,
    logement_type VARCHAR(255) NOT NULL,
    logement_lieu VARCHAR(255) NOT NULL,
    logement_adresse VARCHAR(255) NOT NULL,
    logement_nb_etoiles INT (1) NOT NULL,
    logement_nb_notes INT (5) NOT NULL,
    logement_description TEXT NOT NULL,
    logement_date_debut VARCHAR (255) NOT NULL,
    logement_date_fin VARCHAR (255) NOT NULL,
    logement_prix INT(5) NOT NULL
);

CREATE TABLE transport (
    transport_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    transport_name VARCHAR (255) NOT NULL,
    ville_depart VARCHAR (255) NOT NULL,
    ville_arrivee VARCHAR (255) NOT NULL,
    transport_date VARCHAR (255) NOT NULL,
    heure_depart VARCHAR (255) NOT NULL,
    heure_arrivee VARCHAR (255) NOT NULL,
    numero VARCHAR (255) NOT NULL,
    compagnie VARCHAR (255) NOT NULL,
    modele VARCHAR (255) NOT NULL,
    heure_de_trajet VARCHAR (255) NOT NULL,
    transport_prix VARCHAR (255) NOT NULL
); 

CREATE TABLE offres (
    offre_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    destination_id INT NOT NULL,
    transport_id INT NOT NULL,
    logement_id INT NOT NULL,
    offres_prix DECIMAL(10,2) NOT NULL,
   FOREIGN KEY (destination_id) REFERENCES destinations(destination_id),
    FOREIGN KEY (transport_id) REFERENCES transport(transport_id),
    FOREIGN KEY (logement_id) REFERENCES logements(logement_id)
);

CREATE TABLE reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    reservation_type VARCHAR (255)NOT NULL,
    ville_depart VARCHAR (255)NOT NULL,
    destination_name VARCHAR (255),
    date_depart VARCHAR (255),
    nb_personnes INT NOT NULL,
    logement_id INT,
    logement_name VARCHAR (255),
    logement_type VARCHAR (255),
    logement_nb_etoiles INT,
    logement_date_debut VARCHAR (255),
    logement_date_fin VARCHAR (255),
    numero varchar(255),
    heure_depart VARCHAR (255),
    heure_arrivee VARCHAR (255),
    reservations_prix varchar(255) NOT NULL,
    nom varchar(255) NOT NULL,
    prenom varchar(255) NOT NULL,
    email VARCHAR(200) NOT NULL,
    FOREIGN KEY (numero) REFERENCES transport(transport_id),
    FOREIGN KEY (logement_id) REFERENCES logements(logement_id)
);

CREATE TABLE promotions (
    promotion_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    offre_id INT NOT NULL,
    date_debut VARCHAR (255) NOT NULL,
    date_fin VARCHAR (255) NOT NULL,
    pourcentage DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (offre_id) REFERENCES offres(offre_id)
);

