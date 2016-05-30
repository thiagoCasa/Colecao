package edu.fatec.dao;

import java.util.List;
import edu.fatec.entidade.Livro;

public interface DaoLivro {
	public void adicionar(Livro l);
	List<Livro> pesquisar();
}
