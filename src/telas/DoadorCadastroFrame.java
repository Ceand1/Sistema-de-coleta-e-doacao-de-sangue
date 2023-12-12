package telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.dao.DoadorDAO;
import model.dao.Usuario_emailDAO;
import model.entities.Doador;
import model.entities.Usuario_email;

public class DoadorCadastroFrame extends JFrame {
    private DoadorDAO doadorDAO;
    private Usuario_emailDAO usuario_emailDAO;

    public DoadorCadastroFrame(DoadorDAO doadorDAO, Usuario_emailDAO usuario_emailDAO) {
        this.doadorDAO = doadorDAO;
        this.usuario_emailDAO = usuario_emailDAO;

        setTitle("Cadastro de Doador");
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
        JTextField txtAltura = new JTextField(5);
        JTextField txtPeso = new JTextField(5);
        JTextField txtEstadoCivil = new JTextField(20);
        JTextField txtNDoacoes = new JTextField(5);
        JTextField txtEmail = new JTextField(30);

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

        add(new JLabel("Altura:"));
        add(txtAltura);
        add(new JLabel("Peso:"));
        add(txtPeso);
        add(new JLabel("Estado Civil:"));
        add(txtEstadoCivil);
        add(new JLabel("Número de Doações:"));
        add(txtNDoacoes);
        add(new JLabel("Email:"));
        add(txtEmail);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Doador novoDoador = new Doador();
                    Usuario_email novoUsuario_email = new Usuario_email();
                    // Configurando os atributos do doador
                    novoDoador.setCpf(txtCpf.getText());
                    novoDoador.setPrimeiro_nome(txtPrimeiroNome.getText());
                    novoDoador.setSobrenome(txtSobrenome.getText());
                    novoDoador.setCidade(txtCidade.getText());
                    novoDoador.setEstado(txtEstado.getText());
                    novoDoador.setRua(txtRua.getText());
                    novoDoador.setBairro(txtBairro.getText());
                    novoDoador.setNumero(Integer.parseInt(txtNumero.getText()));
                    novoDoador.setCep(txtCep.getText());
                    novoDoador.setSexo(txtSexo.getText().charAt(0));
                    novoDoador.setTipo_sangue(txtTipoSangue.getText());
                    novoDoador.setNascimento(txtNascimento.getText());
                    novoDoador.setNacionalidade(txtNacionalidade.getText());
                    novoDoador.setAltura(Float.parseFloat(txtAltura.getText()));
                    novoDoador.setPeso(Float.parseFloat(txtPeso.getText()));
                    novoDoador.setEstado_civil(txtEstadoCivil.getText());
                    novoDoador.setN_doacoes(Integer.parseInt(txtNDoacoes.getText()));
                    novoUsuario_email.setEmail(txtEmail.getText());

                    // Salvar o doador no banco de dados
                    usuario_emailDAO.adicionarUsuario_email(novoUsuario_email);
                    doadorDAO.adicionarDoador(novoDoador);
                    JOptionPane.showMessageDialog(DoadorCadastroFrame.this, "Doador cadastrado com sucesso!");
                    dispose(); // Fecha a janela após o cadastro
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DoadorCadastroFrame.this,
                            "Erro ao cadastrar doador: " + ex.getMessage());
                }
            }
        });

        add(btnCadastrar);

        setVisible(true);
    }
}
