package dao;

import model.Filme;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * DAO do produto do sistema: Filme.
 */
public class FilmeDAO {

    public Optional<Filme> buscarPorId(long id) throws SQLException {
        // TODO Parte 1: SELECT por ID.
        throw new UnsupportedOperationException("Busca por ID ainda não implementada.");
    }

    public List<Filme> buscarPorTitulo(String titulo) throws SQLException {
        // TODO Parte 1: SELECT por título/nome do produto.
        throw new UnsupportedOperationException("Busca por título ainda não implementada.");
    }

    public void salvar(Filme filme) throws SQLException {
        // TODO futuro: opção do menu administrativo.
        throw new UnsupportedOperationException("Cadastro de filme será implementado depois.");
    }

    public void atualizar(Filme filme) throws SQLException {
        // TODO futuro: opção do menu administrativo.
        throw new UnsupportedOperationException("Atualização de filme será implementada depois.");
    }

    public void remover(long id) throws SQLException {
        // TODO futuro: opção do menu administrativo.
        throw new UnsupportedOperationException("Remoção de filme será implementada depois.");
    }
}
