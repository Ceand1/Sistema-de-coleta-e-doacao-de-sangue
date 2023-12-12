package telas;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.entities.Posto;

public class UserDataFrame3 extends JFrame {
    public UserDataFrame3(Posto posto) {
        // Configurações da janela
        setTitle("Dados do Posto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Exibe informações do usuário
        add(new JLabel("Número de registro: " + posto.getN_registro()));
        add(new JLabel("Cidade: " + posto.getCidade()));
        // Adicionar outros campos conforme necessário

        // Exibir a janela
        setVisible(true);
    }
}
