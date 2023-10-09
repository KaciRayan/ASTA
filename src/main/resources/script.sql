DROP DATABASE IF EXISTS ApprentissageDB;

CREATE DATABASE ApprentissageDB;

-- Utilisation de la base de données créée
USE ApprentissageDB;

-- Création des tables

CREATE TABLE Entreprise (
    ID_Entreprise INT PRIMARY KEY,
    Raison_sociale VARCHAR(255),
    Adresse VARCHAR(255),
    Infos_utiles VARCHAR(100)
);

CREATE TABLE Maitre_Apprentissage (
    ID_Maitre INT PRIMARY KEY,
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Poste VARCHAR(100),
    Email VARCHAR(100),
    Tel VARCHAR(20),
    Remarques VARCHAR(200),
    ID_Entreprise INT,
    FOREIGN KEY (ID_Entreprise) REFERENCES Entreprise(ID_Entreprise)
);

CREATE TABLE Apprenti (
    ID_Apprenti INT PRIMARY KEY,
    Programme VARCHAR(50),
    Annee VARCHAR(50),
    Majeure VARCHAR(100),
    Nom VARCHAR(50),
    Prenom VARCHAR(50),
    Email VARCHAR(100),
    Tel VARCHAR(20),
    ID_Entreprise INT,
    ID_Maitre INT,
    FOREIGN KEY (ID_Entreprise) REFERENCES Entreprise(ID_Entreprise),
    FOREIGN KEY (ID_Maitre) REFERENCES Maitre_Apprentissage(ID_Maitre)
);

CREATE TABLE Mission (
    ID_Mission INT PRIMARY KEY,
    Mots_Cles VARCHAR(100),
    Metier VARCHAR(255),
    Commentaires VARCHAR(200),
    ID_Apprenti INT,
    ID_Entreprise INT,
    FOREIGN KEY (ID_Entreprise) REFERENCES Entreprise(ID_Entreprise),
    FOREIGN KEY (ID_Apprenti) REFERENCES Apprenti(ID_Apprenti)
);

CREATE TABLE Visite (
    ID_Visite INT PRIMARY KEY,
    Date DATE,
    Format VARCHAR(50),
    Compte_Rendu VARCHAR(200),
    ID_Apprenti INT,
    ID_Maitre INT,
    ID_Entreprise INT,
    FOREIGN KEY (ID_Entreprise) REFERENCES Entreprise(ID_Entreprise),
    FOREIGN KEY (ID_Maitre) REFERENCES Maitre_Apprentissage(ID_Maitre),
    FOREIGN KEY (ID_Apprenti) REFERENCES Apprenti(ID_Apprenti)
);

CREATE TABLE Evaluation (
    ID_Evaluation INT PRIMARY KEY,
    Sujet VARCHAR(255),
    Date DATE,
    Note FLOAT,
    Commentaires VARCHAR(200),
    Type_Evaluation VARCHAR(255),
    ID_Apprenti INT,
    FOREIGN KEY (ID_Apprenti) REFERENCES Apprenti(ID_Apprenti)
);