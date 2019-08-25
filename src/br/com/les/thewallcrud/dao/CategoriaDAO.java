package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Categoria;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class CategoriaDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		List<EntidadeDominio> categorias = new ArrayList<>();

		String sql = "SELECT * FROM CATEGORIA";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getLong("ID"));
				c.setDescricao(rs.getString("DESCRICAO"));
				categorias.add(c);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(categorias);
		} catch (SQLException e) {
			resultado.setErro("Erro de consulta");
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		
		Categoria categoria = (Categoria) entidade;

		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM CATEGORIA WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, categoria.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getLong("ID"));
				c.setDescricao(rs.getString("DESCRICAO"));

				resultado.setEntidade(c);
			}
			rs.close();
			resultado.setSucesso("");
		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
			e.printStackTrace();
		}
		return resultado;
	}

}
