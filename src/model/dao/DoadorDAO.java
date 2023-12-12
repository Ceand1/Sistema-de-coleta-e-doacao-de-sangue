package model.dao;

import java.util.List;

import model.entities.Doador;
import model.entities.DoadorDoacao;

public interface DoadorDAO {
    void adicionarDoador(Doador doador);

    Doador buscarDoador(String cpf);

    List<DoadorDoacao> listarDoadorDoacao(String n_registro);

    void atualizarDoador(Doador doador);

    void removerDoador(String cpf);

    int mediaIdadeSexo(String sexo);
}
