package br.com.les.thewallcrud.dao;

import java.sql.Connection;

import br.com.les.thewallcrud.util.ConnectionFactory;

public abstract class AbstractDao implements IDAO{
	
	Connection connection = new ConnectionFactory().getConnection();
}
