package model.dao;

import model.entities.Usuario;

public interface UsuarioDAO {
    void adicionarUsuario(Usuario usuario);

    Usuario buscarUsuario(String cpf);

    void atualizarUsuario(Usuario usuario);

    void removerUsuario(String cpf);
}