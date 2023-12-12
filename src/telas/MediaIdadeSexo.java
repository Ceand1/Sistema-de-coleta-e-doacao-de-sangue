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

import model.dao.DoadorDAO; // Assumindo que você tem um DAO para Posto

public class MediaIdadeSexo extends JFrame {
    private DoadorDAO doadorDAO; // DAO para acessar os dados dos postos

    public MediaIdadeSexo(DoadorDAO doadorDAO) {
        this.doadorDAO = doadorDAO;

        setTitle("Média de idade por sexo");
        setSize(400, 300);
        setLayout(new GridLayout(0, 2));

        JTextField txtSexo = new JTextField();
        JTextArea txtResultado = new JTextArea(10, 20);
        txtResultado.setEditable(false);

        add(new JLabel("Sexo:"));
        add(txtSexo);
        add(new JLabel("Resultado:"));
        add(new JScrollPane(txtResultado));

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sexo = txtSexo.getText();

                int media = doadorDAO.mediaIdadeSexo(sexo);
                String resultadoTexto = "Média de idade de " + sexo + "\n" + "doadores é "
                        + media + " anos";

                txtResultado.setText(resultadoTexto);
            }
        });
        add(btnPesquisar);

        setVisible(true);
    }
}
