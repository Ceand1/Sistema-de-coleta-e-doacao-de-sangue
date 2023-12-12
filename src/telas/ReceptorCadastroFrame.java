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

public class ReceptorCadastroFrame extends JFrame {
    private ReceptorDAO receptorDAO;

    public ReceptorCadastroFrame(ReceptorDAO receptorDAO) {
        this.receptorDAO = receptorDAO;

        setTitle("Cadastro de Receptor");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        // Campos de entrada para Usuario
        JTextField txtCpf = new JTextField(11);
        JTextField txtPrimeiroNome = new JTextField(20);
        JTextField txtSobrenome = new JTextField(20);
        JTextField txtCidade = new JTextField(20);
        JTextField txtEstado = new JTextField(20);
        JTextField txtRua = new JTextField(20);
        JTextField txtBairro = new JTextField(20);
        JTextField txtNumero = new JTextField(5);
        JTextField txtCep = new JTextField(8);
        JTextField txtSexo = new JTextField(1);
        JTextField txtTipoSangue = new JTextField(3);
        JTextField txtNascimento = new JTextField(10); // Formato: YYYY-MM-DD
        JTextField txtNacionalidade = new JTextField(20);

        // Campos de entrada para Doador
        JTextField txtEstadoSaude = new JTextField(20);

        // Adicionando campos e rótulos à janela
        add(new JLabel("CPF:"));
        add(txtCpf);
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

        add(new JLabel("Estado de Saude:"));
        add(txtEstadoSaude);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Receptor novoReceptor = new Receptor();
                    // Configurando os atributos do doador
                    novoReceptor.setCpf(txtCpf.getText());
                    novoReceptor.setPrimeiro_nome(txtPrimeiroNome.getText());
                    novoReceptor.setSobrenome(txtSobrenome.getText());
                    novoReceptor.setCidade(txtCidade.getText());
                    novoReceptor.setEstado(txtEstado.getText());
                    novoReceptor.setRua(txtRua.getText());
                    novoReceptor.setBairro(txtBairro.getText());
                    novoReceptor.setNumero(Integer.parseInt(txtNumero.getText()));
                    novoReceptor.setCep(txtCep.getText());
                    novoReceptor.setSexo(txtSexo.getText().charAt(0));
                    novoReceptor.setTipo_sangue(txtTipoSangue.getText());
                    novoReceptor.setNascimento(txtNascimento.getText());
                    novoReceptor.setNacionalidade(txtNacionalidade.getText());
                    novoReceptor.setEstado_saude(txtEstadoSaude.getText());

                    // Salvar o doador no banco de dados
                    receptorDAO.adicionarReceptor(novoReceptor);
                    JOptionPane.showMessageDialog(ReceptorCadastroFrame.this, "Receptor cadastrado com sucesso!");
                    dispose(); // Fecha a janela após o cadastro
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ReceptorCadastroFrame.this,
                            "Erro ao cadastrar receptor: " + ex.getMessage());
                }
            }
        });

        add(btnCadastrar);

        setVisible(true);
    }
}
