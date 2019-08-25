package br.com.les.thewallcrud.facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.les.thewallcrud.dao.EntradaDAO;
import br.com.les.thewallcrud.dao.FornecedorDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dao.InstrumentoDAO;
import br.com.les.thewallcrud.dao.OcorrenciaDAO;
import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.Fornecedor;
import br.com.les.thewallcrud.dominio.Instrumento;
import br.com.les.thewallcrud.dominio.Ocorrencia;
import br.com.les.thewallcrud.strategy.AlteraStatusProduto;
import br.com.les.thewallcrud.strategy.GeraCodigoInterno;
import br.com.les.thewallcrud.strategy.IStrategy;
import br.com.les.thewallcrud.strategy.StAtualizaCustoInstrumento;
import br.com.les.thewallcrud.strategy.StCarregaFornecedor;
import br.com.les.thewallcrud.strategy.StGravaItensEntrada;
import br.com.les.thewallcrud.strategy.StSetViewOcorrencia;
import br.com.les.thewallcrud.strategy.StValidaDadosInstrumentos;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class Fachada implements IFachada {

	private Map<String, IDAO> mapDAO;
	private Map<String, List<IStrategy>> mapInstrumentoStrategy;
	private Map<String, List<IStrategy>> mapOcorrenciaStrategy;
	private Map<String, List<IStrategy>> mapEntradaStrategy;
	private Map<String, List<IStrategy>> mapItemEstoqueStrategy;
	private Map<String, List<IStrategy>> mapOcorrenciaPosProcessamento;
	private Map<String, List<IStrategy>> mapEntradaPosProcessamento;
	private Map<String, Map<String, List<IStrategy>>> mapEntidadeCRUDStrategy;
	private Map<String, Map<String, List<IStrategy>>> mapEntidadeCRUDPosProcessamento;

	public Fachada() {
		mapDAO = new HashMap<String, IDAO>();
		mapInstrumentoStrategy = new HashMap<String, List<IStrategy>>();
		mapOcorrenciaStrategy = new HashMap<String, List<IStrategy>>();
		mapEntradaStrategy = new HashMap<String, List<IStrategy>>();
		mapItemEstoqueStrategy = new HashMap<String, List<IStrategy>>();
		mapEntidadeCRUDStrategy = new HashMap<String, Map<String, List<IStrategy>>>();
		mapEntidadeCRUDPosProcessamento = new HashMap<String, Map<String,List<IStrategy>>>();
		mapOcorrenciaPosProcessamento = new HashMap<String, List<IStrategy>>();
		mapEntradaPosProcessamento = new HashMap<String, List<IStrategy>>();

		// Lista Instrumento Salvar
		List<IStrategy> listStrategySalvarInstrumento = new ArrayList<>();
		listStrategySalvarInstrumento.add(new StValidaDadosInstrumentos());
		listStrategySalvarInstrumento.add(new GeraCodigoInterno());
		
		//Lista Ocorrencia Salvar
		List<IStrategy> listStrategySalvarOcorrencia = new ArrayList<>();
		listStrategySalvarOcorrencia.add(new AlteraStatusProduto());
		
		//Lista Ocorrencia Salvar Pós Processamento
		List<IStrategy> listStrategySalvarOcorrenciaPos = new ArrayList<>();
		listStrategySalvarOcorrenciaPos.add(new StSetViewOcorrencia());
		
		//Lista Entrada Pós Processamento
		List<IStrategy> listStrategySalvarEntradaPos = new ArrayList<>();
		listStrategySalvarEntradaPos.add(new StGravaItensEntrada());
		listStrategySalvarEntradaPos.add(new StAtualizaCustoInstrumento());
		//Lista Fornecedor Consultar
		//List<IStrategy> listStrategyConsultarFornecedor = new ArrayList<>();
		
		
		//Lista Entrada Salvar
		List<IStrategy> listStrategySalvarEntrada = new ArrayList<>();
		listStrategySalvarEntrada.add(new StCarregaFornecedor());
	
		
		//Lista Item Estoque Salvar
		List<IStrategy> listStrategySalvarItemEstoque = new ArrayList<>();
		
		//Lista Item Estoque Alterar
		List<IStrategy> listStrategyAlterarItemEstoque = new ArrayList<>();

		mapInstrumentoStrategy.put("SALVAR", listStrategySalvarInstrumento);
		mapOcorrenciaStrategy.put("SALVAR", listStrategySalvarOcorrencia);
		mapEntradaStrategy.put("SALVAR", listStrategySalvarEntrada);
		mapItemEstoqueStrategy.put("SALVAR", listStrategySalvarItemEstoque);
		mapItemEstoqueStrategy.put("ALTERAR", listStrategyAlterarItemEstoque);
		mapOcorrenciaPosProcessamento.put("SALVAR", listStrategySalvarOcorrenciaPos);
		mapEntradaPosProcessamento.put("SALVAR", listStrategySalvarEntradaPos);
		mapDAO.put(Instrumento.class.getSimpleName(), new InstrumentoDAO());
		mapDAO.put(Ocorrencia.class.getSimpleName(), new OcorrenciaDAO());
		mapDAO.put(Entrada.class.getSimpleName(), new EntradaDAO());
		mapDAO.put(Fornecedor.class.getSimpleName(), new FornecedorDAO());
		mapEntidadeCRUDStrategy.put(Instrumento.class.getSimpleName(), mapInstrumentoStrategy);
		mapEntidadeCRUDStrategy.put(Ocorrencia.class.getSimpleName(), mapOcorrenciaStrategy);
		mapEntidadeCRUDStrategy.put(Entrada.class.getSimpleName(), mapEntradaStrategy);
		mapEntidadeCRUDPosProcessamento.put(Ocorrencia.class.getSimpleName(), mapOcorrenciaPosProcessamento);
		mapEntidadeCRUDPosProcessamento.put(Entrada.class.getSimpleName(), mapEntradaPosProcessamento);

	}

	private Resultado validaStrategy(EntidadeDominio entidade, String operacao) {

		Resultado r = new Resultado();
		String mensagem = "";
		String mensagens = "";
		
		Map<String, List<IStrategy>> map = mapEntidadeCRUDStrategy.get(entidade.getClass().getSimpleName());
		if (map != null) {
			List<IStrategy> list = map.get(operacao);

			if (list != null) {
				for (IStrategy iStrategy : list) {
					mensagem = iStrategy.processar(entidade);
					if (mensagem != null) {
						mensagens += mensagem;
					}
				}
				if (mensagens.length() > 0) {
					r.setErro(mensagens);
				} else {
					r.setSucesso("");
				}
				r.setEntidade(entidade);
			}
		}
		return r;
	}
	
	private Resultado validaStrategyPosProcessamento(EntidadeDominio entidade, String operacao) {

		Resultado r = new Resultado();
		String mensagem = "";
		String mensagens = "";
		
		Map<String, List<IStrategy>> map = mapEntidadeCRUDPosProcessamento.get(entidade.getClass().getSimpleName());
		if (map != null) {
			List<IStrategy> list = map.get(operacao);

			if (list != null) {
				for (IStrategy iStrategy : list) {
					mensagem = iStrategy.processar(entidade);
					if (mensagem != null) {
						mensagens += mensagem;
					}
				}
				if (mensagens.length() > 0) {
					r.setErro(mensagens);
				} else {
					r.setSucesso("");
				}
				r.setEntidade(entidade);
			}
		}
		return r;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "ALTERAR");
		
		if(!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.alterar(entidade);
		}
		return resultado;
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "CONSULTAR");
		
		if(!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.consultar(entidade);
		}
		return resultado;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		
		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "EXCLUIR");
		
		if(!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.excluir(entidade);
			resultado = dao.consultar(new Instrumento());
		}
		return resultado;
	}

	@Override
	public Resultado salvar(EntidadeDominio entidade) {

		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "SALVAR");
		if (!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.salvar(entidade);
		}
		if(!resultado.getErro()) {
			resultado = validaStrategyPosProcessamento(entidade, "SALVAR");
		}
		
		return resultado;
	}

	@Override
	public Resultado consultarById(EntidadeDominio entidade) {

		Resultado resultado = new Resultado();
		resultado = validaStrategy(entidade, "CONSULTARBYID");
		
		if(!resultado.getErro()) {
			IDAO dao = mapDAO.get(entidade.getClass().getSimpleName());
			resultado = dao.consultarById(entidade);
		}
		return resultado;
	}

}
