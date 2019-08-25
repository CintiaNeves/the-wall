package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;

import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class ItemEstoqueDAO extends AbstractDao{

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		ItemEstoque item = (ItemEstoque) entidade;
		Resultado resultado = new Resultado();

		String sql = "INSERT INTO ITEM_ESTOQUE (ID_INSTRUMENTO, QUANTIDADE, CUSTO, TOTAL, ID_ENTRADA) VALUES (?, ?, ?, ?, ?)";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setLong(1, item.getInstrumento().getId());
			stmt.setInt(2, item.getQuantidade());
			stmt.setDouble(3, item.getCusto());
			stmt.setDouble(4, item.getCusto() * item.getQuantidade());
			stmt.setLong(5, item.getIdEntrada());

			stmt.execute();
			resultado.setSucesso("Entrada Realizada com Sucesso.");
			resultado.setEntidade(item);
		} catch (Exception e) {
			resultado.setErro("Inclusão não realizada.");
			e.printStackTrace();
		}
		return resultado;

	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
