package telas;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.entities.Receptor;

public class UserDataFrame2 extends JFrame {
    public UserDataFrame2(Receptor receptor) {
        // Configurações da janela
        setTitle("Dados do Receptor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Exibe informações do usuário
        add(new JLabel("CPF: " + receptor.getCpf()));
        add(new JLabel("Nome: " + receptor.getPrimeiro_nome() + " " + receptor.getSobrenome()));
        // Adicionar outros campos conforme necessário

        // Exibir a janela
        setVisible(true);
    }
}
