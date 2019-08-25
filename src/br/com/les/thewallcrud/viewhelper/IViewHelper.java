package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public interface IViewHelper {
	
	public EntidadeDominio getEntidade(HttpServletRequest request);
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response);
	
}
