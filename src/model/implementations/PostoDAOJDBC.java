package model.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.PostoDAO;
import model.entities.Posto;
import model.entities.Usuario;

public class PostoDAOJDBC implements PostoDAO {
    private Connection connection;

    public PostoDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarPosto(Posto posto) {
        String sqlPosto = "INSERT INTO Posto (n_registro, cidade, estado, rua, bairro, numero, cep, n_doações) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            // Inserindo na tabela Usuario
            try (PreparedStatement pstmtPosto = connection.prepareStatement(sqlPosto)) {
                pstmtPosto.setString(1, posto.getN_registro());
                pstmtPosto.setString(2, posto.getCidade());
                pstmtPosto.setString(3, posto.getEstado());
                pstmtPosto.setString(4, posto.getRua());
                pstmtPosto.setString(5, posto.getBairro());
                pstmtPosto.setInt(6, posto.getNumero());
                pstmtPosto.setString(7, posto.getCep());
                pstmtPosto.setInt(8, posto.getN_doacoes());
                pstmtPosto.executeUpdate();
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
    public Posto buscarPosto(String n_registro) {
        String sql = "SELECT * FROM Posto WHERE n_registro = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, n_registro);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Posto posto = new Posto();
                // Atributos de Usuario
                posto.setN_registro(rs.getString("n_registro"));
                posto.setCidade(rs.getString("cidade"));
                posto.setEstado(rs.getString("estado"));
                posto.setRua(rs.getString("rua"));
                posto.setBairro(rs.getString("bairro"));
                posto.setNumero(rs.getInt("numero"));
                posto.setCep(rs.getString("cep"));
                posto.setN_doacoes(rs.getInt("n_doações"));
                return posto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Posto> buscarPostosNaCidade(String cidade) {
        String sql = "SELECT * FROM Posto WHERE cidade = ?";
        List<Posto> postos = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cidade);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                postos.add(
                    new Posto(
                        rs.getString("n_registro"), 
                        rs.getString("cidade"), 
                        rs.getString("estado"), 
                        rs.getString("rua"), 
                        rs.getString("bairro"), 
                        rs.getInt("numero"), 
                        rs.getString("cep"), 
                        rs.getInt("n_doações")
                        )
                    );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return postos;
    }

    @Override
    public void atualizarPosto(Posto posto) {
        String sqlPosto = "UPDATE Posto SET cidade = ?, estado = ?, rua = ?, bairro = ?, numero = ?, cep = ?, n_doações = ? WHERE n_registro = ?";

        try {
            connection.setAutoCommit(false);

            // Atualizando na tabela Usuario
            try (PreparedStatement pstmtPosto = connection.prepareStatement(sqlPosto)) {
                pstmtPosto.setString(1, posto.getCidade());
                pstmtPosto.setString(2, posto.getEstado());
                pstmtPosto.setString(3, posto.getRua());
                pstmtPosto.setString(4, posto.getBairro());
                pstmtPosto.setInt(5, posto.getNumero());
                pstmtPosto.setString(6, posto.getCep());
                pstmtPosto.setInt(7, posto.getN_doacoes());
                pstmtPosto.setString(8, posto.getN_registro());
                pstmtPosto.executeUpdate();
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
    public void removerPosto(String n_registro) {
        String sqlPostoEstoque = "DELETE FROM Posto_estoque WHERE n_registro = ?";
        String sqldoadorDoacao = "DELETE FROM doador_doacao WHERE n_registro = ?";
        String sqlRecebe = "DELETE FROM receptor_recebe WHERE n_registro = ?";
        String sqlPosto = "DELETE FROM Posto WHERE n_registro = ?";

        try {
            connection.setAutoCommit(false);
            try (PreparedStatement pstmtPostoEstoque = connection.prepareStatement(sqlPostoEstoque)) {
                pstmtPostoEstoque.setString(1, n_registro);
                pstmtPostoEstoque.executeUpdate();
            }

            try (PreparedStatement pstmDoadorDoacao = connection.prepareStatement(sqldoadorDoacao)) {
                pstmDoadorDoacao.setString(1, n_registro);
                pstmDoadorDoacao.executeUpdate();
            }

            try (PreparedStatement pstmtReceptorRecebe = connection.prepareStatement(sqlRecebe)) {
                pstmtReceptorRecebe.setString(1, n_registro);
                pstmtReceptorRecebe.executeUpdate();
            }
            // Removendo da tabela Doador
            try (PreparedStatement pstmtPosto = connection.prepareStatement(sqlPosto)) {
                pstmtPosto.setString(1, n_registro);
                pstmtPosto.executeUpdate();
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
    public int pesquisarQuantidadeSangue(String registroPosto, String tipoSangue) {
        String sql = "SELECT quant_sangue FROM PostoEstoqueView WHERE tipo_sangue LIKE ? AND n_registro LIKE ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + tipoSangue + "%");
            pstmt.setString(2, "%" + registroPosto + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("quant_sangue");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 se não encontrar ou em caso de erro
    }

    @Override
    public int pesquisarQuantidadeDoacoes(String registroPosto) {
        String sql = "SELECT n_registro, COUNT(cpf_doador) as quant FROM postodoacaoview WHERE n_registro LIKE ? GROUP BY n_registro";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + registroPosto + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("quant");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 se não encontrar ou em caso de erro
    }

    @Override
    public int mediaIdadePosto(String registro_posto, String sexo) {
        String sql = "SELECT AVG(EXTRACT(YEAR FROM age(now(), nascimento))) as media FROM IdadeMediaPosto WHERE sexo like ? and registro_posto like ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + sexo + "%");
            pstmt.setString(2, "%" + registro_posto + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("media");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Retorna 0 se não encontrar ou em caso de erro
    }

}
