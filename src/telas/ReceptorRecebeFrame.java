package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.ReceptorRecebeDAO;
import model.entities.ReceptorRecebe;

public class ReceptorRecebeFrame extends JFrame {
    private ReceptorRecebeDAO receptorRecebeDAO;
    private String cpfReceptor; // CPF do Doador

    public ReceptorRecebeFrame(ReceptorRecebeDAO receptorRecebeDAO, String cpfReceptor) {
        this.receptorRecebeDAO = receptorRecebeDAO;
        this.cpfReceptor = cpfReceptor;

        setTitle("Cadastro de Recebimento");
        setSize(400, 400);
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
                    ReceptorRecebe novaRecebimento = new ReceptorRecebe();
                    // Configurando os atributos da doação
                    novaRecebimento.setCpfReceptor(cpfReceptor);
                    novaRecebimento.setRegistroPosto(txtRegistroPosto.getText());
                    novaRecebimento.setTipoSangue(txtTipoSangue.getText());

                    // Salvar a doação no banco de dados
                    receptorRecebeDAO.adicionarReceptorRecebe(novaRecebimento);
                    JOptionPane.showMessageDialog(ReceptorRecebeFrame.this, "Recepção cadastrada com sucesso!");
                    dispose(); // Fecha a janela após o cadastro
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ReceptorRecebeFrame.this,
                            "Erro ao cadastrar recepção: " + ex.getMessage());
                }
            }
        });

        add(btnCadastrar);

        setVisible(true);
    }
}
