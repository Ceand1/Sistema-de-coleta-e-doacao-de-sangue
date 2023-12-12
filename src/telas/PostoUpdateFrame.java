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

public class PostoUpdateFrame extends JFrame {
    private Posto posto;
    private PostoDAO postoDAO;

    public PostoUpdateFrame(Posto posto, PostoDAO postoDAO) {
        this.posto = posto;
        this.postoDAO = postoDAO;

        setTitle("Atualizar Dados do Posto");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        // Campos de entrada preenchidos com os dados atuais do doador
        JTextField txtCidade = new JTextField(posto.getCidade());
        JTextField txtEstado = new JTextField(posto.getEstado());
        JTextField txtRua = new JTextField(posto.getRua());
        JTextField txtBairro = new JTextField(posto.getBairro());
        JTextField txtNumero = new JTextField(String.valueOf(posto.getNumero()));
        JTextField txtCep = new JTextField(posto.getCep());
        JTextField txtN_doacoes = new JTextField(String.valueOf(posto.getN_doacoes()));

        // Adicionando campos e rótulos à janela
        // Campos do Usuario
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
        add(new JLabel("Número doações:"));
        add(txtN_doacoes);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Atualizar os dados do receptor
                    posto.setCidade(txtCidade.getText());
                    posto.setEstado(txtEstado.getText());
                    posto.setRua(txtRua.getText());
                    posto.setBairro(txtBairro.getText());
                    posto.setNumero(Integer.parseInt(txtNumero.getText()));
                    posto.setCep(txtCep.getText());
                    posto.setN_doacoes(Integer.parseInt(txtN_doacoes.getText()));

                    // Atualizar o receptor no banco de dados
                    postoDAO.atualizarPosto(posto);
                    JOptionPane.showMessageDialog(PostoUpdateFrame.this, "Dados atualizados com sucesso!");
                    dispose(); // Fecha a janela após a atualização
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(PostoUpdateFrame.this,
                            "Erro ao atualizar os dados: " + ex.getMessage());
                }
            }
        });

        add(btnAtualizar);

        setVisible(true);
    }
}
