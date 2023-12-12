package model.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ReceptorRecebeDAO;
import model.entities.ReceptorRecebe;

public class ReceptorRecebeDAOJDBC implements ReceptorRecebeDAO {
    private Connection connection;

    public ReceptorRecebeDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarReceptorRecebe(ReceptorRecebe receptorRecebe) {
        String sql = "INSERT INTO Receptor_recebe (cpf_receptor, registro_posto, tipo_sangue) VALUES (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            // Inserindo na tabela Usuario
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setString(1, receptorRecebe.getCpfReceptor());
                pstmt.setString(2, receptorRecebe.getRegistroPosto());
                pstmt.setString(3, receptorRecebe.getTipoSangue());
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
    public List<ReceptorRecebe> listarTodos() {
        List<ReceptorRecebe> lista = new ArrayList<>();
        String sql = "SELECT * FROM Receptor_recebe";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ReceptorRecebe rr = new ReceptorRecebe();
                rr.setCpfReceptor(rs.getString("cpf_receptor"));
                rr.setRegistroPosto(rs.getString("registro_posto"));
                rr.setDataReceber(rs.getTimestamp("data_receber"));
                rr.setTipoSangue(rs.getString("tipo_sangue"));
                lista.add(rr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void atualizarReceptorRecebe(ReceptorRecebe receptorRecebe) {
        String sql = "UPDATE Receptor_recebe SET registro_posto = ?, tipo_sangue = ? WHERE cpf_receptor = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, receptorRecebe.getRegistroPosto());
            pstmt.setString(2, receptorRecebe.getTipoSangue());
            pstmt.setString(3, receptorRecebe.getCpfReceptor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerReceptorRecebe(String cpfReceptor) {
        String sql = "DELETE FROM Receptor_recebe WHERE cpf_receptor = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpfReceptor);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
