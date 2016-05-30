package fatec.edu.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import edu.fatec.dao.DaoImplLivro;
import edu.fatec.dao.DaoLivro;
import edu.fatec.entidade.Livro;

@ManagedBean
@SessionScoped
public class LivroMB {

	private List<Livro> listLivro = new ArrayList<Livro>();
	private Livro livro = new Livro();
	private DaoLivro daoLivro = new DaoImplLivro();

	public String adicionar() {
		daoLivro.adicionar(livro);
		livro = new Livro();
		FacesMessage msg = new FacesMessage("Livro adicionado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		return "livro";
	}
	
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLista(List<Livro> lista) {
		this.listLivro = lista;
	}
	public List<Livro> getLista() {
		
		listLivro = daoLivro.pesquisar();
	 	FacesMessage msg = new FacesMessage("Pesquisa realizada com sucesso");
	 	FacesContext.getCurrentInstance().addMessage(null, msg);
		
		return listLivro;
	}

}
