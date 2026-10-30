package service;

import dao.FilmeDAO;
import model.Filme;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FilmeService {
    private final FilmeDAO filmeDAO;

    public FilmeService(FilmeDAO filmeDAO) {
        this.filmeDAO = filmeDAO;
    }

    public List<Filme> buscar(String termo) throws SQLException {
        // Se for número, busca por ID primeiro
        if (termo.matches("\\d{1,18}")) {
            long id = Long.parseLong(termo);
            Optional<Filme> filme = filmeDAO.buscarPorId(id);
            if (filme.isPresent()) {
                return List.of(filme.get());
            }
        }

        // Senão, busca por título
        return filmeDAO.buscarPorTitulo(termo);
    }
}
