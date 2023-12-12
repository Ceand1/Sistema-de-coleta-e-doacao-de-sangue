package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.PostoDAO;
import model.entities.Posto;

public class PostoCadastroFrame extends JFrame {
    private PostoDAO postoDAO;

    public PostoCadastroFrame(PostoDAO postoDAO) {
        this.postoDAO = postoDAO;

        setTitle("Cadastro de Posto");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        // Campos de entrada para Usuario
        JTextField txtN_registro = new JTextField(10);
        JTextField txtCidade = new JTextField(20);
        JTextField txtEstado = new JTextField(20);
        JTextField txtRua = new JTextField(20);
        JTextField txtBairro = new JTextField(20);
        JTextField txtNumero = new JTextField(5);
        JTextField txtCep = new JTextField(8);
        JTextField txtN_doacoes = new JTextField(20);

        // Adicionando campos e rótulos à janela
        add(new JLabel("Número de registro:"));
        add(txtN_registro);
        add(new JLabel("Cidade:"));
        add(txtCidade);
        add(new JLabel("Estado:"));
        add(txtEstado);
        add(new JLabel("Rua:"));
        add(txtRua);
        add(new JLabel("Bairro:"));
        add(txtBairro);
        add(new JLabel("Número:"));
        add(txtNumero);
        add(new JLabel("CEP:"));
        add(txtCep);
        add(new JLabel("Número de doações:"));
        add(txtN_doacoes);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Posto novoPosto = new Posto();
                    // Configurando os atributos do doador
                    novoPosto.setN_registro(txtN_registro.getText());
                    novoPosto.setCidade(txtCidade.getText());
                    novoPosto.setEstado(txtEstado.getText());
                    novoPosto.setRua(txtRua.getText());
                    novoPosto.setBairro(txtBairro.getText());
                    novoPosto.setNumero(Integer.parseInt(txtNumero.getText()));
                    novoPosto.setCep(txtCep.getText());
                    novoPosto.setN_doacoes(Integer.parseInt(txtN_doacoes.getText()));

                    // Salvar o doador no banco de dados
                    postoDAO.adicionarPosto(novoPosto);
                    JOptionPane.showMessageDialog(PostoCadastroFrame.this, "Posto cadastrado com sucesso!");
                    dispose(); // Fecha a janela após o cadastro
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(PostoCadastroFrame.this,
                            "Erro ao cadastrar posto: " + ex.getMessage());
                }
            }
        });

        add(btnCadastrar);

        setVisible(true);
    }
}
