package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class ItemEstoque extends EntidadeDominio{
	
	private Instrumento instrumento;
	private Integer quantidade;
	private Double custo;
	private Double total;
	private Long idEntrada;
	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getCusto() {
		return custo;
	}
	public void setCusto(Double custo) {
		this.custo = custo;
	}
	public Instrumento getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Long getIdEntrada() {
		return idEntrada;
	}
	public void setIdEntrada(Long idEntrada) {
		this.idEntrada = idEntrada;
	}
	
	
}
