-- Sistema Cinema CRUD
-- Script-base preparado no dialeto MySQL/MariaDB.
-- Se a turma estiver usando outro SGBD, adapte a sintaxe antes de executar.

CREATE DATABASE IF NOT EXISTS cinema;
USE cinema;

CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(150),
    telefone VARCHAR(30),
    cpf VARCHAR(20),
    endereco VARCHAR(255),
    caixa_postal VARCHAR(30),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS administrador (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(150) NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Filme corresponde ao "produto" citado no enunciado.
CREATE TABLE IF NOT EXISTS filme (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(200) NOT NULL,
    genero VARCHAR(150),
    classificacao_etaria VARCHAR(20),
    nota DECIMAL(3,1),
    sinopse TEXT,
    em_cartaz BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id)
);
