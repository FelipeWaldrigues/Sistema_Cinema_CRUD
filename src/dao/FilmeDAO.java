package dao;

import model.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * DAO do produto do sistema: Filme.
 */
public class FilmeDAO {

    public Optional<Filme> buscarPorId(long id) throws SQLException {
        String sql = "SELECT * FROM filme WHERE id = ?";
        
        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setLong(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapearFilme(rs));
                }
            }
        }
        
        return Optional.empty();
    }

    public List<Filme> buscarPorTitulo(String titulo) throws SQLException {
        String sql = "SELECT * FROM filme WHERE titulo LIKE ?";
        List<Filme> filmes = new ArrayList<>();
        
        try (Connection conn = connection.ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, "%" + titulo + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    filmes.add(mapearFilme(rs));
                }
            }
        }
        
        return filmes;
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
    
    private Filme mapearFilme(ResultSet rs) throws SQLException {
        Filme filme = new Filme();
        filme.setId(rs.getLong("id"));
        filme.setTitulo(rs.getString("titulo"));
        filme.setGenero(rs.getString("genero"));
        filme.setClassificacaoEtaria(rs.getString("classificacao_etaria"));
        filme.setNota(rs.getDouble("nota"));
        filme.setSinopse(rs.getString("sinopse"));
        filme.setEmCartaz(rs.getBoolean("em_cartaz"));
        return filme;
    }
}
