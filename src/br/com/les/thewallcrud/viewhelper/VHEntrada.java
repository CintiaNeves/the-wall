package br.com.les.thewallcrud.viewhelper;

import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.Fornecedor;
import br.com.les.thewallcrud.dominio.ItemEstoque;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHEntrada implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		Integer linhas = 0;
		IViewHelper vhFornecedor = new VHFornecedor();
		IViewHelper vhItemEstoque = new VHItemEstoque();
		Entrada entrada = new Entrada();
		String stCodigo = null;
		String stQuantidade = null;
		String stCusto = null;
		Fornecedor fornecedor = (Fornecedor) vhFornecedor.getEntidade(request);
		String stLinhas = request.getParameter("linhas");
		String stNota = request.getParameter("nota");
		LocalDate data = LocalDate.now();
		
		if(stLinhas != null && (!stLinhas.trim().equals(""))) {
			 linhas = Integer.parseInt(stLinhas);
		}
		
		for(Integer i = 0; i < linhas; i++) {
			if(i == 0) {
				stCodigo = request.getParameter("codigo");
				stQuantidade = request.getParameter("quantidade");
				stCusto = request.getParameter("custo");
			}else {
				stCodigo = request.getParameter("codigo".concat(i.toString()));
				stQuantidade = request.getParameter("quantidade".concat(i.toString()));
				stCusto = request.getParameter("custo".concat(i.toString()));
			}
			ItemEstoque item = (ItemEstoque) vhItemEstoque.getEntidade(request);
			
			item.getInstrumento().setCodigo(stCodigo);
			if(stQuantidade != null && (!stQuantidade.trim().equals("")))
				item.setQuantidade(Integer.parseInt(stQuantidade));
			if(stCusto != null && (!stCusto.trim().equals("")))
				item.setCusto(Double.parseDouble(stCusto));
			
			entrada.getItens().add(item);
		}
		
		entrada.setFornecedor(fornecedor);
		entrada.setNota(stNota);
		entrada.setData(data.toString());

		return entrada;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		String operacao = request.getParameter("btnOperacao");

		String mensagem[] = resultado.getMensagem().split("\n");

		try {
			RequestDispatcher rd;
			if (operacao.equals("SALVAR")) {
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("entrada", resultado.getEntidade());
					rd = request.getRequestDispatcher("entrada.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("entrada", resultado.getEntidade());
					rd = request.getRequestDispatcher("entrada.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("CONSULTAR")) {
				
				if(request.getParameter("retornoJson") != null && Boolean.parseBoolean(request.getParameter("retornoJson")) == true) {
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
