package model.implementations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ReceptorDAO;
import model.entities.Posto;
import model.entities.Receptor;
import model.entities.ReceptorRecebe;
import model.entities.Usuario;

public class ReceptorDAOJDBC implements ReceptorDAO {
    private Connection connection;

    public ReceptorDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarReceptor(Receptor receptor) {
        String sqlUsuario = "INSERT INTO Usuario (cpf, primeiro_nome, sobrenome, cidade, estado, rua, bairro, numero, cep, sexo, tipo_sangue, nascimento, nacionalidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlReceptor = "INSERT INTO Receptor (cpf_receptor, estado_saude) VALUES (?, ?)";

        try {
            connection.setAutoCommit(false);

            // Inserindo na tabela Usuario
            try (PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, receptor.getCpf());
                pstmtUsuario.setString(2, receptor.getPrimeiro_nome());
                pstmtUsuario.setString(3, receptor.getSobrenome());
                pstmtUsuario.setString(4, receptor.getCidade());
                pstmtUsuario.setString(5, receptor.getEstado());
                pstmtUsuario.setString(6, receptor.getRua());
                pstmtUsuario.setString(7, receptor.getBairro());
                pstmtUsuario.setInt(8, receptor.getNumero());
                pstmtUsuario.setString(9, receptor.getCep());
                pstmtUsuario.setString(10, String.valueOf(receptor.getSexo()));
                pstmtUsuario.setString(11, receptor.getTipo_sangue());
                pstmtUsuario.setDate(12, Date.valueOf(receptor.getNascimento()));
                pstmtUsuario.setString(13, receptor.getNacionalidade());
                pstmtUsuario.executeUpdate();
            }

            // Inserindo na tabela Doador
            try (PreparedStatement pstmtReceptor = connection.prepareStatement(sqlReceptor)) {
                pstmtReceptor.setString(1, receptor.getCpf());
                pstmtReceptor.setString(2, receptor.getEstado_saude());
                pstmtReceptor.executeUpdate();
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
    public Receptor buscarReceptor(String cpf) {
        String sql = "SELECT * FROM Usuario u JOIN Receptor d ON u.cpf = d.cpf_receptor WHERE u.cpf = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Receptor receptor = new Receptor();
                // Atributos de Usuario
                receptor.setCpf(rs.getString("cpf"));
                receptor.setPrimeiro_nome(rs.getString("primeiro_nome"));
                receptor.setSobrenome(rs.getString("sobrenome"));
                receptor.setCidade(rs.getString("cidade"));
                receptor.setEstado(rs.getString("estado"));
                receptor.setRua(rs.getString("rua"));
                receptor.setBairro(rs.getString("bairro"));
                receptor.setNumero(rs.getInt("numero"));
                receptor.setCep(rs.getString("cep"));
                receptor.setSexo(rs.getString("sexo").charAt(0));
                receptor.setTipo_sangue(rs.getString("tipo_sangue"));
                receptor.setNascimento(rs.getDate("nascimento").toString());
                receptor.setNacionalidade(rs.getString("nacionalidade"));
                // Atributos de Doador
                receptor.setEstado_saude(rs.getString("estado_saude"));
                return receptor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Usuario> listarReceptorPosto(String n_registro) {
        String sql = "SELECT * FROM ReceptorPostos WHERE registro_posto = ?";
        List<Usuario> usuarios = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, n_registro);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                usuarios.add(
                    new Usuario(
                        rs.getString("cpf_receptor"), 
                        rs.getString("primeiro_nome"), 
                        rs.getString("sobrenome"), 
                        rs.getString("cidade"), 
                        rs.getString("estado"), 
                        rs.getString("rua"), 
                        rs.getString("bairro"), 
                        rs.getInt("numero"),
                        rs.getString("cep"),
                        rs.getString("sexo").charAt(0),
                        rs.getString("tipo_sangue"),
                        rs.getString("nacionalidade"),
                        rs.getString("estado_saude")
                        )
                    );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public List<ReceptorRecebe> listarReceptorRecebe(String n_registro) {
        String sql = "SELECT * FROM ReceptorRecebe WHERE registro_posto = ?";
        List<ReceptorRecebe> receptors = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, n_registro);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                receptors.add(
                    new ReceptorRecebe(
                        rs.getString("cpf_receptor"), 
                        rs.getString("tipo_sangue"),
                        rs.getTimestamp("data_receber"),
                        rs.getString("registro_posto")
                        ).comNome(rs.getString("primeiro_nome")).comSobrenome(
                        rs.getString("sobrenome"))
                    );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return receptors;
    }

    @Override
    public void atualizarReceptor(Receptor receptor) {
        String sqlUsuario = "UPDATE Usuario SET primeiro_nome = ?, sobrenome = ?, cidade = ?, estado = ?, rua = ?, bairro = ?, numero = ?, cep = ?, sexo = ?, tipo_sangue = ?, nascimento = ?, nacionalidade = ? WHERE cpf = ?";
        String sqlReceptor = "UPDATE Receptor SET estado_saude = ? WHERE cpf_receptor = ?";

        try {
            connection.setAutoCommit(false);

            // Atualizando na tabela Usuario
            try (PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, receptor.getPrimeiro_nome());
                pstmtUsuario.setString(2, receptor.getSobrenome());
                pstmtUsuario.setString(3, receptor.getCidade());
                pstmtUsuario.setString(4, receptor.getEstado());
                pstmtUsuario.setString(5, receptor.getRua());
                pstmtUsuario.setString(6, receptor.getBairro());
                pstmtUsuario.setInt(7, receptor.getNumero());
                pstmtUsuario.setString(8, receptor.getCep());
                pstmtUsuario.setString(9, String.valueOf(receptor.getSexo()));
                pstmtUsuario.setString(10, receptor.getTipo_sangue());
                pstmtUsuario.setDate(11, Date.valueOf(receptor.getNascimento()));
                pstmtUsuario.setString(12, receptor.getNacionalidade());
                pstmtUsuario.setString(13, receptor.getCpf());
                pstmtUsuario.executeUpdate();
            }

            // Atualizando na tabela Doador
            try (PreparedStatement pstmtReceptor = connection.prepareStatement(sqlReceptor)) {
                pstmtReceptor.setString(1, receptor.getEstado_saude());
                pstmtReceptor.setString(2, receptor.getCpf());
                pstmtReceptor.executeUpdate();
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
    public void removerReceptor(String cpf) {
        String sqlRecebe = "DELETE FROM receptor_recebe WHERE cpf_receptor = ?";
        String sqlReceptor = "DELETE FROM Receptor WHERE cpf_receptor = ?";
        String sqlUsuario = "DELETE FROM Usuario WHERE cpf = ?";

        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmtReceptorRecebe = connection.prepareStatement(sqlRecebe)) {
                pstmtReceptorRecebe.setString(1, cpf);
                pstmtReceptorRecebe.executeUpdate();
            }

            // Removendo da tabela Doador
            try (PreparedStatement pstmtReceptor = connection.prepareStatement(sqlReceptor)) {
                pstmtReceptor.setString(1, cpf);
                pstmtReceptor.executeUpdate();
            }

            // Removendo da tabela Usuario
            try (PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, cpf);
                pstmtUsuario.executeUpdate();
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
