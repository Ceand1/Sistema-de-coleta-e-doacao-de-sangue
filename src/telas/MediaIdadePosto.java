package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.dao.PostoDAO; // Assumindo que você tem um DAO para Posto

public class MediaIdadePosto extends JFrame {
    private PostoDAO postoDAO; // DAO para acessar os dados dos postos

    public MediaIdadePosto(PostoDAO postoDAO) {
        this.postoDAO = postoDAO;

        setTitle("Média de idade por posto");
        setSize(400, 300);
        setLayout(new GridLayout(0, 2));

        JTextField txtRegistroPosto = new JTextField();
        JTextField txtSexo = new JTextField();
        JTextArea txtResultado = new JTextArea(10, 20);
        txtResultado.setEditable(false);

        add(new JLabel("Registro do Posto:"));
        add(txtRegistroPosto);
        add(new JLabel("Sexo:"));
        add(txtSexo);
        add(new JLabel("Resultado:"));
        add(new JScrollPane(txtResultado));

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String registroPosto = txtRegistroPosto.getText();
                String sexo = txtSexo.getText();

                int media = postoDAO.mediaIdadePosto(registroPosto, sexo);
                String resultadoTexto = "Média de idade do posto " + registroPosto + "\n" +
                        "para " + sexo + " " + media;

                txtResultado.setText(resultadoTexto);
            }
        });
        add(btnPesquisar);

        setVisible(true);
    }
}
