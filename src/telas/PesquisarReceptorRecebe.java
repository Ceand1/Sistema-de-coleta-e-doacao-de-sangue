package telas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.dao.PostoDAO; // Assumindo que você tem um DAO para Posto
import model.dao.ReceptorDAO;
import model.dao.UsuarioDAO;
import model.entities.Posto;
import model.entities.Receptor;
import model.entities.ReceptorRecebe;
import model.entities.Usuario;

public class PesquisarReceptorRecebe extends JFrame {
    private ReceptorDAO receptorDAO; // DAO para acessar os dados dos postos
    private JTable table;
    private DefaultTableModel tableModel;

    public PesquisarReceptorRecebe(ReceptorDAO receptorDAO) {
        this.receptorDAO = receptorDAO;
        this.tableModel = new DefaultTableModel(new Object[] { "cpf", "primeiro_nome", "sobrenome",  "n_registro","tipo_sangue", "data_recebe" }, 0);
        this.table = new JTable(tableModel);

        setTitle("Pesquisar recebidos");
        setSize(1400, 400);
        setLayout(new GridLayout(0, 2));

        JTextField txtNumeroRegitroPosto = new JTextField();
        JTextArea txtResultado = new JTextArea(10, 20);
        txtResultado.setEditable(false);

        add(new JLabel("n_registro:"));
        add(txtNumeroRegitroPosto);
        add(createUserTablePanel());

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String numeroRegistro = txtNumeroRegitroPosto.getText();

                List<ReceptorRecebe> recebes = receptorDAO.listarReceptorRecebe(numeroRegistro);
                tableModel.setRowCount(0); // Limpa a tabela
                for (ReceptorRecebe recebe : recebes) {
                    tableModel.addRow(new Object[] {recebe.getCpfReceptor(), recebe.getPrimeiroNome(), recebe.getSobrenome(), recebe.getTipoSangue() ,  recebe.getRegistroPosto(), recebe.getDataReceber() });
                }
            }
        });
        add(btnPesquisar);

        setVisible(true);
    }
    private JPanel createUserTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new String[] { "cpf", "primeiro_nome", "sobrenome",  "n_registro","tipo_sangue", "data_recebe" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }
}
