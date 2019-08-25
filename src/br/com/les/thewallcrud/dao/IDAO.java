package br.com.les.thewallcrud.dao;

import br.com.les.thewallcrud.util.EntidadeDominio;
import br.com.les.thewallcrud.util.Resultado;

public interface IDAO {

	public Resultado alterar (EntidadeDominio entidade);
	public Resultado consultar (EntidadeDominio entidade);
	public Resultado excluir (EntidadeDominio entidade);
	public Resultado salvar (EntidadeDominio entidade);
	public Resultado consultarById(EntidadeDominio entidade);
}
