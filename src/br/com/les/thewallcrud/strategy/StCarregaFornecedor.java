package br.com.les.thewallcrud.strategy;

import br.com.les.thewallcrud.dao.FornecedorDAO;
import br.com.les.thewallcrud.dao.IDAO;
import br.com.les.thewallcrud.dominio.Entrada;
import br.com.les.thewallcrud.dominio.Fornecedor;
import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public class StCarregaFornecedor implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {

		Entrada entrada = (Entrada) entidade;
		IDAO dao = new FornecedorDAO();
		Resultado resultado = dao.consultar(entrada.getFornecedor());
		Fornecedor fornecedor = (Fornecedor) resultado.getEntidade();
		if(!resultado.getErro())
			entrada.setFornecedor(fornecedor);
		return null;
	}

}
