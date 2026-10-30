package dao;

import model.Filme;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IFilmeDAO {
    Optional<Filme> buscarPorId(long id) throws SQLException;
    List<Filme> buscarPorTitulo(String titulo) throws SQLException;
    void salvar(Filme filme) throws SQLException;
    void atualizar(Filme filme) throws SQLException;
    void remover(long id) throws SQLException;
}
