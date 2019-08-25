package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.Categoria;
import br.com.les.thewallcrud.dominio.Subcategoria;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class SubcategoriaDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Categoria categoria = (Categoria) entidade;
		Resultado resultado = new Resultado();
		List<EntidadeDominio> subCategorias = new ArrayList<>();

		String sql = "SELECT * FROM SUBCATEGORIA ";
		boolean contemId = categoria != null && categoria.getId() > 0;
		
		if(contemId) {
			sql += "WHERE ID_CATEGORIA = ?";
		}

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			
			if(contemId) {
				stmt.setLong(1, categoria.getId());
			}
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Subcategoria s = new Subcategoria();
				s.setId(rs.getLong("ID"));
				s.setDescricao(rs.getString("DESCRICAO"));
				subCategorias.add(s);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(subCategorias);
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
		
		Subcategoria subcategoria = (Subcategoria) entidade;

		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM SUBCATEGORIA WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, subcategoria.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Subcategoria s = new Subcategoria();
				s.setId(rs.getLong("ID"));
				s.setDescricao(rs.getString("DESCRICAO"));

				resultado.setEntidade(s);
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
