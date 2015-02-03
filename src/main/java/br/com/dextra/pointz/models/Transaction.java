package br.com.dextra.pointz.models;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;

import java.util.Date;

@Endpoint(path = "/transactions")
public class Transaction {

	@Id
	private IdRef<Transaction> id;

	@Index
	private IdRef<Person> personId;

	@Index
	private TransactionType type;

	@Index
	private Date date;

	private String reference;

	public IdRef<Person> getPerson() {
		return personId;
	}

	public IdRef<Transaction> getId() {
		return id;
	}

	public TransactionType getType() {
		return type;
	}

	public int getPointz() {
		return type.getPointz();
	}

	public Date getDate() {
		return date;
	}

	public String getReference() {
		return reference;
	}
}
