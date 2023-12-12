package model.dao;

import java.util.List;

import model.entities.PostoEstoque;

public interface PostoEstoqueDAO {
    void adicionarPostoEstoque(PostoEstoque postoEstoque);

    public List<PostoEstoque> listarTodos();

    public void atualizarPostoEstoque(PostoEstoque postoEstoque);

    public void removerPostoEstoque(String registroPosto);
}
