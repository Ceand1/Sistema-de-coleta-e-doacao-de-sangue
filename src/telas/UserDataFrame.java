package telas;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.entities.Doador;

public class UserDataFrame extends JFrame {
    public UserDataFrame(Doador doador) {
        // Configurações da janela
        setTitle("Dados do Doador");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Exibe informações do usuário
        add(new JLabel("CPF: " + doador.getCpf()));
        add(new JLabel("Nome: " + doador.getPrimeiro_nome() + " " + doador.getSobrenome()));
        // Adicionar outros campos conforme necessário

        // Exibir a janela
        setVisible(true);
    }
}
