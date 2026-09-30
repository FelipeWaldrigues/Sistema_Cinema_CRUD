package service;

import dao.FilmeDAO;
import model.Filme;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Serviço da busca de filmes.
 *
 * O comportamento final deverá exibir "Produto Não Encontrado" quando a
 * consulta não retornar resultados, conforme o enunciado.
 */
public class FilmeService {

    private final FilmeDAO filmeDAO;

    public FilmeService(FilmeDAO filmeDAO) {
        this.filmeDAO = filmeDAO;
    }

    public List<Filme> buscar(String termo) throws SQLException {
        // TODO Parte 1:
        // - se o termo for numérico, buscar por ID;
        // - caso contrário, buscar por título;
        // - retornar lista vazia quando não houver resultado.
        return Collections.emptyList();
    }
}
