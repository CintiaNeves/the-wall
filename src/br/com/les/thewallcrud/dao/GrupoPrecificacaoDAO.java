package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.dominio.GrupoPrecificacao;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class GrupoPrecificacaoDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		List<EntidadeDominio> grupos = new ArrayList<>();

		String sql = "SELECT * FROM GRUPO_PRECIFICACAO";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				GrupoPrecificacao g = new GrupoPrecificacao();
				g.setId(rs.getLong("ID"));
				g.setDescricao(rs.getString("DESCRICAO"));
				g.setMargemLucro(rs.getDouble("MARGEM_LUCRO"));
				grupos.add(g);
			}
			rs.close();
			resultado.setSucesso("");
			resultado.setListEntidade(grupos);
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
		
		GrupoPrecificacao grupoPrecificacao = (GrupoPrecificacao) entidade;

		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM GRUPO_PRECIFICACAO WHERE ID = ?";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, grupoPrecificacao.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				GrupoPrecificacao g = new GrupoPrecificacao();
				g.setId(rs.getLong("ID"));
				g.setDescricao(rs.getString("DESCRICAO"));
				g.setMargemLucro(rs.getDouble("MARGEM_LUCRO"));
				
				resultado.setEntidade(g);
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
