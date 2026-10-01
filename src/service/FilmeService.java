package service;

import dao.FilmeDAO;
import model.Filme;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

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
        // Se o termo for numérico, buscar por ID
        if (termo.matches("\\d+")) {
            long id = Long.parseLong(termo);
            Optional<Filme> filme = filmeDAO.buscarPorId(id);
            return filme.map(List::of).orElse(List.of());
        }
        
        // Caso contrário, buscar por título
        return filmeDAO.buscarPorTitulo(termo);
    }
}
