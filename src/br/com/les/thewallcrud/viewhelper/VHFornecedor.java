package br.com.les.thewallcrud.viewhelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Fornecedor;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHFornecedor implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		String stCnpj = request.getParameter("cnpj");
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCnpj(stCnpj);
		return fornecedor;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		String operacao = request.getParameter("btnOperacao");

		try {

			if (operacao.equals("CONSULTAR")) {

				if (request.getParameter("retornoJson") != null
						&& Boolean.parseBoolean(request.getParameter("retornoJson")) == true) {
					response.addHeader("Access-Control-Allow-Origin", "*");
					response.setContentType("application/json");
					response.setCharacterEncoding("utf-8");
					ObjectMapper mapper = new ObjectMapper();
					try {
						String json = mapper.writeValueAsString(resultado.getEntidade());
						response.getWriter().write(json);
						response.getWriter().flush();
					} catch (JsonProcessingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
