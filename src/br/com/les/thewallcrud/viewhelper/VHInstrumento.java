package br.com.les.thewallcrud.viewhelper;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.les.thewallcrud.dominio.Categoria;
import br.com.les.thewallcrud.dominio.GrupoPrecificacao;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.strategy.StSetViewInstrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHInstrumento implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {

		VHGrupoPrecificacao VHGrupoprecificacao = new VHGrupoPrecificacao();
		GrupoPrecificacao grupoPrecificacao = (GrupoPrecificacao) VHGrupoprecificacao.getEntidade(request);

		VHCategoria VHCategoria = new VHCategoria();
		Categoria categoria = (Categoria) VHCategoria.getEntidade(request);

		String stId = request.getParameter("id");
		String stCodigo = request.getParameter("codigo");
		String stDescricao = request.getParameter("descricao");
		String stMarca = request.getParameter("marca");
		String stModelo = request.getParameter("modelo");
		String stCor = request.getParameter("cor");
		String stEspecificacoes = request.getParameter("especificacoes");

		Instrumento instrumento = new Instrumento();

		if (stId != null) {
			if (!stId.trim().equals("")) {
				instrumento.setId(Long.parseLong(stId));
			}
		}
		instrumento.setAtivo(true);
		instrumento.setCodigo(stCodigo);
		instrumento.setDescricao(stDescricao);
		instrumento.setMarca(stMarca);
		instrumento.setModelo(stModelo);
		instrumento.setCor(stCor);
		instrumento.setEspecificacoes(stEspecificacoes);
		instrumento.setGrupoPrecificacao(grupoPrecificacao);
		instrumento.setCategoria(categoria);
		return instrumento;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {

		StSetViewInstrumento st = new StSetViewInstrumento();
		Instrumento instrumento;
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");

		try {
			RequestDispatcher rd;
			if (operacao.equals("SALVAR")) {

				for (EntidadeDominio i : resultado.getListEntidade()) {
					st.processar(i);
				}
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("instrumentos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("instrumentos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("CONSULTAR")) {
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
				} else {

					for (EntidadeDominio i : resultado.getListEntidade()) {
						st.processar(i);
					}
					if (resultado.getErro()) {
						request.setAttribute("erro", mensagem);
						request.setAttribute("instrumentos", resultado.getListEntidade());
						rd = request.getRequestDispatcher("consulta.jsp");
					} else {
						request.setAttribute("sucesso", mensagem);
						request.setAttribute("instrumentos", resultado.getListEntidade());
						rd = request.getRequestDispatcher("consulta.jsp");
					}
					rd.forward(request, response);
				}

			} else if (operacao.equals("ALTERAR")) {

				for (EntidadeDominio i : resultado.getListEntidade()) {
					st.processar(i);
				}
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("instrumentos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("instrumentos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("EXCLUIR")) {
				mensagem[0] = "Cadastro excluído com Sucesso";

				if (resultado.getEntidade() != null) {
					for (EntidadeDominio i : resultado.getListEntidade()) {
						st.processar(i);
					}
				}
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("instrumentos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("instrumentos", resultado.getListEntidade());
					rd = request.getRequestDispatcher("consulta.jsp");
				}
				rd.forward(request, response);
			} else if (operacao.equals("CONSULTARBYID")) {

				for (EntidadeDominio i : resultado.getListEntidade()) {
					st.processar(i);
				}
				instrumento = (Instrumento) resultado.getEntidade();
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("instrumento", instrumento);
					rd = request.getRequestDispatcher("cadastro.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("instrumento", instrumento);
					rd = request.getRequestDispatcher("cadastro.jsp");
				}
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
