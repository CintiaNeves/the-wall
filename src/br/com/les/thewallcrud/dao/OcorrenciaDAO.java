package br.com.les.thewallcrud.dao;

import java.sql.PreparedStatement;

import br.com.les.thewallcrud.dominio.Ocorrencia;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class OcorrenciaDAO extends AbstractDao {

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

		Ocorrencia ocorrencia = (Ocorrencia) entidade;
		Resultado resultado = new Resultado();
		String sql = null;

		sql = "INSERT INTO OCORRENCIA (DT_OCORRENCIA, ID_INSTRUMENTO, "
				+ "TIPO_ATIVAR, JUSTIFICATIVA, ID_CATEGORIA_TIPO) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {

			stmt.setString(1, ocorrencia.getData());
			stmt.setLong(2, ocorrencia.getInstrumento().getId());
			stmt.setInt(3, ocorrencia.getTipo().isAtivacao() ? 1 : 0);
			stmt.setString(4, ocorrencia.getJustificativa());
			stmt.setLong(5, ocorrencia.getTipo().getId());

			stmt.execute();
			
			if(ocorrencia.getInstrumento().isAtivo()) {
				resultado.setSucesso("Instrumento Ativado com sucesso");
			}else {
				resultado.setSucesso("Instrumento Inativado com sucesso");
			}
			
			resultado.setEntidade(ocorrencia);
		} catch (Exception e) {
			resultado.setErro("Operação não registrada.");
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
