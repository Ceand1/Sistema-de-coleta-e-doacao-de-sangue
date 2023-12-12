package model.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Usuario_emailDAO;
import model.entities.Usuario_email;

public class Usuario_emailDAOJDBC implements Usuario_emailDAO {
    private Connection connection;

    public Usuario_emailDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarUsuario_email(Usuario_email usuario_email) {
        String sqlUsuario_email = "INSERT INTO Usuario_email (cpf_usuario, email) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false);

            // Inserindo na tabela Usuario
            try (PreparedStatement pstmtUsuario_email = connection.prepareStatement(sqlUsuario_email)) {
                pstmtUsuario_email.setString(1, usuario_email.getCpfUsuario());
                pstmtUsuario_email.setString(2, usuario_email.getEmail());
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
    public Usuario_email buscarUsuario_email(String cpf) {
        String sql = "SELECT email FROM Usuario_email WHERE cpf_usuario = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Usuario_email usuario_email = new Usuario_email();
                // Atributos de Usuario
                usuario_email.setEmail(rs.getString("email"));
                return usuario_email;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atualizarUsuario_email(Usuario_email usuario_email) {
        String sqlUsuario_email = "UPDATE Usuario_email SET email = ? WHERE cpf_usuario = ?";

        try {
            connection.setAutoCommit(false);

            // Atualizando na tabela Usuario
            try (PreparedStatement pstmtUsuario_email = connection.prepareStatement(sqlUsuario_email)) {
                pstmtUsuario_email.setString(1, usuario_email.getEmail());
                pstmtUsuario_email.setString(2, usuario_email.getCpfUsuario());
                pstmtUsuario_email.executeUpdate();
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
    public void removerUsuario_email(String cpf) {
        String sqlUsuario_email = "DELETE FROM Usuario_email WHERE cpf_usuario = ?";

        try {
            connection.setAutoCommit(false);

            // Removendo da tabela Doador
            try (PreparedStatement pstmtUsuario_email = connection.prepareStatement(sqlUsuario_email)) {
                pstmtUsuario_email.setString(1, cpf);
                pstmtUsuario_email.executeUpdate();
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
}
