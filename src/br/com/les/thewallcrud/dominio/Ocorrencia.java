package br.com.les.thewallcrud.dominio;

import br.com.les.thewallcrud.util.EntidadeDominio;

public class Ocorrencia extends EntidadeDominio{
	
	private String data;
	private Instrumento instrumento; 
	private String justificativa;
	private TipoOcorrencia tipo;
		
	public String getData() {
		return data;
	}
	public void setData(String string) {
		this.data = string;
	}
	public Instrumento getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(Instrumento instrumento) {
		this.instrumento = instrumento;
	}
	
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public TipoOcorrencia getTipo() {
		return tipo;
	}
	public void setTipo(TipoOcorrencia tipo) {
		this.tipo = tipo;
	}
		
	
}
