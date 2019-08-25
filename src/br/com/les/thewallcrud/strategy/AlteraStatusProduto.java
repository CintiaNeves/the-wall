package br.com.les.thewallcrud.strategy;

import java.time.LocalDate;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Ocorrencia;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class AlteraStatusProduto implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Ocorrencia ocorrencia = (Ocorrencia) entidade;
		IDAO dao = new InstrumentoDAO();
		LocalDate data = LocalDate.now();
		ocorrencia.setData(data.toString());
		if(ocorrencia.getTipo().isAtivacao()) {
			ocorrencia.getInstrumento().setAtivo(true);
		}else if(!ocorrencia.getTipo().isAtivacao()) {
			ocorrencia.getInstrumento().setAtivo(false);
		}
		Resultado resultado = dao.alterar(ocorrencia.getInstrumento());
		if(resultado.getErro()) {
			return resultado.getMensagem();
		}else {
			return "";
		}
		
		
	}

	

}
