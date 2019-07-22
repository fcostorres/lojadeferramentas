package model.dao;

import java.util.List;

/**
 *
 * @author USUARIO
 */
public interface iDAO<T>{
    public String idTabela();
   public T salvar(T t);
   public T alterar(T t);
   public void excluir(String id);
   public List<T> buscar();
   public List<T> buscar(String id);
   public List<T> buscar(String[] params);
}
