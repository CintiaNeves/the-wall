package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Instrumento extends EntidadeDominio{

	private boolean ativo;
	private String codigo;
	private String descricao;
	private String marca;
	private String modelo;
	private String cor;
	private String especificacoes;
	private Double valorCusto;
	private Double valorVenda; 
	
	private GrupoPrecificacao grupoPrecificacao;
	private Categoria categoria;
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getEspecificacoes() {
		return especificacoes;
	}
	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}
	public GrupoPrecificacao getGrupoPrecificacao() {
		return grupoPrecificacao;
	}
	public void setGrupoPrecificacao(GrupoPrecificacao grupoPrecificacao) {
		this.grupoPrecificacao = grupoPrecificacao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Double getValorCusto() {
		return valorCusto;
	}
	public void setValorCusto(Double valorCusto) {
		this.valorCusto = valorCusto;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
}
