package model.implementations;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.DoadorDAO;
import model.entities.Doador;
import model.entities.DoadorDoacao;
import model.entities.ReceptorRecebe;

public class DoadorDAOJDBC implements DoadorDAO {
    private Connection connection;

    public DoadorDAOJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void adicionarDoador(Doador doador) {
        String sqlUsuario = "INSERT INTO Usuario (cpf, primeiro_nome, sobrenome, cidade, estado, rua, bairro, numero, cep, sexo, tipo_sangue, nascimento, nacionalidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlDoador = "INSERT INTO Doador (cpf_doador, altura, peso, estado_civil, n_doacoes) VALUES (?, ?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            // Inserindo na tabela Usuario
            try (PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, doador.getCpf());
                pstmtUsuario.setString(2, doador.getPrimeiro_nome());
                pstmtUsuario.setString(3, doador.getSobrenome());
                pstmtUsuario.setString(4, doador.getCidade());
                pstmtUsuario.setString(5, doador.getEstado());
                pstmtUsuario.setString(6, doador.getRua());
                pstmtUsuario.setString(7, doador.getBairro());
                pstmtUsuario.setInt(8, doador.getNumero());
                pstmtUsuario.setString(9, doador.getCep());
                pstmtUsuario.setString(10, String.valueOf(doador.getSexo()));
                pstmtUsuario.setString(11, doador.getTipo_sangue());
                pstmtUsuario.setDate(12, Date.valueOf(doador.getNascimento()));
                pstmtUsuario.setString(13, doador.getNacionalidade());
                pstmtUsuario.executeUpdate();
            }

            // Inserindo na tabela Doador
            try (PreparedStatement pstmtDoador = connection.prepareStatement(sqlDoador)) {
                pstmtDoador.setString(1, doador.getCpf());
                pstmtDoador.setFloat(2, doador.getAltura());
                pstmtDoador.setFloat(3, doador.getPeso());
                pstmtDoador.setString(4, doador.getEstado_civil());
                pstmtDoador.setInt(5, doador.getN_doacoes());
                pstmtDoador.executeUpdate();
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
    public Doador buscarDoador(String cpf) {
        String sql = "SELECT * FROM Usuario u JOIN Doador d ON u.cpf = d.cpf_doador WHERE u.cpf = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Doador doador = new Doador();
                // Atributos de Usuario
                doador.setCpf(rs.getString("cpf"));
                doador.setPrimeiro_nome(rs.getString("primeiro_nome"));
                doador.setSobrenome(rs.getString("sobrenome"));
                doador.setCidade(rs.getString("cidade"));
                doador.setEstado(rs.getString("estado"));
                doador.setRua(rs.getString("rua"));
                doador.setBairro(rs.getString("bairro"));
                doador.setNumero(rs.getInt("numero"));
                doador.setCep(rs.getString("cep"));
                doador.setSexo(rs.getString("sexo").charAt(0));
                doador.setTipo_sangue(rs.getString("tipo_sangue"));
                doador.setNascimento(rs.getDate("nascimento").toString());
                doador.setNacionalidade(rs.getString("nacionalidade"));
                // Atributos de Doador
                doador.setAltura(rs.getFloat("altura"));
                doador.setPeso(rs.getFloat("peso"));
                doador.setEstado_civil(rs.getString("estado_civil"));
                doador.setN_doacoes(rs.getInt("n_doacoes"));
                return doador;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void atualizarDoador(Doador doador) {
        String sqlUsuario = "UPDATE Usuario SET primeiro_nome = ?, sobrenome = ?, cidade = ?, estado = ?, rua = ?, bairro = ?, numero = ?, cep = ?, sexo = ?, tipo_sangue = ?, nascimento = ?, nacionalidade = ? WHERE cpf = ?";
        String sqlDoador = "UPDATE Doador SET altura = ?, peso = ?, estado_civil = ?, n_doacoes = ? WHERE cpf_doador = ?";

        try {
            connection.setAutoCommit(false);

            // Atualizando na tabela Usuario
            try (PreparedStatement pstmtUsuario = connection.prepareStatement(sqlUsuario)) {
                pstmtUsuario.setString(1, doador.getPrimeiro_nome());
                pstmtUsuario.setString(2, doador.getSobrenome());
                pstmtUsuario.setString(3, doador.getCidade());
                pstmtUsuario.setString(4, doador.getEstado());
                pstmtUsuario.setString(5, doador.getRua());
                pstmtUsuario.setString(6, doador.getBairro());
                pstmtUsuario.setInt(7, doador.getNumero());
                pstmtUsuario.setString(8, doador.getCep());
                pstmtUsuario.setString(9, String.valueOf(doador.getSexo()));
                pstmtUsuario.setString(10, doador.getTipo_sangue());
                pstmtUsuario.setDate(11, Date.valueOf(doador.getNascimento()));
                pstmtUsuario.setString(12, doador.getNacionalidade());
                pstmtUsuario.setString(13, doador.getCpf());
                pstmtUsuario.executeUpdate();
            }

            // Atualizando na tabela Doador
            try (PreparedStatement pstmtDoador = connection.prepareStatement(sqlDoador)) {
                pstmtDoador.setFloat(1, doador.getAltura());
                pstmtDoador.setFloat(2, doador.getPeso());
                pstmtDoador.setString(3, doador.getEstado_civil());
                pstmtDoador.setInt(4, doador.getN_doacoes());
                pstmtDoador.setString(5, doador.getCpf());
                pstmtDoador.executeUpdate();
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
    public void removerDoador(String cpf) {
        String sqlDoacoes = "DELETE FROM doador_doacao WHERE cpf_doador = ?";
        String sqlDoador = "DELETE FROM Doador WHERE cpf_doador = ?";
        String sqlUsuario = "DELETE FROM Usuario WHERE cpf = ?";

        try {
            connection.setAutoCommit(false);

            // Removendo da tabela Doador
            try (PreparedStatement pstmtDoacao = connection.prepareStatement(sqlDoacoes)) {
                pstmtDoacao.setString(1, cpf);
                pstmtDoacao.executeUpdate();
            }
            // Removendo da tabela Doador
            try (PreparedStatement pstmtDoador = connection.prepareStatement(sqlDoador)) {
                pstmtDoador.setString(1, cpf);
                pstmtDoador.executeUpdate();
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

    @Override
    public List<DoadorDoacao> listarDoadorDoacao(String n_registro) {
        String sql = "SELECT * FROM DoadorDoacao WHERE registro_posto = ?";
        List<DoadorDoacao> doacoes = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, n_registro);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                doacoes.add(
                    new DoadorDoacao(
                        rs.getString("cpf_doador"), 
                        rs.getString("tipo_sangue"),
                        rs.getTimestamp("data_doacao"),
                        rs.getString("registro_posto")
                        ).comNome(rs.getString("primeiro_nome")).comSobrenome(
                        rs.getString("sobrenome"))
                    );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return doacoes;
    }

    @Override
    public int mediaIdadeSexo(String sexo) {
        String sql = "SELECT AVG(EXTRACT(YEAR FROM age(now(), nascimento))) as media FROM IdadeMediaSexo WHERE sexo like ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, "%" + sexo + "%");

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
