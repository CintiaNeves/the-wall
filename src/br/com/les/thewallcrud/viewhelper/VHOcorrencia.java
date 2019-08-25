package br.com.les.thewallcrud.viewhelper;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.Ocorrencia;
import br.com.les.thewallcrud.dominio.TipoOcorrencia;
import br.com.les.thewallcrud.strategy.StSetViewInstrumento;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class VHOcorrencia implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		VHInstrumento vhInstrumento = new VHInstrumento();
		Instrumento instrumento = (Instrumento) vhInstrumento.getEntidade(request);
		VHTipoOcorrencia VHtipo = new VHTipoOcorrencia();
		TipoOcorrencia tipo = (TipoOcorrencia) VHtipo.getEntidade(request);
		String stJustificativa = request.getParameter("justificativa");
		
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setInstrumento(instrumento);
		ocorrencia.setTipo(tipo);
		ocorrencia.setJustificativa(stJustificativa);
		
		return ocorrencia;
	}

	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		
		StSetViewInstrumento st = new StSetViewInstrumento();
		String operacao = request.getParameter("btnOperacao");
		String mensagem[] = resultado.getMensagem().split("\n");
		Ocorrencia ocorrencia = (Ocorrencia) resultado.getEntidade();
		Instrumento instrumento = ocorrencia.getInstrumento();
		List<Instrumento> instrumentos = new ArrayList<Instrumento>();
		instrumentos.add(instrumento);
		
		try {
			RequestDispatcher rd ;
			if (operacao.equals("SALVAR")) {
				
				if(instrumentos != null) {
					for(EntidadeDominio i : instrumentos){
						st.processar(i);
					}
				}
				if (resultado.getErro()) {
					request.setAttribute("erro", mensagem);
					request.setAttribute("instrumentos", instrumentos);
					rd = request.getRequestDispatcher("consulta.jsp");
				} else {
					request.setAttribute("sucesso", mensagem);
					request.setAttribute("instrumentos", instrumentos);
					rd = request.getRequestDispatcher("consulta.jsp");
				}
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
