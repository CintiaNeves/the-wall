package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.TipoOcorrencia;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHTipoOcorrencia implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stAtivo = request.getParameter("ativo");
		String stId = null;
		TipoOcorrencia tipo = new TipoOcorrencia();
		
		if(stAtivo.equals("true")) {
			tipo.setAtivacao(false);
			stId = request.getParameter("categoria-inativacao");
		}else {
			tipo.setAtivacao(true);
			stId = request.getParameter("categoria-ativacao");
		}
		tipo.setId(Long.parseLong(stId));
		return tipo;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
