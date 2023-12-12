package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.DoadorDoacaoDAO;
import model.entities.DoadorDoacao;

public class DoadorDoarFrame extends JFrame {
    private DoadorDoacaoDAO doadorDoacaoDAO;
    private String cpfDoador; // CPF do Doador

    public DoadorDoarFrame(DoadorDoacaoDAO doadorDoacaoDAO, String cpfDoador) {
        this.doadorDoacaoDAO = doadorDoacaoDAO;
        this.cpfDoador = cpfDoador;

        setTitle("Cadastro de Doação");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        // Campos de entrada para a doação
        JTextField txtRegistroPosto = new JTextField(10);
        JTextField txtTipoSangue = new JTextField(3);

        // Adicionando campos e rótulos à janela
        add(new JLabel("Registro do Posto:"));
        add(txtRegistroPosto);
        add(new JLabel("Tipo de Sangue:"));
        add(txtTipoSangue);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DoadorDoacao novaDoacao = new DoadorDoacao();
                    // Configurando os atributos da doação
                    novaDoacao.setCpfDoador(cpfDoador);
                    novaDoacao.setRegistroPosto(txtRegistroPosto.getText());
                    novaDoacao.setTipoSangue(txtTipoSangue.getText());

                    // Salvar a doação no banco de dados
                    doadorDoacaoDAO.adicionarDoadorDoacao(novaDoacao);
                    JOptionPane.showMessageDialog(DoadorDoarFrame.this, "Doação cadastrada com sucesso!");
                    dispose(); // Fecha a janela após o cadastro
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DoadorDoarFrame.this,
                            "Erro ao cadastrar doação: " + ex.getMessage());
                }
            }
        });

        add(btnCadastrar);

        setVisible(true);
    }
}
