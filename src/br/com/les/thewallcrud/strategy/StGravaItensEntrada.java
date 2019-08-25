package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.ItemEstoqueDAO;
import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StGravaItensEntrada implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Entrada entrada = (Entrada) entidade;
		InstrumentoDAO daoInstrumento = new InstrumentoDAO();
		ItemEstoqueDAO daoItemEstoque = new ItemEstoqueDAO();
		Instrumento instrumento = new Instrumento();
		Resultado resultado = new Resultado();
		
		if(entrada.getItens() != null) {
			for(ItemEstoque item : entrada.getItens()) {
				resultado = daoInstrumento.consultar(item.getInstrumento());
				instrumento = (Instrumento) resultado.getEntidade();
				if(!resultado.getErro())
					item.setInstrumento(instrumento);
				item.setIdEntrada(entrada.getId());
				
				resultado = daoItemEstoque.salvar(item);
			}
		}
		
		return null;
	}

}
