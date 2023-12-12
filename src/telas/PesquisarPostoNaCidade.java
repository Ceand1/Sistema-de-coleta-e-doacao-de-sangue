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
import model.entities.Posto;

public class PesquisarPostoNaCidade extends JFrame {
    private PostoDAO postoDAO; // DAO para acessar os dados dos postos
    private JTable table;
    private DefaultTableModel tableModel;

    public PesquisarPostoNaCidade(PostoDAO postoDAO) {
        this.postoDAO = postoDAO;
        this.tableModel = new DefaultTableModel(new Object[] { "n_registro", "Cidade", "Estado", "Rua", "Bairro", "Numero", "Cep" }, 0);
        this.table = new JTable(tableModel);

        setTitle("Pesquisar postos");
        setSize(1200, 200);
        setLayout(new GridLayout(0, 2));

        JTextField txtCidadeDoPosto = new JTextField();
        JTextArea txtResultado = new JTextArea(10, 20);
        txtResultado.setEditable(false);

        add(new JLabel("Cidade:"));
        add(txtCidadeDoPosto);
        add(createUserTablePanel());

        JButton btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cidadePosto = txtCidadeDoPosto.getText();

                List<Posto> postos = postoDAO.buscarPostosNaCidade(cidadePosto);
                tableModel.setRowCount(0); // Limpa a tabela
                for (Posto posto : postos) {
                    tableModel.addRow(new Object[] { posto.getN_registro(), posto.getCidade(), posto.getEstado(), posto.getRua(), posto.getBairro(), posto.getNumero(), posto.getCep() });
                }
            }
        });
        add(btnPesquisar);

        setVisible(true);
    }
    private JPanel createUserTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        tableModel = new DefaultTableModel(new String[] { "n_registro", "Cidade", "Estado", "Rua", "Bairro", "Numero", "Cep" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }
}
