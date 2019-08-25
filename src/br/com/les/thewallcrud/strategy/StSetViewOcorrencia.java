package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.Ocorrencia;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StSetViewOcorrencia implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Ocorrencia ocorrencia = (Ocorrencia) entidade;
		Instrumento instrumento = ocorrencia.getInstrumento();
		InstrumentoDAO dao = new InstrumentoDAO();
		Resultado resultado = dao.consultarById(instrumento);
		
		if(!resultado.getErro()) {
			ocorrencia.setInstrumento((Instrumento) resultado.getEntidade());
		}
		
		return null;
	}

}
