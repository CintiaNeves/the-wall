package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.GrupoPrecificacaoDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.GrupoPrecificacao;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StAtualizaCustoInstrumento implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Entrada entrada = (Entrada) entidade;
		Resultado resultado = new Resultado();
		InstrumentoDAO daoInstrumento = new InstrumentoDAO();
		GrupoPrecificacaoDAO daoGrupo = new GrupoPrecificacaoDAO();
		Instrumento instrumento = new Instrumento();
		GrupoPrecificacao grupo = new GrupoPrecificacao();
		Double icmsSP = 1.18;
		Double custoIndireto = 1.30;
		
		for(ItemEstoque item : entrada.getItens()) {
			resultado = daoInstrumento.consultar(item.getInstrumento());
			if(!resultado.getErro())
				instrumento = (Instrumento) resultado.getEntidade();
			resultado = daoGrupo.consultar(instrumento.getGrupoPrecificacao());
			if(!resultado.getErro())
			grupo = (GrupoPrecificacao) resultado.getEntidade();
			
			if(instrumento.getValorCusto() == null || instrumento.getValorCusto() == 0 || instrumento.getValorCusto() < item.getCusto()) {
				instrumento.setValorCusto(item.getCusto());
				instrumento.setValorVenda(((instrumento.getValorCusto() * custoIndireto) * icmsSP) * grupo.getMargemLucro());
				daoInstrumento.alterar(instrumento);
			}
		}
		return null;
	}

}
