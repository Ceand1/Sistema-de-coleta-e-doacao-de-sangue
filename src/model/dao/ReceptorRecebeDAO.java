package model.dao;

import java.util.List;

import model.entities.ReceptorRecebe;

public interface ReceptorRecebeDAO {
    void adicionarReceptorRecebe(ReceptorRecebe receptorRecebe);

    public List<ReceptorRecebe> listarTodos();

    public void atualizarReceptorRecebe(ReceptorRecebe receptorRecebe);

    public void removerReceptorRecebe(String cpfReceptor);
}
