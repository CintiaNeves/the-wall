package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.GrupoPrecificacao;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHGrupoPrecificacao implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String stId = request.getParameter("grp-precificacao");
		
		GrupoPrecificacao grupoPrecificacao = new GrupoPrecificacao();
		if(stId != null) {
			if(!stId.equals("0")) {
				grupoPrecificacao.setId(Long.parseLong(stId));
			}
		}
		return grupoPrecificacao;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
