-- Sistema Cinema CRUD - Supabase (PostgreSQL)
-- Cole no SQL Editor do Supabase e execute. Depois rode dados_iniciais.sql.

CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    sobrenome VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    email VARCHAR(150),
    telefone VARCHAR(30),
    cpf VARCHAR(20),
    endereco VARCHAR(255),
    caixa_postal VARCHAR(30)
);

CREATE TABLE IF NOT EXISTS administrador (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS filme (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    genero VARCHAR(150),
    classificacao_etaria VARCHAR(20),
    nota NUMERIC(3,1),
    sinopse TEXT,
    em_cartaz BOOLEAN NOT NULL DEFAULT TRUE
);

-- Segurança: bloqueia acesso pela API pública do Supabase (anon key).
-- A aplicação Java conecta via JDBC com o usuário "postgres", que ignora o RLS.
ALTER TABLE usuario       ENABLE ROW LEVEL SECURITY;
ALTER TABLE administrador ENABLE ROW LEVEL SECURITY;
ALTER TABLE filme         ENABLE ROW LEVEL SECURITY;
