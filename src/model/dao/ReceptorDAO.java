package model.dao;

import java.util.List;

import model.entities.Receptor;
import model.entities.ReceptorRecebe;
import model.entities.Usuario;

public interface ReceptorDAO {
    void adicionarReceptor(Receptor receptor);

    Receptor buscarReceptor(String cpf);

    List<Usuario> listarReceptorPosto(String n_registro);

    List<ReceptorRecebe> listarReceptorRecebe(String n_registro);

    void atualizarReceptor(Receptor receptor);

    void removerReceptor(String cpf);
}