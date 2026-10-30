-- Dados iniciais do Sistema Cinema CRUD (apenas para TESTE).
-- Rode depois do schema.sql.

-- Administrador de teste: login "admin" / senha "admin123"
INSERT INTO administrador (nome, login, senha) VALUES ('Administrador', 'admin', 'admin123');

-- Filmes para testar a busca por ID e por título
INSERT INTO filme (titulo, genero, classificacao_etaria, nota, sinopse, em_cartaz) VALUES
('Matrix', 'Ficção Científica', '14', 8.7, 'Um hacker descobre a verdadeira natureza da realidade.', TRUE),
('Interestelar', 'Ficção Científica', '10', 8.6, 'Exploradores viajam por um buraco de minhoca para salvar a humanidade.', TRUE),
('O Auto da Compadecida', 'Comédia', '12', 8.0, 'As aventuras de João Grilo e Chicó no sertão nordestino.', FALSE),
('2012', 'Ação', '12', 5.8, 'Um cataclismo global ameaça o planeta.', TRUE);
