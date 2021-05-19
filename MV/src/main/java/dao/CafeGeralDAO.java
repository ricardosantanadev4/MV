package dao;

import java.util.List;

public interface CafeGeralDAO {
	public void linha();

	public void top();

	public void inserir(Object obj);

	public List buscarTodos(Object obj);

	public void remover(Class classe, Object primaryKey);

	public void atualizar(Object obj);
}
