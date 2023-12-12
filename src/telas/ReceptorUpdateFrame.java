package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.ReceptorDAO;
import model.entities.Receptor;

public class ReceptorUpdateFrame extends JFrame {
    private Receptor receptor;
    private ReceptorDAO receptorDAO;

    public ReceptorUpdateFrame(Receptor receptor, ReceptorDAO receptorDAO) {
        this.receptor = receptor;
        this.receptorDAO = receptorDAO;

        setTitle("Atualizar Dados do Receptor");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        // Campos de entrada preenchidos com os dados atuais do doador
        JTextField txtPrimeiroNome = new JTextField(receptor.getPrimeiro_nome());
        JTextField txtSobrenome = new JTextField(receptor.getSobrenome());
        JTextField txtCidade = new JTextField(receptor.getCidade());
        JTextField txtEstado = new JTextField(receptor.getEstado());
        JTextField txtRua = new JTextField(receptor.getRua());
        JTextField txtBairro = new JTextField(receptor.getBairro());
        JTextField txtNumero = new JTextField(String.valueOf(receptor.getNumero()));
        JTextField txtCep = new JTextField(receptor.getCep());
        JTextField txtSexo = new JTextField(String.valueOf(receptor.getSexo()));
        JTextField txtTipoSangue = new JTextField(receptor.getTipo_sangue());
        JTextField txtNascimento = new JTextField(receptor.getNascimento());
        JTextField txtNacionalidade = new JTextField(receptor.getNacionalidade());
        JTextField txtEstadoSaude = new JTextField(String.valueOf(receptor.getEstado_saude()));

        // Adicionando campos e rótulos à janela
        // Campos do Usuario
        add(new JLabel("Primeiro Nome:"));
        add(txtPrimeiroNome);
        add(new JLabel("Sobrenome:"));
        add(txtSobrenome);
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
        add(new JLabel("Sexo:"));
        add(txtSexo);
        add(new JLabel("Tipo de Sangue:"));
        add(txtTipoSangue);
        add(new JLabel("Data de Nascimento:"));
        add(txtNascimento);
        add(new JLabel("Nacionalidade:"));
        add(txtNacionalidade);
        // Campos do Doador
        add(new JLabel("Estado de saúde:"));
        add(txtEstadoSaude);

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Atualizar os dados do receptor
                    receptor.setPrimeiro_nome(txtPrimeiroNome.getText());
                    receptor.setSobrenome(txtSobrenome.getText());
                    receptor.setCidade(txtCidade.getText());
                    receptor.setEstado(txtEstado.getText());
                    receptor.setRua(txtRua.getText());
                    receptor.setBairro(txtBairro.getText());
                    receptor.setNumero(Integer.parseInt(txtNumero.getText()));
                    receptor.setCep(txtCep.getText());
                    receptor.setSexo(txtSexo.getText().charAt(0));
                    receptor.setTipo_sangue(txtTipoSangue.getText());
                    receptor.setNascimento(txtNascimento.getText());
                    receptor.setNacionalidade(txtNacionalidade.getText());
                    receptor.setEstado_saude(txtEstadoSaude.getText());

                    // Atualizar o receptor no banco de dados
                    receptorDAO.atualizarReceptor(receptor);
                    JOptionPane.showMessageDialog(ReceptorUpdateFrame.this, "Dados atualizados com sucesso!");
                    dispose(); // Fecha a janela após a atualização
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ReceptorUpdateFrame.this,
                            "Erro ao atualizar os dados: " + ex.getMessage());
                }
            }
        });

        add(btnAtualizar);

        setVisible(true);
    }
}
