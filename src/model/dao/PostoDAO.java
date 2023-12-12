package model.dao;

import java.util.List;

import model.entities.Posto;

public interface PostoDAO {
    void adicionarPosto(Posto posto);

    Posto buscarPosto(String n_registro);

    List<Posto> buscarPostosNaCidade(String cidade);

    void atualizarPosto(Posto posto);

    void removerPosto(String n_registro);

    int pesquisarQuantidadeSangue(String registroPosto, String tipoSangue);

    int pesquisarQuantidadeDoacoes(String registroPosto);

    int mediaIdadePosto(String registro_posto, String sexo);
}
