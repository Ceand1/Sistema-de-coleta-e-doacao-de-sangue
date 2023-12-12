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

public class DoadorUpdateFrame extends JFrame {
    private Doador doador;
    private DoadorDAO doadorDAO;
    private Usuario_email usuario_email;
    private Usuario_emailDAO usuario_emailDAO;

    public DoadorUpdateFrame(Doador doador, DoadorDAO doadorDAO, Usuario_email usuario_email,
            Usuario_emailDAO usuario_emailDAO) {
        this.doador = doador;
        this.doadorDAO = doadorDAO;
        this.usuario_emailDAO = usuario_emailDAO;
        this.usuario_email = usuario_email;

        setTitle("Atualizar Dados do Doador");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(0, 2));

        // Campos de entrada preenchidos com os dados atuais do doador
        JTextField txtPrimeiroNome = new JTextField(doador.getPrimeiro_nome());
        JTextField txtSobrenome = new JTextField(doador.getSobrenome());
        JTextField txtCidade = new JTextField(doador.getCidade());
        JTextField txtEstado = new JTextField(doador.getEstado());
        JTextField txtRua = new JTextField(doador.getRua());
        JTextField txtBairro = new JTextField(doador.getBairro());
        JTextField txtNumero = new JTextField(String.valueOf(doador.getNumero()));
        JTextField txtCep = new JTextField(doador.getCep());
        JTextField txtSexo = new JTextField(String.valueOf(doador.getSexo()));
        JTextField txtTipoSangue = new JTextField(doador.getTipo_sangue());
        JTextField txtNascimento = new JTextField(doador.getNascimento());
        JTextField txtNacionalidade = new JTextField(doador.getNacionalidade());
        JTextField txtAltura = new JTextField(String.valueOf(doador.getAltura()));
        JTextField txtPeso = new JTextField(String.valueOf(doador.getPeso()));
        JTextField txtEstadoCivil = new JTextField(doador.getEstado_civil());
        JTextField txtNDoacoes = new JTextField(String.valueOf(doador.getN_doacoes()));
        JTextField txtEmail = new JTextField(String.valueOf(usuario_email.getEmail()));

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

        JButton btnAtualizar = new JButton("Atualizar");
        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Atualizar os dados do doador
                    doador.setPrimeiro_nome(txtPrimeiroNome.getText());
                    doador.setSobrenome(txtSobrenome.getText());
                    doador.setCidade(txtCidade.getText());
                    doador.setEstado(txtEstado.getText());
                    doador.setRua(txtRua.getText());
                    doador.setBairro(txtBairro.getText());
                    doador.setNumero(Integer.parseInt(txtNumero.getText()));
                    doador.setCep(txtCep.getText());
                    doador.setSexo(txtSexo.getText().charAt(0));
                    doador.setTipo_sangue(txtTipoSangue.getText());
                    doador.setNascimento(txtNascimento.getText());
                    doador.setNacionalidade(txtNacionalidade.getText());
                    doador.setAltura(Float.parseFloat(txtAltura.getText()));
                    doador.setPeso(Float.parseFloat(txtPeso.getText()));
                    doador.setEstado_civil(txtEstadoCivil.getText());
                    doador.setN_doacoes(Integer.parseInt(txtNDoacoes.getText()));
                    usuario_email.setEmail(txtEmail.getText());

                    // Atualizar o doador no banco de dados
                    doadorDAO.atualizarDoador(doador);
                    usuario_emailDAO.atualizarUsuario_email(usuario_email);
                    JOptionPane.showMessageDialog(DoadorUpdateFrame.this, "Dados atualizados com sucesso!");
                    dispose(); // Fecha a janela após a atualização
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(DoadorUpdateFrame.this,
                            "Erro ao atualizar os dados: " + ex.getMessage());
                }
            }
        });

        add(btnAtualizar);

        setVisible(true);
    }
}
