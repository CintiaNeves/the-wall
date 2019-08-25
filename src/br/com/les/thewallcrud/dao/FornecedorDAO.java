package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.les.thewallcrud.dominio.Fornecedor;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class FornecedorDAO extends AbstractDao {

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Fornecedor fornecedor = (Fornecedor) entidade;

		Resultado resultado = new Resultado();

		String sql = "SELECT * FROM FORNECEDOR ";

		boolean contemCnpj = fornecedor != null && fornecedor.getCnpj() != null;
		
		if (contemCnpj)
			sql += "WHERE CNPJ = ? ";
		

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			if (contemCnpj)
				stmt.setString(1, fornecedor.getCnpj());

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				
				fornecedor.setId(rs.getLong("ID"));
				fornecedor.setCnpj(rs.getString("CNPJ"));
				fornecedor.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
			}
			rs.close();
			resultado.setEntidade(fornecedor);
			resultado.setSucesso("");
		} catch (SQLException e) {
			resultado.setErro("Consulta não realizada.\n");
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
		// TODO Auto-generated method stub
		return null;
	}

}
