package br.com.les.thewallcrud.command;

import br.com.les.thewallcrud.facade.Fachada;
import br.com.les.thewallcrud.facade.IFachada;

public abstract class AbstractCommand implements ICommand{

	protected IFachada fachada = new Fachada();
}
