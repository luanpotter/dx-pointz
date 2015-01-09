package br.com.dextra.pointz.models;

import io.yawp.repository.IdRef;
import io.yawp.repository.annotations.Endpoint;
import io.yawp.repository.annotations.Id;
import io.yawp.repository.annotations.Index;

@Endpoint(path = "/transactions")
public class Transaction {

	@Id
	private IdRef<Transaction> id;

	@Index
	private IdRef<Person> personId;

	private TransactionType type;

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
}
