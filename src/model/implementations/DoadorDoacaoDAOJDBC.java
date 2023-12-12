package model.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.DoadorDoacaoDAO;
import model.entities.DoadorDoacao;

public class DoadorDoacaoDAOJDBC implements DoadorDoacaoDAO {
    private Connection connection;

    public DoadorDoacaoDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarDoadorDoacao(DoadorDoacao doadorDoacao) {
        String sql = "INSERT INTO Doador_Doacao (cpf_doador, registro_posto, tipo_sangue) VALUES (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            // Inserindo na tabela Usuario
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, doadorDoacao.getCpfDoador());
                pstmt.setString(2, doadorDoacao.getRegistroPosto());
                pstmt.setString(3, doadorDoacao.getTipoSangue());
                pstmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<DoadorDoacao> listarTodos() {
        List<DoadorDoacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM Doador_Doacao";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                DoadorDoacao dd = new DoadorDoacao();
                dd.setCpfDoador(rs.getString("cpf_doador"));
                dd.setRegistroPosto(rs.getString("registro_posto"));
                dd.setDataDoacao(rs.getTimestamp("data_doacao"));
                dd.setTipoSangue(rs.getString("tipo_sangue"));
                lista.add(dd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void atualizarDoadorDoacao(DoadorDoacao doadorDoacao) {
        String sql = "UPDATE Doador_Doacao SET registro_posto = ?, tipo_sangue = ? WHERE cpf_doador = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, doadorDoacao.getRegistroPosto());
            pstmt.setString(2, doadorDoacao.getTipoSangue());
            pstmt.setString(3, doadorDoacao.getCpfDoador());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerDoadorDoacao(String cpfDoador) {
        String sql = "DELETE FROM Doador_Doacao WHERE cpf_doador = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpfDoador);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int quantDoacao(String registro_posto, String sexo) {
        String sql = "SELECT SUM(conta) as soma FROM SumCount WHERE registro_posto like ? and sexo like ? ";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + registro_posto + "%");
            pstmt.setString(2, "%" + sexo + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("soma");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 se não encontrar ou em caso de erro
    }
}
