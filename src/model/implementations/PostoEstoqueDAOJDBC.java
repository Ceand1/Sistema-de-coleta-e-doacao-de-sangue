package model.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.PostoEstoqueDAO;
import model.entities.PostoEstoque;

public class PostoEstoqueDAOJDBC implements PostoEstoqueDAO {
    private Connection connection;

    public PostoEstoqueDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarPostoEstoque(PostoEstoque postoEstoque) {
        String sql = "INSERT INTO Posto_Estoque (registro_posto, quant_sangue, tipo_sangue) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, postoEstoque.getRegistroPosto());
            pstmt.setInt(2, postoEstoque.getQuantSangue());
            pstmt.setString(3, postoEstoque.getTipoSangue());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<PostoEstoque> listarTodos() {
        List<PostoEstoque> lista = new ArrayList<>();
        String sql = "SELECT * FROM Posto_Estoque";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                PostoEstoque pe = new PostoEstoque();
                pe.setRegistroPosto(rs.getString("registro_posto"));
                pe.setQuantSangue(rs.getInt("quant_sangue"));
                pe.setTipoSangue(rs.getString("tipo_sangue"));
                lista.add(pe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void atualizarPostoEstoque(PostoEstoque postoEstoque) {
        String sql = "UPDATE Posto_Estoque SET quant_sangue = ?, tipo_sangue = ? WHERE registro_posto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, postoEstoque.getQuantSangue());
            pstmt.setString(2, postoEstoque.getTipoSangue());
            pstmt.setString(3, postoEstoque.getRegistroPosto());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removerPostoEstoque(String registroPosto) {
        String sql = "DELETE FROM Posto_Estoque WHERE registro_posto = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, registroPosto);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
