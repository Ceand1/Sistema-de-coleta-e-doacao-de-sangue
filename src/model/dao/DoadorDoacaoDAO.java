package model.dao;

import java.util.List;

import model.entities.DoadorDoacao;

public interface DoadorDoacaoDAO {
    void adicionarDoadorDoacao(DoadorDoacao doadorDoacao);

    public List<DoadorDoacao> listarTodos();

    public void atualizarDoadorDoacao(DoadorDoacao doadorDoacao);

    public void removerDoadorDoacao(String cpfDoador);

    int quantDoacao(String registro_posto, String sexo);
}
