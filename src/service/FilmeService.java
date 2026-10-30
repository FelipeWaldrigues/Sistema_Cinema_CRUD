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
        // Se o termo for numérico, tenta primeiro por ID; se não achar,
        // cai para o título (ex.: filme chamado "2012").
        if (termo.matches("\\d{1,18}")) {
            long id = Long.parseLong(termo);
            Optional<Filme> filme = filmeDAO.buscarPorId(id);
            if (filme.isPresent()) {
                return List.of(filme.get());
            }
        }

        // Caso contrário, buscar por título
        return filmeDAO.buscarPorTitulo(termo);
    }
}
