package br.com.les.thewallcrud.dominio;

import java.util.ArrayList;
import java.util.List;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Entrada extends EntidadeDominio{
	
	private Fornecedor fornecedor;
	private List<ItemEstoque> itens;
	private String nota;
	private String data;
	
	public Entrada() {
		itens = new ArrayList<>();
	}
	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<ItemEstoque> getItens() {
		return itens;
	}

	public void setItens(List<ItemEstoque> itens) {
		this.itens = itens;
	}
	
	
	
}
