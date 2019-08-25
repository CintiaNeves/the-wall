package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class TipoOcorrencia extends EntidadeDominio{

	private Boolean ativacao;
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getAtivacao() {
		return ativacao;
	}

	public Boolean isAtivacao() {
		return ativacao;
	}
	
	public void setAtivacao(Boolean ativacao) {
		this.ativacao = ativacao;
	}

	
	
	
}
