package br.com.les.thewallcrud.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.les.thewallcrud.command.CmdAlterar;
import br.com.les.thewallcrud.command.CmdConsultar;
import br.com.les.thewallcrud.command.CmdConsultarById;
import br.com.les.thewallcrud.command.CmdExcluir;
import br.com.les.thewallcrud.command.CmdSalvar;
import br.com.les.thewallcrud.command.ICommand;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;
import br.com.les.thewallcrud.viewhelper.IViewHelper;
import br.com.les.thewallcrud.viewhelper.VHInstrumento;

@WebServlet(urlPatterns = {"/instrumento"})
@SuppressWarnings("serial")
public class InstrumentoController extends HttpServlet{

	private Map<String, ICommand> mapCommand;

	public InstrumentoController() {
		
		mapCommand = new HashMap<String, ICommand>();
		
		mapCommand.put("SALVAR", new CmdSalvar());
		mapCommand.put("CONSULTAR", new CmdConsultar());
		mapCommand.put("ALTERAR", new CmdAlterar());
		mapCommand.put("EXCLUIR", new CmdExcluir());
		mapCommand.put("CONSULTARBYID", new CmdConsultarById());
		
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) {
		
		String operacao = request.getParameter("btnOperacao");
		ICommand command = mapCommand.get(operacao);
		IViewHelper vhInstrumento = new VHInstrumento();
		EntidadeDominio entidade = vhInstrumento.getEntidade(request);
		Resultado resultado = command.executar(entidade);
		vhInstrumento.setView(resultado, request, response);
	}
	
	
}
