package model.dao;

import model.entities.Usuario_email;

public interface Usuario_emailDAO {
    void adicionarUsuario_email(Usuario_email usuario_email);

    Usuario_email buscarUsuario_email(String cpf);

    void atualizarUsuario_email(Usuario_email usuario_email);

    void removerUsuario_email(String cpf);
}
