package edu.fatec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import edu.fatec.entidade.Livro;

public class DaoImplLivro implements DaoLivro {

	@Override
	public void adicionar(Livro l) {
		Connection con = DaoUtil.getInstance().getConnection();
		String sql = "INSERT INTO livro " + "(preco, titulo, autor, descricao, editora) "
				+ "VALUES (?, ?, ?, ?, ?)";

		try {
			PreparedStatement st = con.prepareStatement(sql);
			//st.setInt(1, 0);
			st.setFloat(1, l.getPreco());
			st.setString(2, l.getTitulo());
			st.setString(3, l.getAutor());
			st.setString(4, l.getDescricao());
			st.setString(5, l.getEditora());
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Livro> pesquisar() {

		List<Livro> listaLivros = new ArrayList<Livro>();
		Connection con = DaoUtil.getInstance().getConnection();
		String sql = "SELECT * FROM livro";

		try {

			PreparedStatement st = con.prepareStatement(sql);
			st.executeQuery();
			ResultSet rs = st.getResultSet();

			while (rs.next()) {
				Livro livro = new Livro();

				livro.setId(rs.getInt("id"));
				livro.setAutor(rs.getString("autor"));
				livro.setDescricao(rs.getString("descricao"));
				livro.setEditora(rs.getString("editora"));
				livro.setPreco(rs.getFloat("preco"));
				livro.setTitulo(rs.getString("titulo"));

				listaLivros.add(livro);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaLivros;
	}

}
