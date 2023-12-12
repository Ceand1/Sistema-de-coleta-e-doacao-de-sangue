package telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import model.dao.DoadorDAO;
import model.dao.DoadorDoacaoDAO;
import model.dao.PostoDAO;
import model.dao.ReceptorDAO;
import model.dao.ReceptorRecebeDAO;
import model.dao.UsuarioDAO;
import model.dao.Usuario_emailDAO;
import model.entities.Usuario;

public class TelaInicialFrame extends JFrame {
    private DoadorDAO doadorDAO; // Supondo que você já tenha essa interface
    private ReceptorDAO receptorDAO;
    private PostoDAO postoDAO;
    private Usuario_emailDAO usuario_emailDAO;
    private DoadorDoacaoDAO doadorDoacaoDAO;
    private ReceptorRecebeDAO receptorRecebeDAO;

    public TelaInicialFrame(DoadorDAO doadorDAO, ReceptorDAO receptorDAO, PostoDAO postoDAO,
            Usuario_emailDAO usuario_emailDAO, DoadorDoacaoDAO doadorDoacaoDAO, ReceptorRecebeDAO receptorRecebeDAO) {
        this.doadorDAO = doadorDAO;
        this.receptorDAO = receptorDAO;
        this.postoDAO = postoDAO;
        this.usuario_emailDAO = usuario_emailDAO;
        this.doadorDoacaoDAO = doadorDoacaoDAO;
        this.receptorRecebeDAO = receptorRecebeDAO;

        setTitle("Tela Inicial");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton btnLogin = new JButton("Ir para Doador");
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame(doadorDAO, receptorDAO, postoDAO, usuario_emailDAO, doadorDoacaoDAO, receptorRecebeDAO)
                        .setVisible(true);
                dispose(); // Fecha a tela inicial quando a tela de login é aberta
            }
        });

        add(btnLogin);

        JButton btnLogin2 = new JButton("Ir para Receptor");
        btnLogin2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame2(doadorDAO, receptorDAO, postoDAO, usuario_emailDAO, doadorDoacaoDAO, receptorRecebeDAO)
                        .setVisible(true);
                dispose(); // Fecha a tela inicial quando a tela de login é aberta
            }
        });

        add(btnLogin2);

        JButton btnLogin3 = new JButton("Ir para Posto");
        btnLogin3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame3(doadorDAO, receptorDAO, postoDAO, usuario_emailDAO, doadorDoacaoDAO, receptorRecebeDAO)
                        .setVisible(true);
                dispose(); // Fecha a tela inicial quando a tela de login é aberta
            }
        });

        add(btnLogin3);

        JButton btnPesquisar = new JButton("Pesquisar Estoque");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PesquisarEstoqueFrame(postoDAO).setVisible(true);
            }
        });

        add(btnPesquisar);

        JButton btnPesquisar2 = new JButton("Pesquisar N doações");
        btnPesquisar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PesquisarDoacaoFrame(postoDAO).setVisible(true);
            }
        });

        add(btnPesquisar2);
        

        JButton btnPesquisar3 = new JButton("Média de idade por sexo");
        btnPesquisar3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MediaIdadeSexo(doadorDAO).setVisible(true);
            }
        });

        add(btnPesquisar3);

        JButton btnPesquisar4 = new JButton("Média de idade por posto");
        btnPesquisar4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MediaIdadePosto(postoDAO).setVisible(true);
            }
        });

        add(btnPesquisar4);

        JButton btnPesquisar5 = new JButton("Qantidade de doações por posto");
        btnPesquisar5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new QuantDoacao(doadorDoacaoDAO).setVisible(true);
            }
        });

        add(btnPesquisar5);

        JButton btnPesquisar6 = new JButton("Pesquisar Postos na cidade");
        btnPesquisar6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PesquisarPostoNaCidade(postoDAO).setVisible(true);
            }
        });

        add(btnPesquisar6);

        JButton btnPesquisar7 = new JButton("Pesquisar Recebedores por Posto");
        btnPesquisar7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PesquisarReceptorPosto(receptorDAO).setVisible(true);
            }
        });

        add(btnPesquisar7);

        JButton btnPesquisar8 = new JButton("Pesquisar recebidos por Posto");
        btnPesquisar8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PesquisarReceptorRecebe(receptorDAO).setVisible(true);
            }
        });

        add(btnPesquisar8);

        JButton btnPesquisar9 = new JButton("Pesquisar doações por Posto");
        btnPesquisar9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PesquisarDoadorDoacao(doadorDAO).setVisible(true);
            }
        });

        add(btnPesquisar9);

        setVisible(true);
    }
}