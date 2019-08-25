package br.com.les.thewallcrud.strategy;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class GeraCodigoInterno implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Instrumento instrumento = (Instrumento) entidade;
		
		IDAO dao = new InstrumentoDAO();
		boolean possuiCodigo = instrumento.getCodigo().trim().length() > 0 ? true : false;
		Resultado r = dao.consultar(new Instrumento());
		Integer index = r.getListEntidade().size();
		Long maxId = r.getListEntidade() != null 
				&& r.getListEntidade().size() > 0 
				? r.getListEntidade().get(index -1).getId() + 1 : 1;
		
		if(!possuiCodigo) {
			Calendar calendar = GregorianCalendar.getInstance();
			Integer ano = calendar.get(Calendar.YEAR);
			String codigo = ano.toString().concat(maxId.toString());
			instrumento.setCodigo(codigo);
		}
		return null;
	}

}
