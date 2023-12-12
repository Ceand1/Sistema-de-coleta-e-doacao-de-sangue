package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.DoadorDAO;
import model.dao.DoadorDoacaoDAO;
import model.dao.PostoDAO;
import model.dao.ReceptorDAO;
import model.dao.ReceptorRecebeDAO;
import model.dao.Usuario_emailDAO;
import model.entities.Doador;
import model.entities.Usuario_email;

public class LoginFrame extends JFrame {
    private DoadorDAO DoadorDAO;
    private ReceptorDAO ReceptorDAO;
    private PostoDAO PostoDAO;
    private Usuario_emailDAO Usuario_emailDAO;
    private DoadorDoacaoDAO DoadorDoacaoDAO;
    private ReceptorRecebeDAO ReceptorRecebeDAO;

    public LoginFrame(DoadorDAO DoadorDAO, ReceptorDAO ReceptorDAO, PostoDAO PostoDAO,
            Usuario_emailDAO Usuario_emailDAO, DoadorDoacaoDAO DoadorDoacaoDAO, ReceptorRecebeDAO ReceptorRecebeDAO) {
        this.DoadorDAO = DoadorDAO;
        this.ReceptorDAO = ReceptorDAO;
        this.PostoDAO = PostoDAO;
        this.Usuario_emailDAO = Usuario_emailDAO;
        this.DoadorDoacaoDAO = DoadorDoacaoDAO;
        this.ReceptorRecebeDAO = ReceptorRecebeDAO;

        // Configurações da janela
        setTitle("Login");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Campo para inserir CPF
        JTextField cpfField = new JTextField(11);
        JButton printButton = new JButton("Mostrar dados");
        JButton cadastroButton = new JButton("Cadastrar Doador");
        JButton updateButton = new JButton("Atualizar Dados");
        JButton deleteButton = new JButton("Deletar Doador");
        JButton doarButton = new JButton("Doar");
        JButton btnVoltar = new JButton("Voltar");

        // Adiciona componentes à janela
        add(new JLabel("Digite seu CPF:"));
        add(cpfField);
        add(printButton);
        add(cadastroButton);
        add(updateButton);
        add(deleteButton);
        add(doarButton);
        add(btnVoltar);

        // Evento do botão de login
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                Doador doador = DoadorDAO.buscarDoador(cpf);
                if (doador != null) {
                    // Mostra a tela com os dados do usuário
                    new UserDataFrame(doador).setVisible(true);
                    // dispose(); // Fecha a tela de login
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "CPF não encontrado.");
                }
            }
        });

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DoadorCadastroFrame(DoadorDAO, Usuario_emailDAO).setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                Doador doador = DoadorDAO.buscarDoador(cpf);
                Usuario_email usuario_email = Usuario_emailDAO.buscarUsuario_email(cpf);
                if (doador != null) {
                    new DoadorUpdateFrame(doador, DoadorDAO, usuario_email, Usuario_emailDAO).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "CPF não encontrado.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                int confirm = JOptionPane.showConfirmDialog(LoginFrame.this,
                        "Tem certeza que deseja deletar o doador com CPF: " + cpf + "?", "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        Usuario_emailDAO.removerUsuario_email(cpf);
                        DoadorDAO.removerDoador(cpf);
                        JOptionPane.showMessageDialog(LoginFrame.this, "Doador deletado com sucesso.");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(LoginFrame.this, "Erro ao deletar doador: " + ex.getMessage());
                    }
                }
            }
        });

        doarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText();
                Doador doador = DoadorDAO.buscarDoador(cpf);
                Usuario_email usuario_email = Usuario_emailDAO.buscarUsuario_email(cpf);
                if (doador != null) {
                    new DoadorDoarFrame(DoadorDoacaoDAO, cpf).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "CPF não encontrado.");
                }
            }
        });

        btnVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaInicialFrame(DoadorDAO, ReceptorDAO, PostoDAO, Usuario_emailDAO, DoadorDoacaoDAO,
                        ReceptorRecebeDAO)
                        .setVisible(true);
                dispose(); // Fecha a tela de login
            }
        });

        // Exibir a janela
        setVisible(true);
    }
}
