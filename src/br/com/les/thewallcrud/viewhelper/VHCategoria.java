package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Categoria;
import br.com.les.thewallcrud.dominio.Subcategoria;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHCategoria implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		VHSubcategoria VHSubcategoria = new VHSubcategoria();
		Subcategoria subcategoria = (Subcategoria) VHSubcategoria.getEntidade(request);
		String stId = request.getParameter("categoria");
		Categoria categoria = new Categoria();
		if(stId != null) {
			if(!stId.equals("0")) {
				categoria.setId(Long.parseLong(stId));
			}
		}
		categoria.setSubcategoria(subcategoria);
		return categoria;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
