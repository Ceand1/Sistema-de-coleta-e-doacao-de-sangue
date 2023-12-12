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
import model.entities.Posto;

public class LoginFrame3 extends JFrame {
    private DoadorDAO DoadorDAO;
    private ReceptorDAO ReceptorDAO;
    private PostoDAO PostoDAO;
    private Usuario_emailDAO Usuario_emailDAO;
    private DoadorDoacaoDAO DoadorDoacaoDAO;
    private ReceptorRecebeDAO ReceptorRecebeDAO;

    public LoginFrame3(DoadorDAO DoadorDAO, ReceptorDAO ReceptorDAO, PostoDAO PostoDAO,
            Usuario_emailDAO Usuario_emailDAO, DoadorDoacaoDAO DoadorDoacaoDAO, ReceptorRecebeDAO ReceptorRecebeDAO) {
        this.DoadorDAO = DoadorDAO;
        this.ReceptorDAO = ReceptorDAO;
        this.PostoDAO = PostoDAO;
        this.Usuario_emailDAO = Usuario_emailDAO;
        this.DoadorDoacaoDAO = DoadorDoacaoDAO;
        this.ReceptorRecebeDAO = ReceptorRecebeDAO;

        // Configurações da janela
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Campo para inserir CPF
        JTextField n_registroField = new JTextField(10);
        JButton printButton = new JButton("Mostrar dados");
        JButton cadastroButton = new JButton("Cadastrar Posto");
        JButton updateButton = new JButton("Atualizar Dados");
        JButton deleteButton = new JButton("Deletar Posto");
        JButton btnVoltar = new JButton("Voltar");

        // Adiciona componentes à janela
        add(new JLabel("Digite seu número de registro:"));
        add(n_registroField);
        add(printButton);
        add(cadastroButton);
        add(updateButton);
        add(deleteButton);
        add(btnVoltar);

        // Evento do botão de login
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n_registro = n_registroField.getText();
                Posto posto = PostoDAO.buscarPosto(n_registro);
                if (posto != null) {
                    // Mostra a tela com os dados do usuário
                    new UserDataFrame3(posto).setVisible(true);
                    // dispose(); // Fecha a tela de login
                } else {
                    JOptionPane.showMessageDialog(LoginFrame3.this, "Número de registro não encontrado.");
                }
            }
        });

        cadastroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PostoCadastroFrame(PostoDAO).setVisible(true);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n_registro = n_registroField.getText();
                Posto posto = PostoDAO.buscarPosto(n_registro);
                if (posto != null) {
                    new PostoUpdateFrame(posto, PostoDAO).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(LoginFrame3.this, "Número de registro não encontrado.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n_registro = n_registroField.getText();
                int confirm = JOptionPane.showConfirmDialog(LoginFrame3.this,
                        "Tem certeza que deseja deletar o posto com número de registro: " + n_registro + "?",
                        "Confirmar Exclusão",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    try {
                        PostoDAO.removerPosto(n_registro);
                        JOptionPane.showMessageDialog(LoginFrame3.this, "Posto deletado com sucesso.");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(LoginFrame3.this, "Erro ao deletar Posto: " + ex.getMessage());
                    }
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
